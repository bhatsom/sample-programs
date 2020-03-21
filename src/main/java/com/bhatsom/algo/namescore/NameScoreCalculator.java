package com.bhatsom.algo.namescore;

import com.bhatsom.algo.models.Name;
import com.bhatsom.algo.utils.FileReaderUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NameScoreCalculator {

	public static void main(String[] args) {

		if (args.length <1) {
			System.out.println("Insufficient arguments! Please enter the full path to names file.");
			return;
		}

		try {
			// define your own algorithm to score an individual name
			INameScoringAlgo scoringAlgo = new ScoringAlgoByFirstName();

			System.out.println("Total score: " + calculateNameScore(args[0], scoringAlgo));
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	public static int calculateNameScore(String fileName, INameScoringAlgo scoringAlgo) throws Exception {
		// read the line containing names
		String[] namesArray = FileReaderUtil.readSingleCommaSeparatedLine(fileName, 1, false);

		// map each first name to a Name domain model
		List<Name> names = convertTextsToNames(namesArray);

		// finally, use the calculator to calculate total score
		return sortAndCalcScoreForNameList(names, scoringAlgo);
	}

	private static List<Name> convertTextsToNames(String[] namesArray) {
		return Stream.of(namesArray)
				.map(s -> s.trim()) // remove unwanted leading and trailing whitespaces
				.filter(s -> s.length() != 0) // filter empty names
				.map(s -> s.split(" "))
				.map(s -> new Name(s[0], s.length > 1? s[1] : null))
				.collect(Collectors.toList());
	}

	private static int sortAndCalcScoreForNameList(List<Name> names, INameScoringAlgo scoringAlgo) {
		// pre Java 8
		/*Collections.sort(names, new Comparator<Name>() {

			public int compare(Name n, Name n1) {
				int val = n.getFirstName().compareTo(n1.getFirstName());
				if (val != 0) {
					return val;
				}
				return n.getLastName().compareTo(n1.getLastName());
			}
		});*/

		// Java 8+ -> using Lambda for Comparator
		/*Collections.sort(names, (n, n1) -> {
				int val = n.getFirstName().compareTo(n1.getFirstName());
				if (val != 0) {
					return val;
				}
				return n.getLastName().compareTo(n1.getLastName());
			});*/

		// Java 8+ -> clear and most concise way - using lambda and method reference
		Collections.sort(names, Comparator.comparing(Name::getFirstName).thenComparing(Name::getLastName));

		return IntStream.range(0, names.size())
				.parallel()
				.map(i -> (i+1) * scoringAlgo.calculateScore(names.get(i)))
				.sum();
	}

}
