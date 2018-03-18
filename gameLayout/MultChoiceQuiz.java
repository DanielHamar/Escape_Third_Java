package gameLayout;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MultChoiceQuiz {

	// Declarations and Instantiations
	private JFrame frame;
	String subChoice;
	String fileName;
	
	RandNum randNum = new RandNum();
	int correctAnswers = 0;
	int incorrectAnswers = 0;
	int qCount = 0;
	static boolean rmStar = false;
	
	// constructor for Quiz - receives the subject
	public MultChoiceQuiz(String subChoice) {
		this.subChoice = subChoice;
		this.fileName = subChoice + ".txt";
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// sets frame properties
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// makes a new question and answer session
		QandA qAndA = new QandA(fileName);
		
		// create new font variables
		Font smallFont = new Font("Bookman Old Style", Font.ITALIC, 12);
		Font smallBoldFont = new Font("Bookman Old Style", Font.BOLD, 12);
		Font medBoldFont = new Font("Bookman Old Style", Font.BOLD, 18);
		Font medBoldItalFont = new Font("Bookman Old Style", Font.BOLD + Font.ITALIC, 18);
		
		JLabel lblSubjectQuiz = new JLabel(subChoice.toUpperCase() + " QUIZ");
		lblSubjectQuiz.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSubjectQuiz.setVerticalTextPosition(SwingConstants.CENTER);
		lblSubjectQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectQuiz.setBounds(10, 10, 664, 70);
		lblSubjectQuiz.setFont(new Font("Bookman Old Style", Font.BOLD, 28));
		
		JLabel lblQuestion = new JLabel();
		lblQuestion.setText("<html>" + qAndA.getQuestion(randNum.qNumbers.get(qCount)) + "</html>");
		lblQuestion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQuestion.setVerticalTextPosition(SwingConstants.CENTER);
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		lblQuestion.setBounds(10, 86, 664, 126);		
		
		// Create radio buttons for the answer choices
		JRadioButton btnAnswerA = new JRadioButton();
		btnAnswerA.setFont(smallFont);
		btnAnswerA.setBounds(28, 252, 325, 35);
		btnAnswerA.setText(qAndA.getAnsA(randNum.qNumbers.get(qCount)));
		JRadioButton btnAnswerB = new JRadioButton();
		btnAnswerB.setFont(smallFont);
		btnAnswerB.setBounds(28, 292, 325, 35);
		btnAnswerB.setText(qAndA.getAnsB(randNum.qNumbers.get(qCount)));
		JRadioButton btnAnswerC = new JRadioButton();
		btnAnswerC.setFont(smallFont);
		btnAnswerC.setBounds(28, 332, 325, 35);
		btnAnswerC.setText(qAndA.getAnsC(randNum.qNumbers.get(qCount)));
		JRadioButton btnAnswerD = new JRadioButton();
		btnAnswerD.setFont(smallFont);
		btnAnswerD.setBounds(28, 372, 325, 35);
		btnAnswerD.setText(qAndA.getAnsD(randNum.qNumbers.get(qCount)));
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.clearSelection();
		radioButtons.add(btnAnswerA);
		radioButtons.add(btnAnswerB);
		radioButtons.add(btnAnswerC);
		radioButtons.add(btnAnswerD);
		
		JLabel lblRightAns = new JLabel("<html>" + "Correct!" + "</html>");
		lblRightAns.setVisible(false);
		lblRightAns.setHorizontalAlignment(SwingConstants.CENTER);
		lblRightAns.setFont(medBoldItalFont);
		lblRightAns.setForeground(Color.GREEN);
		lblRightAns.setBounds(427, 240, 222, 64);
		
		JLabel lblWrongAns = new JLabel("<html>" + "Incorrect." + "</html>");
		lblWrongAns.setVisible(false);
		lblWrongAns.setHorizontalAlignment(SwingConstants.CENTER);
		lblWrongAns.setFont(medBoldItalFont);
		lblWrongAns.setForeground(Color.RED);
		lblWrongAns.setBounds(427, 240, 222, 64);
		
		JLabel lblCorrectAns = new JLabel("<html>" + "The correct answer is" + "</html>");
		lblCorrectAns.setVisible(false);
		lblCorrectAns.setBounds(427, 304, 222, 64);
		lblCorrectAns.setFont(smallBoldFont);
		lblCorrectAns.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAnswer = new JLabel("<html>" + qAndA.getAnsKey(randNum.qNumbers.get(qCount)) + "</html>");
		lblAnswer.setVisible(false);
		lblAnswer.setBounds(427, 369, 222, 64);
		lblAnswer.setFont(smallBoldFont);
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(549, 514, 89, 23);
		btnContinue.setEnabled(false);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(450, 514, 89, 23);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(28, 514, 89, 23);
		
		btnSubmit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(btnAnswerA.isSelected())
				{
					if (qAndA.getAnsA(randNum.qNumbers.get(qCount)).equals(qAndA.getAnsKey(randNum.qNumbers.get(qCount))))
					{
						lblRightAns.setVisible(true);
						correctAnswers++;
					}
					else
					{
						lblWrongAns.setVisible(true);
						incorrectAnswers++;
					}
				}
				else if(btnAnswerB.isSelected())
				{
					if (qAndA.getAnsB(randNum.qNumbers.get(qCount)).equals(qAndA.getAnsKey(randNum.qNumbers.get(qCount))))
					{
						lblRightAns.setVisible(true);
						correctAnswers++;
					}
					else
					{
						lblWrongAns.setVisible(true);
						incorrectAnswers++;
					}
				}
				else if(btnAnswerC.isSelected())
				{
					if (qAndA.getAnsC(randNum.qNumbers.get(qCount)).equals(qAndA.getAnsKey(randNum.qNumbers.get(qCount))))
					{
						lblRightAns.setVisible(true);
						correctAnswers++;
					}
					else
					{
						lblWrongAns.setVisible(true);
						incorrectAnswers++;
					}
				}
				else if(btnAnswerD.isSelected())
				{
					if (qAndA.getAnsD(randNum.qNumbers.get(qCount)).equals(qAndA.getAnsKey(randNum.qNumbers.get(qCount))))
					{
						lblRightAns.setVisible(true);
						correctAnswers++;
					}
					else
					{
						lblWrongAns.setVisible(true);
						incorrectAnswers++;
					}
				}
				btnAnswerA.setEnabled(false);
				btnAnswerB.setEnabled(false);
				btnAnswerC.setEnabled(false);
				btnAnswerD.setEnabled(false);
				lblCorrectAns.setVisible(true);
				lblAnswer.setVisible(true);
				btnSubmit.setEnabled(false);
				btnContinue.setEnabled(true);
			}
		});
		
		btnContinue.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				qCount++;
				if(correctAnswers < 5 && incorrectAnswers < 3)
				{
					lblQuestion.setText("<html>" + qAndA.getQuestion(randNum.qNumbers.get(qCount)) + "</html>");
					btnAnswerA.setText(qAndA.getAnsA(randNum.qNumbers.get(qCount)));
					btnAnswerB.setText(qAndA.getAnsB(randNum.qNumbers.get(qCount)));
					btnAnswerC.setText(qAndA.getAnsC(randNum.qNumbers.get(qCount)));
					btnAnswerD.setText(qAndA.getAnsD(randNum.qNumbers.get(qCount)));
					lblAnswer.setText("<html>" + qAndA.getAnsKey(randNum.qNumbers.get(qCount)) + "</html>");
					lblRightAns.setVisible(false);
					lblWrongAns.setVisible(false);
					lblCorrectAns.setVisible(false);
					lblAnswer.setVisible(false);
					btnAnswerA.setEnabled(true);
					btnAnswerB.setEnabled(true);
					btnAnswerC.setEnabled(true);
					btnAnswerD.setEnabled(true);
					btnSubmit.setEnabled(true);
					btnContinue.setEnabled(false);
					radioButtons.clearSelection();
					frame.repaint();
				}
				else
				{
					frame.remove(btnContinue);
					frame.remove(lblAnswer);
					frame.remove(lblWrongAns);
					frame.remove(lblRightAns);
					frame.remove(lblCorrectAns);
					JButton btnClose = new JButton("Close");
					btnClose.setBounds(549, 514, 89, 23);
					frame.getContentPane().add(btnClose);
					btnClose.addActionListener(new ActionListener() 
					{
						@Override
						public void actionPerformed(ActionEvent arg0) 
						{
							if (correctAnswers >= 5)							
								RoomsPage.engStar = true;						
							else
								RoomsPage.engStar = false;
							frame.dispose();
						}
					});
					frame.repaint();
					if (correctAnswers >= 5)
					{			
						JLabel lblSuccess = new JLabel("Congratulations!!!");
						lblSuccess.setBounds(427, 240, 222, 64);
						lblSuccess.setFont(medBoldFont);
						lblSuccess.setForeground(Color.BLUE);
						lblSuccess.setHorizontalTextPosition(SwingConstants.CENTER);
						lblSuccess.setVerticalTextPosition(SwingConstants.CENTER);
						lblSuccess.setVisible(true);
						
						JLabel lblStar = new JLabel("<html>" + "You've earned a star for " + subChoice + "</html>");
						lblStar.setBounds(427, 324, 222, 64);
						lblStar.setFont(medBoldFont);
						lblStar.setForeground(Color.BLUE);
						lblStar.setHorizontalTextPosition(SwingConstants.CENTER);
						lblStar.setVerticalTextPosition(SwingConstants.CENTER);
						lblStar.setVisible(true);
						
						JLabel lblClose = new JLabel("Press Close to exit.");
						lblClose.setBounds(427, 388, 222, 64);
						lblClose.setFont(smallFont);
						lblClose.setForeground(Color.BLUE);
						lblClose.setHorizontalTextPosition(SwingConstants.CENTER);
						lblClose.setVerticalTextPosition(SwingConstants.CENTER);
						lblClose.setVisible(true);
						frame.getContentPane().add(lblSuccess);
						frame.getContentPane().add(lblStar);
						frame.getContentPane().add(lblClose);
						frame.repaint();
					}
					else
					{
						JLabel lblFailure = new JLabel("That Sucks!");
						lblFailure.setBounds(427, 240, 222, 64);
						lblFailure.setFont(medBoldFont);
						lblFailure.setForeground(Color.RED);
						lblFailure.setHorizontalTextPosition(SwingConstants.CENTER);
						lblFailure.setVerticalTextPosition(SwingConstants.CENTER);
						lblFailure.setVisible(true);
						
						JLabel lblStar = new JLabel("<html>" + "Try again to get the star" + "</html>");
						lblStar.setBounds(427, 324, 222, 64);
						lblStar.setFont(medBoldFont);
						lblStar.setForeground(Color.RED);
						lblStar.setHorizontalTextPosition(SwingConstants.CENTER);
						lblStar.setVerticalTextPosition(SwingConstants.CENTER);
						lblStar.setVisible(true);
						
						JLabel lblClose = new JLabel("Press Close to exit.");
						lblClose.setBounds(427, 388, 222, 64);
						lblClose.setFont(smallFont);
						lblClose.setForeground(Color.BLUE);
						lblClose.setHorizontalTextPosition(SwingConstants.CENTER);
						lblClose.setVerticalTextPosition(SwingConstants.CENTER);
						lblClose.setVisible(true);
						frame.getContentPane().add(lblFailure);
						frame.getContentPane().add(lblStar);
						frame.getContentPane().add(lblClose);
						frame.repaint();
					}
				}
				
			}
		});
		
		frame.getContentPane().add(lblSubjectQuiz);
		frame.getContentPane().add(lblQuestion);
		frame.getContentPane().add(lblRightAns);
		frame.getContentPane().add(lblWrongAns);
		frame.getContentPane().add(lblCorrectAns);
		frame.getContentPane().add(lblAnswer);
		frame.getContentPane().add(btnAnswerA);
		frame.getContentPane().add(btnAnswerB);
		frame.getContentPane().add(btnAnswerC);
		frame.getContentPane().add(btnAnswerD);
		frame.getContentPane().add(btnContinue);
		frame.getContentPane().add(btnSubmit);
		
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		frame.getContentPane().add(btnBack);
		frame.setName(subChoice.toUpperCase());
	}
	
	public static void setRmStar(boolean starAns)
	{
		rmStar = starAns;
	}
	public static boolean getRmStar()
	{
		return rmStar;
	}
	
}
