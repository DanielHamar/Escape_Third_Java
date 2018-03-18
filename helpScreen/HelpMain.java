package helpScreen;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class HelpMain extends JFrame
{
	// constructor for the help screen
	public HelpMain()
	{
		setTitle("Help");
		setSize(880, 620);
		setResizable(false);
		//setUndecorated(true);
		
		
		HelpPage helpPage = new HelpPage();
		add(helpPage);
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new HelpMain();
	}
}
