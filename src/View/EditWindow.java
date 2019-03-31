package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.guiWindowController;
import Model.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;

/**
 * EditWindow class
 * The window which appears after the user has selected an option of database 
 * objects to edit and pressed the Edit button
 * @author Kaynen Mitchell
 *
 */
public class EditWindow {
	
	//In this windows case, the buttons and menus to be displayed, i.e. faculties has less options and buttons than courses
	private static int windowType;
	//This is a flag for if the screen only had an add button or the edit and delete buttons instead.
	private static boolean addOrEdit;
	//The Height of the full screen window
	private static int H;
	//The width of the full screen window
	private static int W;
	
	private JFrame frmEditView;
	private guiWindowController backGUI;
	
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	
	public void main(int displayType, boolean bool, int windowWidth, int windowHeight) {
		//Passed on window type, saved for knowing what buttons and menus to display
		windowType = displayType;
		//Passed on flag of the two possible button options to display
		addOrEdit = bool;
		H = windowHeight;
		W = windowWidth;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					//EditWindow window = new EditWindow();
					//window.frmEditView.setVisible(true);
					
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditWindow(int width, int height, guiWindowController gui, int displayType, boolean addEdit) 
	{
		backGUI = gui;
		W = width;
		H = height;
		//Passed on window type, saved for knowing what buttons and menus to display
		windowType = displayType;
		//Passed on flag of the two possible button options to display
		addOrEdit = addEdit;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		// the frame work for the window frame
		frmEditView = new JFrame();
		frmEditView.setTitle("Edit Selected Screen");
		frmEditView.setSize(W, H);
		frmEditView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditView.getContentPane().setLayout(null);
		
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
		frmEditView.getContentPane().add(exitButton);
		
		//Components of the back button on the window, when clicked will terminate current window
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmEditView.dispose();
				backGUI.toggleBackChange();
				backGUI.windowChange();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		btnBack.setBounds(W/5, H - (H/6), W/10, H/15);
		frmEditView.getContentPane().add(btnBack);
		
		//Components of a label for the Name box for adding/editing database objects
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		lblName.setBounds(W/10, H/40, W/10, H/10);
		frmEditView.getContentPane().add(lblName);
		
		if(addOrEdit) {
			textField = new JTextField();
		}
		else {
			textField = new JTextField(getName());
		}
		textField.setFont(new Font("Tahoma", Font.PLAIN, H/40));
		textField.setColumns(10);
		textField.setBounds(W/10, H/10, W/5, H/20);
		frmEditView.getContentPane().add(textField);
		
		
		
		if(backGUI.getListWindowType() == 1 | backGUI.getListWindowType() == 2 | backGUI.getListWindowType() == 3) {
			
			//Components of a label and drop down menu of possible faculties to be under for 
			//departments, programs, and courses for adding/editing database objects
			JLabel lblId = new JLabel("Faculty");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			lblId.setBounds(W/2, H/40, W/10, H/10);
			frmEditView.getContentPane().add(lblId);
			
			String[] faculties = new String[faculty.getFacultySet().size()];
			for(int i = 0; i < faculty.getFacultySet().size(); i++) {
				faculties[i] = faculty.getFacultySet().get(i).getName().replace("_", " ");
			}
			JComboBox comboBox = new JComboBox(faculties);
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			//comboBox.setModel(new DefaultComboBoxModel()); This is uneeded
			comboBox.setBounds(W/2, H/10, W/5, H/20);
			frmEditView.getContentPane().add(comboBox);
			
		}
		
		if(backGUI.getListWindowType() == 2 | backGUI.getListWindowType() == 3) {
			
			//Components of a label and drop down menu for the drop down menu of possible departments to be under for 
			//programs and courses for adding/editing database objects
			JLabel lblDepartment = new JLabel("Department");
			lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			lblDepartment.setBounds(W/2, (7*H)/40, W/10, H/10);
			frmEditView.getContentPane().add(lblDepartment);
			
			faculty tempFaculty = faculty.getFacultySet().get(ListWindow.getCurrentFaculty());
			String[] departments = new String[tempFaculty.getDepartments().size()];
			for(int i = 0; i < tempFaculty.getDepartments().size(); i++) {
				departments[i] = tempFaculty.getDepartments().get(i).getName().replace("_", " ");
			}
			JComboBox comboBox_1 = new JComboBox(departments);
			comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			//comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Computer Science"}));
			comboBox_1.setBounds(W/2, H/4, W/5, H/20);
			frmEditView.getContentPane().add(comboBox_1);
			
		}
		
		
		if(backGUI.getListWindowType() == 3) {
			
			//Components of a label and drop down menu for the drop down menu of possible programs to be under for 
			//courses for adding/editing database objects
			JLabel lblProgram = new JLabel("Program");
			lblProgram.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			lblProgram.setBounds(W/2, (13*H)/40, W/10, H/10);
			frmEditView.getContentPane().add(lblProgram);
			
			department tempDepartments = faculty.getFacultySet().get(ListWindow.getCurrentFaculty()).
					getDepartments().get(ListWindow.getCurrentDepartment());
			String[] departments = new String[tempDepartments.programSet.size()];
			for(int i = 0; i < tempDepartments.programSet.size(); i++) {
				departments[i] = tempDepartments.programSet.get(i).getName().replace("_", " ");
			}
			JComboBox comboBox_2 = new JComboBox(departments);
			comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			//comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Undergraduate", "Masters", "PhD", "Industry Specialized Masters", "Continuing Education", "Block Week Classes", "Deep Learning"}));
			comboBox_2.setBounds(W/2, (2*H)/5, W/5, H/20);
			frmEditView.getContentPane().add(comboBox_2);
			
			/////Components of a label and text input bar for the ID of a course
			JLabel lblId_1 = new JLabel("ID");
			lblId_1.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			lblId_1.setBounds(W/10, (7*H)/40, W/10, H/10);
			frmEditView.getContentPane().add(lblId_1);
			
			if(addOrEdit) {
				textField_4 = new JTextField();
			}
			else {
				textField_4 = new JTextField(getID());
			}
			textField_4.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			textField_4.setColumns(10);
			textField_4.setBounds(W/10, H/4, W/5, H/20);
			frmEditView.getContentPane().add(textField_4);
			/////////////////////////////////////////////////////////////////////
			
			/////Components of a label and drop down menu for anti-requisites of a course
			JLabel lblAntirequisites = new JLabel("Anti-Requisites");
			lblAntirequisites.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			lblAntirequisites.setBounds(W/2, (19*H)/40, W/6, H/10);
			frmEditView.getContentPane().add(lblAntirequisites);
			
			program tempProgram = faculty.getFacultySet().get(ListWindow.getCurrentFaculty()).
					getDepartments().get(ListWindow.getCurrentDepartment()).
					programSet.get(ListWindow.getCurrentProgram());
			String[] antiReqs = new String[tempProgram.courseSet.size()];
			for(int i = 0; i < tempProgram.courseSet.size(); i++) {
				antiReqs[i] = faculty.getFacultySet().get(ListWindow.getCurrentFaculty()).
				getDepartments().get(ListWindow.getCurrentDepartment()).
				programSet.get(ListWindow.getCurrentProgram()).courseSet.get(i).getName().replace("_", " ");
			}
			JComboBox comboBox_5 = new JComboBox(antiReqs);
			comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			comboBox_5.setBounds(W/2, (11*H)/20, W/5, H/20);
			frmEditView.getContentPane().add(comboBox_5);
			/////////////////////////////////////////////////////////////////////
			
			/////Components of a label and drop down menu for pre-requisites of a course
			JLabel lblPrerequisites = new JLabel("Pre-Requisites");
			lblPrerequisites.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			lblPrerequisites.setBounds(W/2, (5*H)/8, W/6, H/10);
			frmEditView.getContentPane().add(lblPrerequisites);
			
			String[] preReqs = new String[tempProgram.courseSet.size()];
			for(int i = 0; i < tempProgram.courseSet.size(); i++) {
				preReqs[i] = faculty.getFacultySet().get(ListWindow.getCurrentFaculty()).
				getDepartments().get(ListWindow.getCurrentDepartment()).
				programSet.get(ListWindow.getCurrentProgram()).courseSet.get(i).getName().replace("_", " ");
			}
			JComboBox comboBox_6 = new JComboBox(preReqs);
			comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			comboBox_6.setBounds(W/2, (7*H)/10, W/5, H/20);
			frmEditView.getContentPane().add(comboBox_6);
			/////////////////////////////////////////////////////////////////////
			
			/////Components of a label and text input bar for the Course Description of a course
			JLabel lblCourseDescription = new JLabel("Course Description");
			lblCourseDescription.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			lblCourseDescription.setBounds(W/10, (19*H)/40, W/6, H/10);
			frmEditView.getContentPane().add(lblCourseDescription);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			textField_1.setColumns(10);
			textField_1.setBounds(W/10, (11*H)/20, W/5, H/20);
			frmEditView.getContentPane().add(textField_1);
			///////////////////////////////////////////////////////////////////
			
			/////Components of a label and text input bar for any additional notes of a course
			JLabel lblNotes = new JLabel("Notes");
			lblNotes.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			lblNotes.setBounds(W/10, (5*H)/8, W/6, H/10);
			frmEditView.getContentPane().add(lblNotes);
			
			textField_8 = new JTextField();
			textField_8.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			textField_8.setColumns(10);
			textField_8.setBounds(W/10, (7*H)/10, W/5, H/20);
			frmEditView.getContentPane().add(textField_8);
			////////////////////////////////////////////////////////////////////
			
		}
		
		//Condition for displaying which buttons for the add window, or the edit window
		if(backGUI.getAddOrEdit()) {
			
			//Components for the add button, which will add an input to the database
			JButton btnChange = new JButton("Add");
			btnChange.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			btnChange.setBounds((19*W)/50, H - (H/6), W/10, H/15);
			frmEditView.getContentPane().add(btnChange);
		} 
		else {
			
			//Components for the edit button, which will change an objects data in the database
			JButton btnChange = new JButton("Change");
			btnChange.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			btnChange.setBounds((19*W)/50, H - (H/6), W/10, H/15);
			frmEditView.getContentPane().add(btnChange);
			
			//Components for the delete button, which will delete an objects data in the database
			JButton btnDelete = new JButton("Delete");
			btnDelete.setFont(new Font("Tahoma", Font.PLAIN, H/40));
			btnDelete.setBounds((14*W)/25, H - (H/6), W/10, H/15);
			frmEditView.getContentPane().add(btnDelete);
		}
		
	}
	
	public JFrame getFrame() {
		return frmEditView;
	}
	
	private String getName() {
		//Retrieving the selected Faculty, Department, Program, or Course
		if(windowType == 0) {
			return faculty.getFacultySet().get(ListWindow.getCurrentFaculty()).getName().replace("_", " ");
		}
		else if(windowType == 1) {
			return faculty.getFacultySet().get(ListWindow.getCurrentFaculty()).
			getDepartments().get(ListWindow.getCurrentDepartment()).getName().replace("_", " ");
		}
		else if(windowType == 2) {
			return faculty.getFacultySet().get(ListWindow.getCurrentFaculty()).
			getDepartments().get(ListWindow.getCurrentDepartment()).
			programSet.get(ListWindow.getCurrentProgram()).getName().replace("_", " ");
		}
		else {
			return faculty.getFacultySet().get(ListWindow.getCurrentFaculty()).
			getDepartments().get(ListWindow.getCurrentDepartment()).
			programSet.get(ListWindow.getCurrentProgram()).
			courseSet.get(ListWindow.getCurrentCourse()).getName().replace("_", " ");
		}
	}
	
	private String getID() {
		//Retrieving the selected Faculty, Department, Program, or Course
		return faculty.getFacultySet().get(ListWindow.getCurrentFaculty()).
		getDepartments().get(ListWindow.getCurrentDepartment()).
		programSet.get(ListWindow.getCurrentProgram()).
		courseSet.get(ListWindow.getCurrentCourse()).getID();
	}
}