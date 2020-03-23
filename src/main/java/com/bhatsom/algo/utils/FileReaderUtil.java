package com.bhatsom.algo.utils;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class FileReaderUtil {

	/**
	 * Reads a specific line from a file containing comma separated quoted texts
	 * @param fileName name of the input file
	 * @param lineNumber specific line number to be read
	 * @return an Array of Strings representing the individual texts (excluding the quotes)
	 * @throws Exception
	 */
	public static String[] readSingleCommaSeparatedLine(String fileName, int lineNumber, boolean skipHeader) throws Exception {
		Reader reader = new BufferedReader(new FileReader(fileName));

		CSVParser csvParser = new CSVParserBuilder()
				.withSeparator(',')
				.withIgnoreQuotations(true)
				.build();

		// lines to skip to reach to the target line - to avoid reading unwanted lines
		int linesToSkip = skipHeader ? (lineNumber - 1) : 0;

		CSVReader csvReader = new CSVReaderBuilder(reader)
				.withSkipLines(linesToSkip)
				.withCSVParser(csvParser)
				.build();

		return csvReader.readNext();
	}

}
