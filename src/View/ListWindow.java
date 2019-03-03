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

/**
 * ListWindow class
 * The window which appears after the user has selected an option of database 
 * objects to view and pressed the GO button
 * @author Kaynen Mitchell
 *
 */
public class ListWindow {
	
	private static int windowType;
	
	private JFrame frmListView;
	/**
	 * Launch the application.
	 */
	
	public void main(int displayType) {
		windowType = displayType;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					ListWindow window = new ListWindow();
					window.frmListView.setVisible(true);
					
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
	public ListWindow() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		// the frame work for the window frame
		frmListView = new JFrame();
		frmListView.setTitle("Faculty, Department, Course and Program Management Screen");
		frmListView.setBounds(100, 100, 1100, 1100);
		frmListView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListView.getContentPane().setLayout(null);
		
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
		frmListView.getContentPane().add(exitButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmListView.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBack.setBounds(21, 938, 213, 70);
		frmListView.getContentPane().add(btnBack);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		if(windowType == 0) {
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
		else if(windowType == 1) {
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
		else if(windowType == 2) {
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
		
		list.setBounds(31, 21, 795, 873);
		frmListView.getContentPane().add(list);
		
		JButton btnEditdelete = new JButton("Edit/Delete");
		btnEditdelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(list.getSelectedIndex());
				if(list.getSelectedIndex() == 0) { //Will have to be changed to accommodate a list of values, use index's of original list
						frmListView.setVisible(false);
						EditWindow facultyWindow = new EditWindow();
						facultyWindow.main(windowType, false);
						frmListView.setVisible(true);
				}
			}
		});
		btnEditdelete.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEditdelete.setBounds(847, 374, 206, 158);
		frmListView.getContentPane().add(btnEditdelete);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmListView.setVisible(false);
				EditWindow facultyWindow = new EditWindow();
				facultyWindow.main(windowType, true);
				frmListView.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAdd.setBounds(847, 21, 206, 158);
		frmListView.getContentPane().add(btnAdd);
	}
}
