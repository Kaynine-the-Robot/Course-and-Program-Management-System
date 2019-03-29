package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import Controller.UserAuthentication;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class FindPasswordFrame {

	protected Shell shell;
	private Text userName;
	private Text userEmail;
	private Button btnCancel;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void runPasswordFinder() {
		try {
			FindPasswordFrame window = new FindPasswordFrame();
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
		
		Label lblYourUsername = new Label(shell, SWT.NONE);
		lblYourUsername.setBounds(90, 42, 90, 15);
		lblYourUsername.setText("Your Username:");
		
		userName = new Text(shell, SWT.BORDER);
		userName.setBounds(232, 39, 76, 21);
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(90, 103, 55, 15);
		lblEmail.setText("Email:");
		
		userEmail = new Text(shell, SWT.BORDER);
		userEmail.setBounds(232, 100, 76, 21);
		
		Button btnFind = new Button(shell, SWT.NONE);
		btnFind.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UserAuthentication findPassword = new UserAuthentication();
				String password = findPassword.passwordFinder(userName.getText(), userEmail.getText());
				
				if(password == "") {
					JOptionPane.showMessageDialog(null, "You have entered an invalid username and/or email");
				} else {
					JOptionPane.showMessageDialog(null, "Your password is: " + password);
					shell.dispose();
				}
			}
		});
		btnFind.setBounds(90, 159, 75, 25);
		btnFind.setText("Find");
		
		btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnCancel.setBounds(232, 159, 75, 25);
		btnCancel.setText("Cancel");

	}

}