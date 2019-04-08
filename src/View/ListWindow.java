package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;

import Controller.*;
import Model.*;

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
	private static int currentFaculty = -1;
	private static int currentDepartment = -1;
	private static int currentProgram = -1;
	private static int currentCourse = -1;
	
	/**
	 * Launch the application.
	 */
	
	/*
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
	*/


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
				//These conditions are for knowing which depth the list window is in, and when back is pressed
				//resets the value back to -1, which is useful for telling what window is on
				if(currentCourse != -1) {
					currentCourse = -1;
				}
				else if(currentProgram != -1) {
					currentProgram = -1;
				}
				else if(currentDepartment != -1) {
					currentDepartment = -1;
				}
				else if(currentFaculty != -1) {
					currentFaculty = -1;
				}
				frmListView.dispose();
				backGUI.toggleBackChange();
				backGUI.windowChange();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		btnBack.setBounds(W/6, H - (H/6), W/10, H/15);
		frmListView.getContentPane().add(btnBack);
		
		//Components of the back button on the window, when clicked will terminate current window
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmListView.dispose();
				backGUI.toggleSearchFlag();
				backGUI.toggleForwardChange();
				backGUI.windowChange();
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		btnSearch.setBounds((5*W)/6, (17*H)/60, W/8, H/15);
		frmListView.getContentPane().add(btnSearch);
		//Components about the list displaying all the objects in the database
		JList list = new JList();
		list.setBorder(BorderFactory.createLineBorder((Color.GRAY), 3));
		list.setFont(new Font("Tahoma", Font.PLAIN, H/30));
		
		//Condition for displaying which type of objects in the list, this is for faculties
		if(backGUI.getListWindowType() == 0) {
			DefaultListModel listModel = new DefaultListModel();
			for(int i = 0; i < faculty.getFacultySet().size(); i++) {
				listModel.addElement(faculty.getFacultySet().get(i).getName().replace("_", " "));
			}
			list.setModel(listModel);
		}
		//Condition for displaying which type of objects in the list, this is for departments
		else if(backGUI.getListWindowType() == 1) {
			DefaultListModel listModel = new DefaultListModel();
			faculty selectedFaculty = faculty.getFacultySet().get(currentFaculty);
			for(int i = 0; i < selectedFaculty.getDepartments().size(); i++) {
				listModel.addElement(selectedFaculty.getDepartments().get(i).getName().replace("_", " "));
			}
			list.setModel(listModel);
		}
		//Condition for displaying which type of objects in the list, this is for programs
		else if(backGUI.getListWindowType() == 2) {
			DefaultListModel listModel = new DefaultListModel();
			department selectedDepartment = faculty.getFacultySet().get(currentFaculty).getDepartments().get(currentDepartment);
			for(int i = 0; i < selectedDepartment.programSet.size(); i++) {
				listModel.addElement(selectedDepartment.programSet.get(i).getName().replace("_", " "));
			}
			list.setModel(listModel);
		}
		//Condition for displaying which type of objects in the list, this is for courses
		else {
			DefaultListModel listModel = new DefaultListModel();
			program selectedProgram = faculty.getFacultySet().get(currentFaculty).getDepartments().get(currentDepartment).programSet.get(currentProgram);
			for(int i = 0; i < selectedProgram.courseSet.size(); i++) {
				listModel.addElement(selectedProgram.courseSet.get(i).getName().replace("_", " "));
			}
			list.setModel(listModel);
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
				updateCurrentCourse(list);
				backGUI.toggleAddAndEdit();	
				backGUI.toggleForwardChange();
				backGUI.windowChange();
				frmListView.dispose();
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
				updateCurrentCourse(list);
				backGUI.toggleAddAndEdit();
				backGUI.toggleAddOrEdit();
				backGUI.toggleForwardChange();
				backGUI.windowChange();
				frmListView.dispose();
				
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
					if(list.getSelectedIndex() != -1) {
					updateCurrentCourse(list);
					backGUI.toggleForwardChange();
					backGUI.windowChange();
					frmListView.dispose();
					}
					
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
	
	public static int getCurrentFaculty() {
		return currentFaculty;
	}
	
	public static int getCurrentDepartment() {
		return currentDepartment;
	}
	
	public static int getCurrentProgram() {
		return currentProgram;
	}
	
	public static int getCurrentCourse() {
		return currentCourse;
	}
	
	private void updateCurrentCourse(JList list) {
		switch(backGUI.getListWindowType()) {
		case 0: currentFaculty = list.getSelectedIndex();
		case 1: currentDepartment = list.getSelectedIndex();
		case 2: currentProgram = list.getSelectedIndex();
		case 3: currentCourse = list.getSelectedIndex();
		}
	}
}
