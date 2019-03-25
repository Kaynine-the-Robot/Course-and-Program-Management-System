package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import Controller.*;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LoginFrame {
	
	protected Shell shell;
	
	// User input
	private Text UserText;
	private Text UserPassword;
	private guiWindowController backGUI;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public void runLoginFrame(guiWindowController gui) {
		try {
			backGUI = gui;
			//LoginFrame window = new LoginFrame();
			this.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(107, 70, 55, 15);
		lblUsername.setText("Username:");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(107, 130, 55, 15);
		lblPassword.setText("Password:");
		
		UserText = new Text(shell, SWT.BORDER);
		UserText.setBounds(242, 67, 76, 21);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {			
				UserAuthentication auth = new UserAuthentication();
				Boolean pass = auth.checkIdPass(UserText.getText(), UserPassword.getText());
				
				// checks to see if the user name and the password match
				if(pass) {
					shell.dispose();
					backGUI.toggleForwardChange();
					backGUI.windowChange();
//					JOptionPane.showMessageDialog(null, "User valid, proceed");
				} else {
					JOptionPane.showMessageDialog(null, "You have entered an invalid username/password");
				}
			}
		});
		btnLogin.setBounds(107, 208, 75, 25);
		btnLogin.setText("Login");
		
		UserPassword = new Text(shell, SWT.BORDER);
		UserPassword.setBounds(242, 127, 76, 21);
		
		Button btnRegister = new Button(shell, SWT.NONE);
		btnRegister.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RegisterNewUser newUser = new RegisterNewUser();
				newUser.runRegistration();
				
			}
		});
		btnRegister.setBounds(243, 208, 75, 25);
		btnRegister.setText("Register");

	}
}
