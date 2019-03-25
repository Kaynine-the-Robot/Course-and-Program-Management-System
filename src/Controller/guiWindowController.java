package Controller;

import java.awt.EventQueue;

import View.*;


public class guiWindowController {
	
	//This is a flag for if the screen only had an add button or the edit and delete buttons instead.
	private boolean addOrEdit = false;
	//This is a flag for if the screen only had an add button or the edit and delete buttons instead.
	private boolean addAndEdit = false;
	//The Height of the full screen window
	private int H;
	//The width of the full screen window
	private int W;
	private boolean forwardChange = false;
	private boolean backChange = false;
	private int savedWindow;
	private int currentWindow;
	private int listWindowType = 0;
	
	public guiWindowController(int width, int height) {
		currentWindow = 0;
		W = width;
		H = height;
	}
	
	public void windowChange() {
		
		if(addAndEdit == true) {
			savedWindow = currentWindow;
			currentWindow = 6;
		}
		if(forwardChange == true && backChange == false) {
			switch (currentWindow) {
				case 0:
					currentWindow = 1;
					forwardChange = false;
					openLoginWindow(W, H);
					break;
				case 1:
					currentWindow = 2;
					forwardChange = false;
					openStartWindow(W, H);
					break;
				case 2:
					currentWindow = 3;
					forwardChange = false;
					openListWindow(W, H);
					break;
				case 3:
					currentWindow = 4;
					listWindowType ++;
					forwardChange = false;
					openListWindow(W, H);
					break;
				case 4:
					currentWindow = 5;
					listWindowType ++;
					forwardChange = false;
					openListWindow(W, H);
					break;
				case 5:
					listWindowType ++;
					forwardChange = false;
					openListWindow(W, H);
					break;
				case 6:
					currentWindow = 7;
					forwardChange = false;
					addAndEdit = false;
					openEditWindow(W, H);
					break;
				
					
				default:
					//Resets, prints error message
					forwardChange = false;
					backChange = false;
					currentWindow = 0;
					windowChange();
					System.out.println("Sorry, something went wrong, try again");
					break;
			}
		} else if(forwardChange == false && backChange == true){
			switch (currentWindow) {
				case 0:
				case 1:
				case 2:
				case 3:
					currentWindow = 2;
					backChange = false;
					openStartWindow(W, H);
					break;
				case 4:
					currentWindow = 3;
					listWindowType --;
					backChange = false;
					openListWindow(W, H);
					break;
				case 5:
					currentWindow = 4;
					listWindowType --;
					backChange = false;
					openListWindow(W, H);
					break;
				case 6:
					currentWindow = 5;
					listWindowType --;
					backChange = false;
					openListWindow(W, H);
					break;
				case 7:
					currentWindow = savedWindow;
					backChange = false;
					openListWindow(W, H);
					break;
				default:
					//Resets, prints error message
					forwardChange = false;
					backChange = false;
					currentWindow = 0;
					windowChange();
					System.out.println("Sorry, something went wrong, try again");
					break;
			}
		} else {
			//Resets, prints error message
			forwardChange = true;
			backChange = false;
			currentWindow = 1;
			windowChange();
			System.out.println("Sorry, something went wrong, try again");
		}
		
	}
	
	public void openLoginWindow(int width, int height) {
	
		LoginFrame login = new LoginFrame();
		login.runLoginFrame(this);
		
	}
	
	private void openStartWindow(int width, int height) {

					StartWindow start = new StartWindow(width, height, this);
					start.getFrame().setVisible(true);
	}
	
	private void openListWindow(int width, int height) {
					ListWindow start = new ListWindow(width, height, this);
					start.getFrame().setVisible(true);
		 
	}
	
	private void openEditWindow(int width, int height) {
		EditWindow start = new EditWindow(width, height, this, currentWindow - 4, addOrEdit);
		addOrEdit = false;
		start.getFrame().setVisible(true);

	}
	
	public void toggleForwardChange() {
		forwardChange = true;
	}
	
	public boolean getForwardChange() {
		return forwardChange;
	}
	
	public void toggleBackChange() {
		backChange = true;
	}
	
	public boolean getBackChange() {
		return backChange;
	}
	
	//This method toggles if it is necessary to go to the Add/Edit window 
	public void toggleAddAndEdit() {
		addAndEdit = true;
	}
	
	//This method toggles if it is necessary to display an Add window or an Edit window
	public void toggleAddOrEdit() {
		addOrEdit = true;
	}
	
	public boolean getAddOrEdit() {
		return addOrEdit;
	}
	
	public int getListWindowType() {
		return listWindowType;
	}

}
