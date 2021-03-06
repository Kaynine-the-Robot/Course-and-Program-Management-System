/**
* This file will put up a frame for the user to find the missing username
*
* @author  Jung Kim
* @version 1.0
* @last worked   2019-04-08 
*/

package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import Controller.UserAuthentication;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;

public class FindUsernameFrame {

	protected Shell shell;
	private Text userEmail;
	private Button btnCancel;
	
	//Setting the Width and Height of the Screen as Class attributes
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final int W = screenSize.width;
	final int H = screenSize.height;

	public void openLoginWindow(int W, int H) {
		LoginFrame login = new LoginFrame();
		login.runLoginFrame(null);
	}
	
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
		createContents(display);
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
	protected void createContents(Display display) {
		shell = new Shell();
		shell.setSize(W, H);
		shell.setText("Find My ID");
		
		// Centers window
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();
					    
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
					    
		shell.setLocation(x, y);
		
		// Label
		Label lblYourEmail = new Label(shell, SWT.NONE);
		lblYourEmail.setFont(SWTResourceManager.getFont("Tahoma", 17, SWT.NORMAL));
		lblYourEmail.setBounds(W/3, H/5, 150, 40);
		lblYourEmail.setText("Your email:");
		
		// User input
		userEmail = new Text(shell, SWT.BORDER);
		userEmail.setFont(SWTResourceManager.getFont("Tahoma", 17, SWT.NORMAL));
		userEmail.setBounds(W/2, H/5, 200, 40);
		
		// Button
		// If user enters a valid email, message dialog will pop up with its username
		Button btnFind = new Button(shell, SWT.NONE);
		btnFind.setFont(SWTResourceManager.getFont("Tahoma", 17, SWT.NORMAL));
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
		btnFind.setBounds(W/3, H - H/2 + H/9, 170, 40);
		btnFind.setText("Find");
		
		btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setFont(SWTResourceManager.getFont("Tahoma", 17, SWT.NORMAL));
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				openLoginWindow(W, H);
			}
		});
		btnCancel.setBounds(W/2 + W/25, H - H/2 + H/9, 170, 40);
		btnCancel.setText("Cancel");

	}

}