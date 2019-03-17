package Controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import View.*;
import Model.*;

public class Main {

	public static void main(String[] args) {
		
		//Setting the Width and Height of the Screen as Class attributes
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int W = screenSize.width;
		final int H = screenSize.height;
		
		database database = new database();
		
        database.read("src/Model/database.txt");

        for(int i = 0; i < faculty.getFacultySet().size(); i++){
            System.out.println(faculty.getFacultySet().get(i).getName());
            for(int j = 0; j < faculty.getFacultySet().get(i).departmentSet.size(); j++){
                System.out.println("\t" + faculty.getFacultySet().get(i).departmentSet.get(j).getName());
                for(int k = 0; k < faculty.getFacultySet().get(i).departmentSet.get(j).programSet.size(); k++){
                    System.out.println("\t\t" + faculty.getFacultySet().get(i).departmentSet.get(j).programSet.get(k).getName());
                    for(int l = 0; l < faculty.getFacultySet().get(i).departmentSet.get(j).programSet.get(k).courseSet.size(); l++){
                        System.out.println("\t\t\t" + faculty.getFacultySet().get(i).departmentSet.get(j).programSet.get(k).courseSet.get(l).getFullName() +
                                           " [" + faculty.getFacultySet().get(i).departmentSet.get(j).programSet.get(k).courseSet.get(l).getFullID() + "]");
                    }
                }
            }
        }
		
		StartWindow start = new StartWindow();
		start.main(W, H);

	}

}
