package com.bhatsom.algo.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileReaderUtilTest {

	@Test
	public void testReadSingleCommaSeparatedLine() throws Exception {
		String[] line = FileReaderUtil.readSingleCommaSeparatedLine("src/test/resources/names.txt", 1, false);
		assertNotNull(line);
		assertEquals("JOHN DOE", line[0]);
		assertEquals("SOMNATH B", line[1]);
	}


}