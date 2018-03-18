package credits;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class CreditsMain extends JFrame
{
	public CreditsMain()
	{
		setTitle("Help");
		setSize(880, 620);
		setResizable(false);
		//setUndecorated(true);
		
		
		CreditsPage creditsPage = new CreditsPage();
		add(creditsPage);
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new CreditsMain();
	}
}
