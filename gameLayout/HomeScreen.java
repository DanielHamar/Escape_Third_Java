package gameLayout;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import credits.CreditsMain;
import helpScreen.HelpMain;

@SuppressWarnings("serial")
public class HomeScreen extends JPanel
{
	boolean started = false;
	AudioInputStream audio;
	Clip music;
	
	// home view, main menu - received start button from game layout
	public HomeScreen(CustomButton btnStart)
	{				
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createVerticalStrut(360));
		btnStart.setAlignmentX(CENTER_ALIGNMENT);
		add(btnStart);
		
		// help button opens help JFrame
		CustomButton btnHelp = new CustomButton("HELP");
		btnHelp.setAlignmentX(CENTER_ALIGNMENT);
		btnHelp.addActionListener(new AbstractAction()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{			
				new HelpMain();
			}
	
		});
		add(btnHelp);
		
		// credits button opens credits JFrame
		CustomButton btnCredit = new CustomButton("CREDITS");
		btnCredit.setAlignmentX(CENTER_ALIGNMENT);
		btnCredit.addActionListener(new AbstractAction()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new CreditsMain();
			}
			
		});
		add(btnCredit);
		
		// exit button closes the game
		CustomButton btnExit = new CustomButton("EXIT");
		btnExit.setAlignmentX(CENTER_ALIGNMENT);
		btnExit.addActionListener(new AbstractAction()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
			
		});
		add(btnExit);
		
		
		add(Box.createVerticalGlue());
		
		/*try 
		{
			URL url= HomeScreen.class.getResource("MissImposs.wav");
			audio = AudioSystem.getAudioInputStream(url);
			music = AudioSystem.getClip();
			music.open(audio);
			music.loop(-1);
		}
		catch(Exception ex)
		{}*/
		
		playMisImp();
	}
	
	// sets the music to play
	public void playMisImp()
	{
		try 
		{
			URL url= HomeScreen.class.getResource("MissImposs.wav");
			audio = AudioSystem.getAudioInputStream(url);
			music = AudioSystem.getClip();
			music.open(audio);
			music.loop(-1);
		}
		catch(Exception ex)
		{}
	}
		
	public void stop()
	{
		try{
			music.stop();
		}
		catch(Exception e){
			
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
			g.drawImage(new ImageIcon(HomeScreen.class.getResource("House.png")).getImage(), 0, 0, 1280, 700, this);
		
	}
}
