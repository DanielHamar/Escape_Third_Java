package gameLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


@SuppressWarnings("serial")
public class CustomButton extends JButton implements MouseListener
{
	Dimension size = new Dimension(150, 60);
	
	boolean hover = false;
	boolean click = false;
	
	String text = "";
	
	public CustomButton(String text) // Constructor for custom buttons
	{
		setVisible(true);
		setFocusable(true);
		setContentAreaFilled(false);
		setBorderPainted(false);
		
		this.text = text;
		
		addMouseListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
				
		g.setColor(new Color(102, 102, 255));
		
		g.fillRoundRect(14, 14, 122, 47, 20, 20);
		
		g.setColor(Color.WHITE);
		
		g.setFont(Font.decode("Bookman Old Style-BOLD-24"));
		
		FontMetrics metrics = g.getFontMetrics();
		
		int width = metrics.stringWidth(text);
		
		g.drawString(text, 75 - width / 2, 47);
	}
	
	// getters and setters
	@Override
	public Dimension getPreferredSize()
	{
		return size;
	}
	
	@Override
	public Dimension getMaximumSize()
	{
		return size;
	}
	
	@Override
	public Dimension getMinimumSize()
	{
		return size;
	}
	
	public void setButtonText(String text)
	{
		this.text = text;
	}
	
	public String getButtonText()
	{
		return text;
	}

	// mouse events
	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		hover = true;
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		hover = false;		
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		click = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		click = false;		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{	
	}

	
}
