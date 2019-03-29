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

public class FindUsernameFrame {

	protected Shell shell;
	private Text userEmail;
	private Button btnCancel;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void runUsernameFinder() {
		try {
			FindUsernameFrame window = new FindUsernameFrame();
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
		
		Label lblYourEmail = new Label(shell, SWT.NONE);
		lblYourEmail.setBounds(98, 53, 64, 15);
		lblYourEmail.setText("Your email:");
		
		userEmail = new Text(shell, SWT.BORDER);
		userEmail.setBounds(250, 47, 76, 21);
		
		Button btnFind = new Button(shell, SWT.NONE);
		btnFind.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UserAuthentication findUsername = new UserAuthentication();
				String username = findUsername.userNameFinder(userEmail.getText());
				
				if(username == "") {
					JOptionPane.showMessageDialog(null, "You have entered an invalid email");
				} else {
					JOptionPane.showMessageDialog(null, "Your username is: " + username);
					shell.dispose();
				}
			}
		});
		btnFind.setBounds(98, 161, 75, 25);
		btnFind.setText("Find");
		
		btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnCancel.setBounds(250, 161, 75, 25);
		btnCancel.setText("Cancel");

	}

}