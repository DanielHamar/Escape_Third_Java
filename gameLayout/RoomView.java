package gameLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RoomView extends JPanel
{
	AudioInputStream rAudio;
	Clip rMusic;
	JButton btnQuiz;
	String subChoice = "";

	// constructor for the individual rooms - receives the subject and a close button
	public RoomView(String subChoice, CustomButton btnClose)
	{
		this.subChoice = subChoice;
		btnQuiz = new JButton("Take the " + subChoice.toUpperCase() + " Quiz!");
		btnQuiz.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		btnQuiz.setForeground(Color.RED);
		btnQuiz.setBounds(440, 200, 400, 300);
		btnQuiz.setContentAreaFilled(false);
		btnQuiz.setBorderPainted(true);
		btnQuiz.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent args) 
			{
				new MultChoiceQuiz(subChoice);
				repaint();
			}
		});
		add(btnQuiz);
		
		add(btnClose);
		
		
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon(RoomView.class.getResource(subChoice + ".png")).getImage(), 0, 0, 1280, 700, this);
	}
	
	// sets the music
	public void playJB()
	{
		try 
		{
			URL url= HomeScreen.class.getResource("JamesBond.wav");
			rAudio = AudioSystem.getAudioInputStream(url);
			rMusic = AudioSystem.getClip();
			rMusic.open(rAudio);
			rMusic.loop(-1);
		}
		catch(Exception ex)
		{}
	}
	
	public void stop()
	{
		
		try{
			rMusic.stop();
		}
		catch(Exception e){
			
		}
		
	}
	
}
