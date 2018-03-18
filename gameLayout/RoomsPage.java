package gameLayout;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RoomsPage extends JPanel
{
	private BorderLayout rLayout;
	AudioInputStream bAudio;
	Clip bMusic;	
	
	String ENGLISH = "english";
	String LROOM = "Living Room";
	String SCIENCE = "science";
	String KITCHEN = "Kitchen";
	String HISTORY = "history";
	String DROOM = "Dining Room";
	String MATH = "math";
	String KROOM = "Kid's Room";
	String SS = "social_studies";
	String PROOM = "Parent's Room";	
	public static boolean engStar = false;
	
	Icon rmStar = new ImageIcon(getClass().getResource("star.png"));
	
	// Constructor that receives the buttons for this page
	public RoomsPage(JButton btnEng, JButton btnHis, JButton btnSci, JButton btnMath, JButton btnSS)
	{				
		rLayout = new BorderLayout();
		setLayout(rLayout);
		
		// create a new panel that holds the buttons
		JPanel btnPanel = new JPanel();
		
		btnPanel.setLayout(null);
		btnPanel.setVisible(true);
		btnPanel.setFocusable(true);
		btnPanel.setOpaque(false);
		btnPanel.setSize(1280, 720);
		
		btnEng.setText(LROOM);
		btnHis.setText(DROOM);
		btnSci.setText(KITCHEN);
		btnMath.setText(KROOM);
		btnSS.setText(PROOM);
		
		btnPanel.add(btnEng);
		btnPanel.add(btnHis);
		btnPanel.add(btnSci);
		btnPanel.add(btnMath);
		btnPanel.add(btnSS);
		
		add(btnPanel);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon(RoomsPage.class.getResource("Home Floor Layout.png")).getImage(), 0, 0, 1280, 700, this);
		
	}
	
	// sets the music
	public void playBourne()
	{
		try 
		{
			URL url= HomeScreen.class.getResource("BournID.wav");
			bAudio = AudioSystem.getAudioInputStream(url);
			bMusic = AudioSystem.getClip();
			bMusic.open(bAudio);
			bMusic.loop(-1);
		}
		catch(Exception ex)
		{}
	}
	
	public void stop()
	{
		try{
			bMusic.stop();
		}
		catch(Exception e){
			
		}
	}

}
