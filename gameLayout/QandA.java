// Designed by Daniel Hamar for team DAB
// Escape the Third
// Math Questions from: https://www.aplusclick.org
// English Questions from: https://www.quiz.biz/quizz-304034.html#debutform304034
// Social Studies Questions from: https://www.proprofs.com/quiz-school/story.php?title=3rd-grade-unit-1-social-studies
// and http://www.helpteaching.com/questions/Social_Studies/Grade_3
// History Questions from: http://www.doe.virginia.gov/testing/sol/released_tests/2012/history/test12_grade_3.pdf
// and http://www.funtrivia.com/submitquiz.cfm
// Science Questions from: https://www.quia.com
// and http://http://www.sheknows.com/quizzes/grade-3-science-quiz



package gameLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Class designed to create 6 array lists and populate them with the questions and
// answers from the designated subject file
public class QandA 
{
	// Declarations
	private ArrayList<String> qArray;
	private ArrayList<String> ansA;
	private ArrayList<String> ansB;
	private ArrayList<String> ansC;
	private ArrayList<String> ansD;
	private ArrayList<String> ansKey;
	private int POOL = 25;

	// Constructor will instantiate and populate the array lists
	public QandA(String fileName)
	{
		qArray = new ArrayList<String>();
		ansA = new ArrayList<String>();
		ansB = new ArrayList<String>();
		ansC = new ArrayList<String>();
		ansD = new ArrayList<String>();
		ansKey = new ArrayList<String>();
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(Narrative.class.getResourceAsStream(fileName.toLowerCase())));
			for(int lineCount = 0; lineCount< POOL; ++ lineCount)
			{
				qArray.add(lineCount, br.readLine());
				ansA.add(lineCount, br.readLine());
				ansB.add(lineCount, br.readLine());
				ansC.add(lineCount, br.readLine());
				ansD.add(lineCount, br.readLine());
				ansKey.add(lineCount, br.readLine());
			}
			br.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	// Set and Get for Arrays questions and answers -- Setters not used but built as backups
	public String getQuestion(int ranNum)
	{
		return qArray.get(ranNum);
	}
	public String getAnsA(int ranNum)
	{
		return ansA.get(ranNum);
	}
	public String getAnsB(int ranNum)
	{
		return ansB.get(ranNum);
	}
	public String getAnsC(int ranNum)
	{
		return ansC.get(ranNum);
	}
	public String getAnsD(int ranNum)
	{
		return ansD.get(ranNum);
	}
	public String getAnsKey(int ranNum)
	{
		return ansKey.get(ranNum);
	}
	public void setQuestion(int lineCount, String readLine)
	{
		this.qArray.add(lineCount, readLine);
	}
	public void setAnsA(int lineCount, String readLine)
	{
		this.ansA.add(lineCount, readLine);
	}
	public void setAnsB(int lineCount, String readLine)
	{
		this.ansB.add(lineCount, readLine);
	}
	public void setAnsC(int lineCount, String readLine)
	{
		this.ansC.add(lineCount, readLine);
	}
	public void setAnsD(int lineCount, String readLine)
	{
		this.ansD.add(lineCount, readLine);
	}
	public void setAnsKey(int lineCount, String readLine)
	{
		this.ansKey.add(lineCount, readLine);
	}
}
