package gameLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import helpScreen.HelpMain;

public class GameLayout 
{
	//Declarations and instantiations
	JFrame gLayout = new JFrame("Escape The Third");
	JPanel panelCont = new JPanel();
	String subChoice = "";
	
	// Panels to add to card layout
	HomeScreen homeScreen = new HomeScreen(btnStart());
	RoomsPage roomOverview = new RoomsPage(engButton(), hisButton(), sciButton(), mathButton(), socStudButton());
	RoomView mathRoom = new RoomView("math", closeButton());
	RoomView scienceRoom = new RoomView("science", closeButton());
	RoomView englishRoom = new RoomView("english", closeButton());
	RoomView socStudRoom = new RoomView("social_studies", closeButton());
	RoomView historyRoom = new RoomView("history", closeButton());
	RoomView escapeRoom = new RoomView("escape", closeButton());
	
	
	JMenuBar menuBar;
	JMenu gMenu;
	JMenuItem jmiHelp;
	JMenuItem jmiExit;
	JMenuItem jmiMMenu;
	
	
	CardLayout cl = new CardLayout();
	
	
	public GameLayout()
	{
		// set the layout and add all the rooms to the panel
		panelCont.setLayout(cl);
		panelCont.add(roomOverview, "Overview");
		panelCont.add(homeScreen, "Home");
		panelCont.add(englishRoom, "English");
		panelCont.add(mathRoom, "Math");
		panelCont.add(scienceRoom, "Science");
		panelCont.add(socStudRoom, "Social Studies");
		panelCont.add(historyRoom, "History");
		panelCont.add(escapeRoom, "Escape");
		
		// create menu for in game screens
		menuBar = new JMenuBar();
		gLayout.setJMenuBar(menuBar);
		
		gMenu = new JMenu("Menu");
		menuBar.add(gMenu);
		jmiHelp = new JMenuItem("Help");
		gMenu.add(jmiHelp);
		jmiMMenu = new JMenuItem("Return to main menu");
		gMenu.add(jmiMMenu);
		jmiExit = new JMenuItem("Exit Game");
		gMenu.add(jmiExit);
		menuBar.setVisible(false);
		cl.show(panelCont, "Home");
		
		// set frame properties
		gLayout.setUndecorated(true);
		gLayout.add(panelCont);
		gLayout.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		gLayout.pack();
		gLayout.setVisible(true);
		gLayout.setSize(1280, 720);
		gLayout.setResizable(false);
		gLayout.setLocation(50, 50);
				
		// add action listeners for menu items
		jmiHelp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				new HelpMain();		
			}
		});
		
		jmiMMenu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelCont, "Home");
				homeScreen.playMisImp();
				menuBar.setVisible(false);
				roomOverview.stop();
			}
		});
		
		jmiExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (JOptionPane.showConfirmDialog(null, "Are you sure?\nYou will lose all progress made so far.", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
				}
			}
		});
	}
	
	// special button to start the game
	public CustomButton btnStart()
	{
		CustomButton btnStart = new CustomButton("START");
		btnStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelCont, "Overview");	
				homeScreen.stop();
				menuBar.setVisible(true);
				roomOverview.playBourne();
			}
		});
		return btnStart;
	}
	
	//  create the buttons that will be passed to the overview
	public JButton engButton()
	{
		JButton btnEng = new JButton();
		btnEng.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		btnEng.setVisible(true);
		btnEng.setFocusable(true);
		btnEng.setOpaque(false);
		btnEng.setContentAreaFilled(false);
		btnEng.setBorderPainted(false);
		btnEng.setBounds(130, 409, 300, 244);
		btnEng.setForeground(Color.WHITE);
		btnEng.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelCont, "English");
				roomOverview.stop();
				englishRoom.playJB();
			}
		});
		return btnEng;
	}
	
	public JButton hisButton()
	{
		JButton btnHis = new JButton();
		btnHis.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		btnHis.setVisible(true);
		btnHis.setFocusable(true);
		btnHis.setOpaque(false);
		btnHis.setContentAreaFilled(false);
		btnHis.setBorderPainted(false);
		btnHis.setBounds(540, 48, 300, 244);
		btnHis.setForeground(Color.WHITE);
		btnHis.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(panelCont, "History");
				roomOverview.stop();
				historyRoom.playJB();
			}
		});
		return btnHis;
	}
	
	public JButton sciButton()
	{
		JButton btnSci = new JButton();
		btnSci.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		btnSci.setVisible(true);
		btnSci.setFocusable(true);
		btnSci.setOpaque(false);
		btnSci.setContentAreaFilled(false);
		btnSci.setBorderPainted(false);
		btnSci.setBounds(130, 48, 300, 244);
		btnSci.setForeground(Color.WHITE);
		btnSci.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelCont, "Science");
				roomOverview.stop();
				scienceRoom.playJB();
			}
		});
		return btnSci;
	}
	
	public JButton mathButton()
	{
		JButton btnMath = new JButton();
		btnMath.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		btnMath.setVisible(true);
		btnMath.setFocusable(true);
		btnMath.setOpaque(false);
		btnMath.setContentAreaFilled(false);
		btnMath.setBorderPainted(false);
		btnMath.setBounds(840, 48, 300, 244);
		btnMath.setForeground(Color.WHITE);
		btnMath.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelCont, "Math");
				roomOverview.stop();
				mathRoom.playJB();
			}
		});
		return btnMath;
	}
	
	public JButton socStudButton()
	{
		JButton btnSS = new JButton();
		btnSS.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		btnSS.setVisible(true);
		btnSS.setFocusable(true);
		btnSS.setOpaque(false);
		btnSS.setContentAreaFilled(false);
		btnSS.setBorderPainted(false);
		btnSS.setBounds(540, 409, 300, 244);
		btnSS.setForeground(Color.WHITE);
		btnSS.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelCont, "Social Studies");
				roomOverview.stop();
				socStudRoom.playJB();
			}
		});
		return btnSS;
	}
	
	// button to close the room view and show the overview
	public CustomButton closeButton()
	{
		CustomButton btnClose = new CustomButton("Close");
		//closeRm.setBounds(1100, 640, 100, 50);
		btnClose.setAlignmentX(1100);
		btnClose.setAlignmentY(640);
		btnClose.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "Overview");	
				roomOverview.playBourne();
				englishRoom.stop();
				historyRoom.stop();
				scienceRoom.stop();
				mathRoom.stop();
				socStudRoom.stop();			
			}
			
		});
		return btnClose;
	}
	
//	public static void main(String[] args)
//	{
//		SwingUtilities.invokeLater(new Runnable(){
//			@Override
//			public void run(){
//				new GameLayout();
//			}
//		});
//	}
}
