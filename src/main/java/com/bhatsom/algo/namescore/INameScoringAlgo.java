package com.bhatsom.algo.namescore;

import com.bhatsom.algo.models.Name;

/**
 * This is a contract for a Name Scoring Algorithm. Different algorithms can score a name in
 * different ways.
 */
public interface INameScoringAlgo {

	/**
	 * Calculates the score for a given name.
	 *
	 * @param name An instance of Name that needs to be scored
	 * @return the calculated integer value of the score
	 *
	 */
	int calculateScore(final Name name);

}
