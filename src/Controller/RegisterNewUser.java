package Controller;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RegisterNewUser {

	protected Shell shell;
	private Text newUserName;
	private Text newUserPassword;
	private Text userEmail;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void runRegistration() {
		try {
			RegisterNewUser window = new RegisterNewUser();
			window.open();
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
		
		Label lblUserName = new Label(shell, SWT.NONE);
		lblUserName.setBounds(88, 75, 87, 15);
		lblUserName.setText("New Username:");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(88, 121, 87, 15);
		lblNewLabel.setText("New Password:");
		
		newUserName = new Text(shell, SWT.BORDER);
		newUserName.setBounds(227, 72, 76, 21);
		
		newUserPassword = new Text(shell, SWT.BORDER);
		newUserPassword.setBounds(227, 121, 76, 21);
		
		userEmail = new Text(shell, SWT.BORDER);
		userEmail.setBounds(227, 166, 76, 21);
		
		Button btnConfirm = new Button(shell, SWT.NONE);
		btnConfirm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UserAuthentication newUser = new UserAuthentication();
				boolean invalid = newUser.checkEmptyInput(newUserName.getText(), newUserPassword.getText());
				boolean existingId = newUser.checkUsername(newUserName.getText());
				if(invalid == true || existingId == true) {
					if(invalid == true) {
						JOptionPane.showMessageDialog(null, "You have entered an invalid username/password");
					} else {
						JOptionPane.showMessageDialog(null, "The Username you entered already exists");
					}
				} else {
					newUser.register(newUserName.getText(), newUserPassword.getText(), userEmail.getText());
					btnConfirm.setEnabled(false);
					shell.dispose();
				}
				
			}
		});
		btnConfirm.setBounds(88, 215, 75, 25);
		btnConfirm.setText("confirm");
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnCancel.setBounds(228, 215, 75, 25);
		btnCancel.setText("cancel");
		
		Label lblRegistrationForm = new Label(shell, SWT.NONE);
		lblRegistrationForm.setBounds(153, 24, 99, 15);
		lblRegistrationForm.setText("Registration Form");
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(88, 169, 32, 15);
		lblEmail.setText("Email:");

	}
}