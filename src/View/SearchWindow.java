package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import Controller.guiWindowController;

import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class SearchWindow {

	private JFrame frmSearch;
	private JTextField textField;
	
	//The Height of the full screen window
	private static int H;
	//The width of the full screen window
	private static int W;
	private guiWindowController backGUI;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SearchWindow window = new SearchWindow();
//					window.frmSearch.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SearchWindow(int width, int height, guiWindowController gui) {
		backGUI = gui;
		W = width;
		H = height;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearch = new JFrame();
		frmSearch.setTitle("Search");
		frmSearch.setBounds(0, 0, W, H);
		frmSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearch.getContentPane().setLayout(null);
		
		// components of the exit button of the window
		JButton exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Dialog", Font.PLAIN, H/40));
		exitButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				System.exit(0);
			}
		});
		exitButton.setBounds(W/50, H - (H/6), W/10, H/15);
		frmSearch.getContentPane().add(exitButton);
		
		//Components of the back button on the window, when clicked will terminate current window
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmSearch.dispose();
				backGUI.toggleBackChange();
				backGUI.windowChange();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		btnBack.setBounds(W/6, H - (H/6), W/10, H/15);
		frmSearch.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Look for:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		lblNewLabel.setBounds(W/15, H/10, W/10, H/20);
		frmSearch.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(W/6, H/10, W/3, H/25);
		textField.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		frmSearch.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds((7*W)/12, H/10, W/10, H/9);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		frmSearch.getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Faculty", "Department", "Program", "Course"}));
		comboBox.setBounds(W/6, H/6, W/3, H/20);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		frmSearch.getContentPane().add(comboBox);
		
		JButton btnExplore = new JButton("Explore");
		btnExplore.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		btnExplore.setBounds((5*W)/6, H/2, W/8, H/15);
		frmSearch.getContentPane().add(btnExplore);
	}
	
	public JFrame getFrame() {
		return frmSearch;
	}
}
