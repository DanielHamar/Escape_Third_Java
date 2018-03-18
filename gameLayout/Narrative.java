package gameLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Narrative 
{
	BufferedReader br;
	AudioInputStream audio;
	Clip music;
	
	Narrative()
	{
		JFrame narrative = new JFrame("Escape The Third");
		narrative.setSize(1280, 720);
		narrative.setVisible(true);
		narrative.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel holder = new JPanel(new BorderLayout());
		holder.setBackground(Color.BLUE);
		holder.setVisible(true);
		narrative.add(holder);
		
		// readies the Narr label for file reading
		JLabel narr = new JLabel("<html><div style='text-align: center;'>");
		
		// resize font if Narr file is too long
		narr.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		narr.setOpaque(true);
		narr.setForeground(Color.WHITE);
		narr.setBackground(Color.BLUE);
		narr.setHorizontalAlignment(SwingConstants.CENTER);
		narr.setVerticalAlignment(SwingConstants.TOP);
		holder.add(narr, BorderLayout.NORTH);
		
		playMisImp();
		
		// See the narrText Documentation in the Project Folder for help 
		//String narrFile = "narrText.txt";
		try 
		{
			br = new BufferedReader(new InputStreamReader(Narrative.class.getResourceAsStream("narrText.txt")));
			String line;
			while ((line = br.readLine()) != null) {
				narr.setText(narr.getText() + line);
				if(!(line.contains("<br/>"))){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						throw new RuntimeException("");
					}
				}
			}
			narr.setText(narr.getText() + "</html>");
			br.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			throw new RuntimeException("");
		}

		JButton contBtn = new JButton();
		contBtn.setText("Continue");
		contBtn.setVerticalAlignment(SwingConstants.CENTER);
		contBtn.setHorizontalAlignment(SwingConstants.CENTER);
		holder.add(contBtn, BorderLayout.SOUTH);
		holder.revalidate();
		
		contBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				
				narrative.dispose();
				stop();
				new GameLayout();
			}
		});
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
	
	public static void main(String[] args) 
	{
		new Narrative();
	}
}