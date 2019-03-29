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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class LoginFrame {
	
	protected Shell shlLogin;
	
	// User input
	private Text UserText;
	private Text UserPassword;
	private guiWindowController backGUI;
	
	
	
	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
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
		shlLogin.open();
		shlLogin.layout();
		while (!shlLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLogin = new Shell();
		shlLogin.setSize(609, 494);
		shlLogin.setText("Login");
		shlLogin.setLayout(null);
		
		Label lblUsername = new Label(shlLogin, SWT.NONE);
		lblUsername.setBounds(189, 83, 88, 21);
		lblUsername.setText("Username:");
		
		Label lblPassword = new Label(shlLogin, SWT.NONE);
		lblPassword.setBounds(189, 133, 76, 21);
		lblPassword.setText("Password:");
		
		UserText = new Text(shlLogin, SWT.BORDER);
		UserText.setBounds(281, 83, 111, 21);
		
		Button btnLogin = new Button(shlLogin, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UserAuthentication auth = new UserAuthentication();
				boolean pass;
				// checks to see if the user inputs are empty
				Boolean noInput = auth.checkEmptyInput(UserText.getText(), UserPassword.getText());
				if(noInput == true) {
					pass = false;
				} else {
					pass = auth.checkIdPass(UserText.getText(), UserPassword.getText());
				}
				
				// checks to see if the user name and the password match
				if(pass) {
					shlLogin.dispose();
					backGUI.setFlag(pass);
					backGUI.toggleForwardChange();
					backGUI.windowChange();
				} else {
					JOptionPane.showMessageDialog(null, "You have entered an invalid username/password");
				}
			}
		});
		btnLogin.setBounds(177, 207, 75, 25);
		btnLogin.setText("Login");
		
		UserPassword = new Text(shlLogin, SWT.BORDER);
		UserPassword.setBounds(281, 130, 111, 21);
		
		Button btnRegister = new Button(shlLogin, SWT.NONE);
		btnRegister.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RegisterNewUser newUser = new RegisterNewUser();
				newUser.runRegistration();
				
			}
		});
		btnRegister.setBounds(326, 207, 88, 25);
		btnRegister.setText("Register");
		
		Label lblAdministratorLogin = new Label(shlLogin, SWT.NONE);
		lblAdministratorLogin.setBounds(209, 20, 163, 30);
		lblAdministratorLogin.setText("Administrator Login");
		
		Label lblForgotYourUsername = new Label(shlLogin, SWT.NONE);
		lblForgotYourUsername.setBounds(173, 263, 241, 30);
		lblForgotYourUsername.setText("Forgot your username or password?");
		
		Button btnFindPassword = new Button(shlLogin, SWT.NONE);
		btnFindPassword.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FindPasswordFrame password = new FindPasswordFrame();
				password.runPasswordFinder();
			}
		});
		btnFindPassword.setBounds(141, 299, 111, 25);
		btnFindPassword.setText("Find Password");
		
		Button btnFindUsername = new Button(shlLogin, SWT.NONE);
		btnFindUsername.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FindUsernameFrame username = new FindUsernameFrame();
				username.runUsernameFinder();
			}
		});
		btnFindUsername.setBounds(329, 299, 122, 25);
		btnFindUsername.setText("Find Username");
		
		Label lblAreYouA = new Label(shlLogin, SWT.NONE);
		lblAreYouA.setBounds(94, 354, 446, 30);
		lblAreYouA.setText("Are you a student? Access the portal by clicking the button below!");
		
		Button btnStudentAccess = new Button(shlLogin, SWT.NONE);
		btnStudentAccess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				backGUI.setFlag(false);
				shlLogin.dispose();
				backGUI.toggleForwardChange();
				backGUI.windowChange();
			}
		});
		btnStudentAccess.setBounds(242, 390, 116, 25);
		btnStudentAccess.setText("Student Access");
		

	}
	

}
