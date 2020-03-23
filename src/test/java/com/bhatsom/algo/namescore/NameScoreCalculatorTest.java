package com.bhatsom.algo.namescore;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameScoreCalculatorTest {

	@Test
	public void testCalculateNameScore() throws Exception {

		// algorithm to score individual names by first name's letters
		INameScoringAlgo scoringAlgo = new ScoringAlgoByFirstName();

		// lets run a small file
		// JOHN (47 * 1) + SOMNATH (90 * 2) = 47 + 180 = 227
		assertEquals(227, NameScoreCalculator.calculateNameScore("src/test/resources/names.txt", scoringAlgo));

		// now run the actual assignment file
		assertEquals(871198282, NameScoreCalculator.calculateNameScore("src/test/resources/OCC-Take-Home-Coding-names.txt", scoringAlgo));
	}
}