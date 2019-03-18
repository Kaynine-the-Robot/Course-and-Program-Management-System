package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserAuthentication {

	String fileName = "passwordCheck.txt";
	String line = "";
	Boolean authenticate = false;
	
	public Boolean checkIdPass(String userInputName, String userInputPassword) {
	
	try {
		FileReader fileReader = new FileReader(fileName);
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		line = bufferedReader.readLine();
		
		while(line != null) {
			String[] idPass = line.split(" ");
			
			if(idPass[0].contentEquals(userInputName) && idPass[1].contentEquals(userInputPassword)) {
				authenticate = true;
				line = null;
			} else {
				line = bufferedReader.readLine();
			}
//			System.out.println(authenticate);
		}
		bufferedReader.close();
	} catch(FileNotFoundException ex) {
		System.out.print("No Such File");
	} catch(IOException ex) {
		System.out.print("Error reading file");
	}
	return authenticate;
	}

	public void register(String newUserName, String newUserPassword) {
		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			
			bufferWriter.newLine();
			bufferWriter.write(newUserName + " " + newUserPassword);
			
			bufferWriter.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}