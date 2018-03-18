// Designed by Daniel Hamar for team DAB
// Escape the Third

package gameLayout;

import java.util.ArrayList;
import java.util.Random;

// Class developed to generate 8 random numbers from 25 possible choices.
// Each random number will be used to populate an array list for questions and answers
public class RandNum 
{
	ArrayList<Integer> qNumbers;
	Random randNum;
	public RandNum() 
	{
		qNumbers = new ArrayList<Integer>();
		randNum = new Random();
		for (int listCount = 0; listCount < 8; ++listCount)
		{
			int randValue = randNum.nextInt(25);
			while (qNumbers.contains(randValue))
				randValue = randNum.nextInt(25);
			qNumbers.add(listCount, randValue);
		}
	}

}
