package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;

import Controller.*;

/**
 * ListWindow class
 * The window which appears after the user has selected an option of database 
 * objects to view and pressed the GO button
 * @author Kaynen Mitchell
 *
 */
public class ListWindow {
	
	//In this windows case, the type of list to be displayed, i.e. faculties or programs
	private static int windowType = 0;
	//The Height of the full screen window
	private static int H;
	//The width of the full screen window
	private static int W;
	//The Frame of ListWindow for returning to make visible
	private JFrame frmListView;
	private guiWindowController backGUI;
	/**
	 * Launch the application.
	 */
	
	public void main(int displayType, int windowWidth, int windowHeight) {
		//Setting the passed on type of window to be displayed, i.e. faculty or program
		windowType = displayType;
		W = windowWidth;
		H = windowHeight;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					//ListWindow window = new ListWindow();
					//window.frmListView.setVisible(true);
					
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


	public ListWindow(int width, int height, guiWindowController gui, boolean isAdmin) {
		// TODO Auto-generated constructor stub
		backGUI = gui;
		W = width;
		H = height;
		initialize(isAdmin);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean isAdmin) 
	{
		// the frame work for the window frame
		frmListView = new JFrame();
		frmListView.setTitle("Faculty, Department, Course and Program Management Screen");
		frmListView.setSize(W, H);
		frmListView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListView.getContentPane().setLayout(null);
		
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
		frmListView.getContentPane().add(exitButton);
		
		//Components of the back button on the window, when clicked will terminate current window
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmListView.dispose();
				backGUI.toggleBackChange();
				backGUI.windowChange();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		btnBack.setBounds(W/6, H - (H/6), W/10, H/15);
		frmListView.getContentPane().add(btnBack);
		
		//Components about the list displaying all the objects in the database
		JList list = new JList();
		list.setBorder(BorderFactory.createLineBorder((Color.GRAY), 3));
		list.setFont(new Font("Tahoma", Font.PLAIN, H/30));
		
		//Condition for displaying which type of objects in the list, this is for faculties
		if(backGUI.getListWindowType() == 0) {
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"Science"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		//Condition for displaying which type of objects in the list, this is for departments
		else if(backGUI.getListWindowType() == 1) {
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"Computer Science"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		//Condition for displaying which type of objects in the list, this is for programs
		else if(backGUI.getListWindowType() == 2) {
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"Undergraduate"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		//Condition for displaying which type of objects in the list, this is for courses
		else {
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"CPSC 101"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		
		list.setBounds(W/50, H/20, (2*W)/5, (3*H)/4);
		frmListView.getContentPane().add(list);
		
		if(isAdmin == true)
		{
		//Components for the edit/delete button to go to that screen for the selected item on the list
		JButton btnEditdelete = new JButton("Edit/Delete");
		btnEditdelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backGUI.toggleAddAndEdit();	
				backGUI.toggleForwardChange();
				backGUI.windowChange();
			}
		});
		btnEditdelete.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		btnEditdelete.setBounds((5*W)/6, H/6, W/8, H/15);
		frmListView.getContentPane().add(btnEditdelete);
		
		//Components of the add button to go to that screen and add a new item to the database
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backGUI.toggleAddAndEdit();
				backGUI.toggleAddOrEdit();
				backGUI.toggleForwardChange();
				backGUI.windowChange();
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		btnAdd.setBounds((5*W)/6, H/20, W/8, H/15);
		frmListView.getContentPane().add(btnAdd);
		}
		
		if(backGUI.getListWindowType() != 3) {
			//Components of the add button to go to that screen and add a new item to the database
			JButton btnExplore = new JButton("Explore");
			btnExplore.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					backGUI.toggleForwardChange();
					backGUI.windowChange();
				}
			});
			btnExplore.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			btnExplore.setBounds((5*W)/6, H/2, W/8, H/15);
			frmListView.getContentPane().add(btnExplore);
		}
	}
	
	public JFrame getFrame() {
		return frmListView;
	}
	
}
