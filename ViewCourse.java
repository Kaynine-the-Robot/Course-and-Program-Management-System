package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

import Model.course;

import javax.swing.JTextPane;

public class ViewCourse {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public ViewCourse(course course) {
		initialize(course);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(course course) {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.setBounds(100, 100, 900, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton closeButton = new JButton("Close");
		closeButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		closeButton.setBounds(382, 906, 129, 34);
		frame.getContentPane().add(closeButton);
		
		JLabel faculty = new JLabel("Faculty");
		faculty.setFont(new Font("Tahoma", Font.PLAIN, 18));
		faculty.setBounds(125, 197, 113, 34);
		frame.getContentPane().add(faculty);
		
		JLabel department = new JLabel("Department");
		department.setFont(new Font("Tahoma", Font.PLAIN, 18));
		department.setBounds(553, 203, 161, 26);
		frame.getContentPane().add(department);
		
		JLabel program = new JLabel("Program");
		program.setFont(new Font("Tahoma", Font.PLAIN, 18));
		program.setBounds(125, 328, 92, 26);
		frame.getContentPane().add(program);
		
		JLabel preRequisites = new JLabel("Prerequisites");
		preRequisites.setFont(new Font("Tahoma", Font.PLAIN, 18));
		preRequisites.setBounds(92, 433, 161, 26);
		frame.getContentPane().add(preRequisites);
		
		JLabel antiRequisites = new JLabel("antirequisites");
		antiRequisites.setFont(new Font("Tahoma", Font.PLAIN, 18));
		antiRequisites.setBounds(559, 429, 121, 34);
		frame.getContentPane().add(antiRequisites);
		
		JLabel id = new JLabel("ID");
		id.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id.setBounds(605, 328, 92, 26);
		frame.getContentPane().add(id);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		name.setBounds(336, 43, 50, 50);
		frame.getContentPane().add(name);
		
		JLabel description = new JLabel("Course Description");
		description.setFont(new Font("Tahoma", Font.PLAIN, 18));
		description.setBounds(78, 642, 186, 26);
		frame.getContentPane().add(description);
		
		JLabel notes = new JLabel("Notes");
		notes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		notes.setBounds(588, 642, 92, 26);
		frame.getContentPane().add(notes);
		
		JLabel courseName = new JLabel(course.getName());
		courseName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseName.setHorizontalAlignment(SwingConstants.CENTER);
		courseName.setBackground(Color.WHITE);
		courseName.setForeground(Color.BLACK);
		courseName.setBounds(230, 90, 259, 50);
		frame.getContentPane().add(courseName);
		
		JLabel courseFaculty = new JLabel(course.itsprogram.getName());
		courseFaculty.setBackground(Color.WHITE);
		courseFaculty.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseFaculty.setHorizontalAlignment(SwingConstants.CENTER);
		courseFaculty.setBounds(52, 230, 186, 41);
		frame.getContentPane().add(courseFaculty);
		
		JLabel courseDepartment = new JLabel(course.itsDepartment.getName());
		courseDepartment.setBackground(Color.WHITE);
		courseDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		courseDepartment.setBounds(516, 242, 198, 41);
		frame.getContentPane().add(courseDepartment);
		
		JLabel courseProgram = new JLabel("New label");
		courseProgram.setHorizontalAlignment(SwingConstants.CENTER);
		courseProgram.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseProgram.setBounds(52, 366, 186, 50);
		frame.getContentPane().add(courseProgram);
		
		JLabel courseID = new JLabel("New label");
		courseID.setHorizontalAlignment(SwingConstants.CENTER);
		courseID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseID.setBounds(571, 367, 97, 41);
		frame.getContentPane().add(courseID);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(52, 684, 201, 169);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(52, 472, 215, 126);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(516, 476, 215, 126);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(516, 684, 259, 169);
		frame.getContentPane().add(lblNewLabel_5);
		
	}
}
