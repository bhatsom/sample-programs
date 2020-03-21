package com.bhatsom.algo.namescore;

import com.bhatsom.algo.models.Name;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoringAlgoByFirstNameTest {

	private ScoringAlgoByFirstName scoringAlgoByFirstName = new ScoringAlgoByFirstName();

	@Test
	public void testCalculateScore(){
		// test data
		Name testName = new Name("JOHN", "DOE");

		// JOHN = 47
		assertEquals(47, scoringAlgoByFirstName.calculateScore(testName));
	}

}