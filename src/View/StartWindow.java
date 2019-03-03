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

/**
 * StartWindow class
 * the window which appears as soon as the program runs
 * @author Manny Rodriguez
 *
 */
public class StartWindow {

	private JFrame frmWelcomeToSfu;

	/**
	 * Launch the application.
	 */
	public void main() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					StartWindow window = new StartWindow();
					window.frmWelcomeToSfu.setVisible(true);
					
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
	public StartWindow() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		// the frame work for the window frame
		frmWelcomeToSfu = new JFrame();
		frmWelcomeToSfu.setTitle("Welcome to SFU Course and Program Management ");
		frmWelcomeToSfu.setBounds(100, 100, 600, 600);
		frmWelcomeToSfu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToSfu.getContentPane().setLayout(null);
		
		// the combo box which is a drop down menu which displays the options of which "attribute" a user may wish to view
		String[] dropDownOptions = {"Faculty", "Department", "Program", "Courses"};
		JComboBox<String> comboBox = new JComboBox<String>(dropDownOptions);             // comment this line to work with window builder
		//JComboBox comboBox = new JComboBox();
		comboBox.setBounds(170, 183, 249, 22);
		frmWelcomeToSfu.getContentPane().add(comboBox);
		
		// components of the exit button of the window
		Button exitButton = new Button("Exit");
		exitButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				System.exit(0);
			}
		});
		exitButton.setBounds(252, 394, 79, 24);
		frmWelcomeToSfu.getContentPane().add(exitButton);
		
		// components of the go button of the window, which would take you to the next window which belongs to the drop down option the user chose
		Button goButton = new Button("Go");
		goButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int selection = comboBox.getSelectedIndex();
				//if(selection == 0)
				//{
					// go to faculty window
					frmWelcomeToSfu.setVisible(false);
					ListWindow facultyWindow = new ListWindow();
					facultyWindow.main(selection);
					frmWelcomeToSfu.setVisible(true);
				/*
				}
				
				else if(selection == 1)
				{
					// go to department window
					frmWelcomeToSfu.setVisible(false);
					ListWindow facultyWindow = new ListWindow();
					facultyWindow.main(selection);
				}
				
				else if(selection == 2)
				{
					// go to program window
					frmWelcomeToSfu.setVisible(false);
					ListWindow facultyWindow = new ListWindow();
					facultyWindow.main(selection);
				}
				
				else 
				{
					// go to course window
					frmWelcomeToSfu.setVisible(false);
					ListWindow facultyWindow = new ListWindow();
					facultyWindow.main(selection);
				}
				*/
			}
		});
		goButton.setBounds(467, 183, 55, 24);
		frmWelcomeToSfu.getContentPane().add(goButton);
		
		// components of the view label of the window
		Label viewLabel = new Label("View");
		viewLabel.setFont(new Font("Dubai Light", Font.PLAIN, 20));
		viewLabel.setBounds(109, 175, 55, 32);
		frmWelcomeToSfu.getContentPane().add(viewLabel);
		
		
		
	}
}
