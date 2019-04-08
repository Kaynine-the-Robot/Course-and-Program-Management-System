package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import Controller.guiWindowController;
import Model.course;
import Model.department;
import Model.faculty;
import Model.program;

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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Faculty", "Department", "Program", "Course"}));
		comboBox.setBounds(W/6, H/6, W/3, H/20);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		frmSearch.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// the selection from the drop down 
				int selection = comboBox.getSelectedIndex();
				System.out.println(selection);
				// input from the user
				String nameToBeSearched = textField.getText().replace(" ", "_");
				// initializing the index of where the input of the user, may lie on an array
				int index;
				//switch case for the selection
				switch(selection)
				{
				default:
					break;
				// first index from the dropdown is faculty, so we search on the array that contains all the faculties
				case 0:
					try
					{
					for(int i = 0; i < faculty.getFacultySet().size(); i++)
						System.out.println(faculty.getFacultySet().get(i).getName());
					System.out.println(nameToBeSearched + " = input");
					index = linearSearch(nameToBeSearched, faculty.getFacultySet(), selection);
					}
					catch(NoSuchElementException e0)
					{
						
					}
					break;
				// second index from the dropdown is department, so we search on the array that contains all the departments
				case 1:
					try
					{
					index = linearSearch(nameToBeSearched, department.allDepartments, selection);
					}
					catch(NoSuchElementException e1)
					{
						
					}
					break;
				// third index from the dropdown is program, so we search on the array that contains all the programs
				case 2:
					try
					{
					index = linearSearch(nameToBeSearched, program.allPrograms, selection);
					}
					catch(NoSuchElementException e2)
					{
						
					}
					break;
				// fourth index from the dropdown is course, so we search on the array that contains all the courses
				case 3:
					try
					{
					index = linearSearch(nameToBeSearched, course.allCourses, selection);
					}
					catch(NoSuchElementException e3)
					{
						
					}
					break;
				}
				
				// we have the index of the name of what the user is looking for 
				// we just need to go to the list window of what the user searched for
				// need to handle the logic of switching between windows
			}
		});
		btnNewButton.setBounds((7*W)/12, H/10, W/10, H/9);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		frmSearch.getContentPane().add(btnNewButton);
		
		
		JButton btnExplore = new JButton("Explore");
		btnExplore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// go into the faculty list window, just like our program did during the demo with the TA
			}
		});
		btnExplore.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		btnExplore.setBounds((5*W)/6, H/2, W/8, H/15);
		frmSearch.getContentPane().add(btnExplore);
	}
	
	public JFrame getFrame() {
		return frmSearch;
	}
	
	
	/**
	 * method/algorithm that performs a linear search on the list passed as parameter
	 * it searches by the name of the attribute, that is why a name is also passed as a parameter
	 * @param <T> - java generic, to generalize the algorithm for any attribute of the system
	 * @param name - the name the user is searching for
	 * @param listToSearch - the list to be searched
	 * @param selection - the option selected by the user from the dropdown menu
	 * needed to check which casting we may need to do
	 */
	public static <T> int linearSearch(String name, ArrayList<T> listToSearch, int selection) throws NoSuchElementException
	{
		int length = listToSearch.size();
		int index = 0;
		
		// switch case to handle the selection the user chose to search the name under
		// needed to determine the type of casting the while is to be performed in
		// the while loop basically just searches through the array while the name does not equal the element of the array at index
		// if they are the same then we have found the name and at what index it is located at in the array
		switch(selection)
		{
		// casting to faculty
		case 0:
			String nameToCompare = faculty.getFacultySet().get(index).getName();
			while((index < length) && (faculty.getFacultySet().get(index).getName() != name))
			{
				System.out.println(nameToCompare + " = index " + index);
				index++;
			}
			break;
		// casting to department
		case 1:
			while((index < length) && (((department) listToSearch.get(index)).getName() != name))
			{
				index++;
			}
			break;
		// casting to program
		case 2:
			while((index < length) && (((program) listToSearch.get(index)).getName() != name))
			{
				index++;
			}
			break;
		// casting to course
		case 3:
			while((index < length) && (((course) listToSearch.get(index)).getName() != name))
			{
				index++;
			}
			break;
		// default case
		default:
			break;
		}
		
		// checking to see if the index would be valid, and the name was found
		if(index < length)
		{
			System.out.println("" + name + " was found successfully");
			return index;
		}
		// the name was not found, and throw the exception and pop up a warning message
		else
		{
			WarningMessage notFoundPopUp = new WarningMessage("" + name + " cannot be found on the system");
			throw new NoSuchElementException();
		}
	}
}
