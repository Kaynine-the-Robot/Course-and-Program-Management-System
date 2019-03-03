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
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;

/**
 * Listindow class
 * The window which appears after the use has selected an option of database 
 * objects to view and pressed the GO button
 * @author Kaynen Mitchell
 *
 */
public class EditWindow {
	
	private static int windowType;
	private static boolean addOrEdit;
	
	private JFrame frmEditView;
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	
	public void main(int displayType, boolean bool) {
		windowType = displayType;
		addOrEdit = bool;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					EditWindow window = new EditWindow();
					window.frmEditView.setVisible(true);
					
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
	public EditWindow() 
	{
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
		frmEditView.setBounds(100, 100, 1100, 1100);
		frmEditView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditView.getContentPane().setLayout(null);
		
		// components of the exit button of the window
		JButton exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Dialog", Font.PLAIN, 30));
		exitButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				System.exit(0);
			}
		});
		exitButton.setBounds(935, 906, 118, 102);
		frmEditView.getContentPane().add(exitButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmEditView.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBack.setBounds(21, 938, 213, 70);
		frmEditView.getContentPane().add(btnBack);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblName.setBounds(333, 607, 92, 26);
		frmEditView.getContentPane().add(lblName);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setColumns(10);
		textField.setBounds(203, 652, 325, 70);
		frmEditView.getContentPane().add(textField);
		
		
		
		if(windowType == 1 | windowType == 2 | windowType == 3) {
			
			JLabel lblId = new JLabel("Faculty");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblId.setBounds(333, 21, 92, 26);
			frmEditView.getContentPane().add(lblId);
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 30));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Science"}));
			comboBox.setBounds(203, 60, 325, 70);
			frmEditView.getContentPane().add(comboBox);
			
		}
		
		if(windowType == 2 | windowType == 3) {
			
			JLabel lblDepartment = new JLabel("Department");
			lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblDepartment.setBounds(307, 203, 161, 26);
			frmEditView.getContentPane().add(lblDepartment);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Computer Science"}));
			comboBox_1.setBounds(203, 239, 325, 70);
			frmEditView.getContentPane().add(comboBox_1);
			
		}
		
		
		if(windowType == 3) {
			
			JLabel lblProgram = new JLabel("Program");
			lblProgram.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblProgram.setBounds(321, 404, 92, 26);
			frmEditView.getContentPane().add(lblProgram);
			JComboBox comboBox_2 = new JComboBox();
			comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Undergraduate", "Masters", "PhD", "Industry Specialized Masters", "Continuing Education", "Block Week Classes", "Deep Learning"}));
			comboBox_2.setBounds(203, 451, 325, 70);
			frmEditView.getContentPane().add(comboBox_2);
			
			JLabel lblId_1 = new JLabel("ID");
			lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblId_1.setBounds(758, 607, 92, 26);
			frmEditView.getContentPane().add(lblId_1);
			textField_4 = new JTextField();
			textField_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
			textField_4.setColumns(10);
			textField_4.setBounds(627, 652, 325, 70);
			frmEditView.getContentPane().add(textField_4);
			
			JLabel lblAntirequisites = new JLabel("Anti-Requisites");
			lblAntirequisites.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblAntirequisites.setBounds(672, 404, 147, 26);
			frmEditView.getContentPane().add(lblAntirequisites);
			JComboBox comboBox_5 = new JComboBox();
			comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
			comboBox_5.setBounds(627, 451, 325, 70);
			frmEditView.getContentPane().add(comboBox_5);
			
			JLabel lblPrerequisites = new JLabel("Pre-Requisites");
			lblPrerequisites.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblPrerequisites.setBounds(689, 203, 161, 26);
			frmEditView.getContentPane().add(lblPrerequisites);
			JComboBox comboBox_6 = new JComboBox();
			comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
			comboBox_6.setBounds(627, 239, 325, 70);
			frmEditView.getContentPane().add(comboBox_6);
			
			JLabel lblCourseDescription = new JLabel("Course Description");
			lblCourseDescription.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblCourseDescription.setBounds(282, 768, 186, 26);
			frmEditView.getContentPane().add(lblCourseDescription);
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
			textField_1.setColumns(10);
			textField_1.setBounds(203, 815, 325, 70);
			frmEditView.getContentPane().add(textField_1);
			
			JLabel lblNotes = new JLabel("Notes");
			lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblNotes.setBounds(731, 768, 92, 26);
			frmEditView.getContentPane().add(lblNotes);
			textField_8 = new JTextField();
			textField_8.setFont(new Font("Tahoma", Font.PLAIN, 30));
			textField_8.setColumns(10);
			textField_8.setBounds(627, 815, 325, 70);
			frmEditView.getContentPane().add(textField_8);
			
		}
		
		if(addOrEdit) {
			JButton btnChange = new JButton("Add");
			btnChange.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnChange.setBounds(315, 938, 213, 70);
			frmEditView.getContentPane().add(btnChange);
		} 
		else {
			JButton btnChange = new JButton("Change");
			btnChange.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnChange.setBounds(315, 938, 213, 70);
			frmEditView.getContentPane().add(btnChange);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnDelete.setBounds(610, 938, 213, 70);
			frmEditView.getContentPane().add(btnDelete);
		}
		
	}
}