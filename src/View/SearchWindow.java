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

	private JFrame frmSeartch;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchWindow window = new SearchWindow();
					window.frmSeartch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeartch = new JFrame();
		frmSeartch.setTitle("Search");
		frmSeartch.setBounds(100, 100, 609, 494);
		frmSeartch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeartch.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Look for:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(41, 122, 62, 33);
		frmSeartch.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(132, 129, 327, 20);
		frmSeartch.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(489, 128, 89, 23);
		frmSeartch.getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Faculty", "Department", "Program", "Course"}));
		comboBox.setBounds(132, 213, 327, 22);
		frmSeartch.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(132, 409, 89, 23);
		frmSeartch.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Explore");
		btnNewButton_2.setBounds(370, 409, 89, 23);
		frmSeartch.getContentPane().add(btnNewButton_2);
	}
}
