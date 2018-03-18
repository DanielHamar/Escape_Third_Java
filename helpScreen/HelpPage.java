package helpScreen;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HelpPage extends JPanel
{
	public HelpPage()
	{
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
			g.drawImage(new ImageIcon(HelpPage.class.getResource("help.png")).getImage(), 0, 0, 880, 620, this);
		
	}
}
