package Controller;

import java.util.Arrays;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import Model.*;

public class database{

    private faculty newFaculty = null;
    private department newDepartment = null;
    private program newProgram = null;        
    private course newCourse = null;

    public void read(String textFile){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(textFile));
            String line = reader.readLine();
            int lineNumber = 0;
            while(line != null){
                lineNumber++;
                String fullLine = line.trim();
                if(fullLine.length() > 0){
                    String[] splitLine = fullLine.split("\\s+");
                    //PARSER FOR COMMENTS
                    if(splitLine[0].equals("#")){
                        ; //Do nothing, we don't want to parse comments
                    }
                    //PARSER FOR FACULTIES
                    else if(splitLine[0].equals(">")){
                        newFaculty = new faculty();
                        if(!newFaculty.setName(splitLine[1]) || !newFaculty.setID(splitLine[2])){
                            System.out.println("Line " + lineNumber + " is unable to be parsed!");
                            System.out.println(lineNumber + ": " + Arrays.toString(splitLine));
                        }
                    }
                    //PARSER FOR DEPARTMENTS
                    else if(splitLine[0].equals("=")){
                        newDepartment = new department();
                        if((!newDepartment.setName(splitLine[1]) || !newDepartment.setID(splitLine[2])) || !newDepartment.setFaculty(newFaculty)){
                            System.out.println("Line " + lineNumber + " is unable to be parsed!");
                            System.out.println(lineNumber + ": " + Arrays.toString(splitLine));
                        }
                    }
                    //PARSER FOR PROGRAMS
                    else if(splitLine[0].equals("+")){
                        newProgram = new program();
                        if((!newProgram.setName(splitLine[1]) || !newProgram.setID(splitLine[2])) || !newProgram.setDepartment(newDepartment)){
                            System.out.println("Line " + lineNumber + " is unable to be parsed!");
                            System.out.println(lineNumber + ": " + Arrays.toString(splitLine));
                        }
                    }
                    //PARSER FOR COURSES
                    else if(splitLine[0].equals("-")){
                        newCourse = new course();
                        if((!newCourse.setName(splitLine[1], splitLine[2]) || !newCourse.setID(splitLine[3])) || !newCourse.setProgram(newProgram)){
                            System.out.println("Line " + lineNumber + " is unable to be parsed!");
                            System.out.println(lineNumber + ": " + Arrays.toString(splitLine));
                        }
                    }
                    //PARSER FOR ANYTHING THAT IS NOT FORMATTED PROPERLY OR UNWANTED INFORMATION
                    else{
                        System.out.println("Line " + lineNumber + " is unable to be parsed!");
                        System.out.println(lineNumber + ": " + Arrays.toString(splitLine));
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void write(String textFile, faculty faculty){
        File file = new File(textFile);
		FileWriter fWriter = null;
		BufferedWriter bWriter = null;
		try{
		    fWriter = new FileWriter(file, true);
		    bWriter = new BufferedWriter(fWriter);
		    bWriter.write("\n> " + faculty.getName() + " " + faculty.getID());
		} catch(IOException e){
		    e.printStackTrace();
		} finally{
		    try{
			bWriter.close();
			fWriter.close();
		    } catch(IOException e){
			e.printStackTrace();
		    }
		}
    }

    public void write(String textFile, department department){
		faculty itsFaculty = department.itsfaculty;
	
		PrintWriter writer = null;
		BufferedReader bReader = null;
		FileReader fReader = null;
		try{
		    writer = new PrintWriter(new BufferedWriter(new FileWriter("Database.temp")));
		    fReader = new FileReader(textFile);
		    bReader = new BufferedReader(fReader);
		    String line;
		    while((line = bReader.readLine()) != null){
			if(itsFaculty.getFullLine().equals(line)){
			    writer.println(line);
			    writer.println("\n\t= " + department.getName() + " " + department.getID());
			}
			else{
			    writer.println(line);
			}
		    }
		} catch(IOException e){
		    e.printStackTrace();
		} finally{
		    try{
			fReader.close();
			writer.close();
	
			File realName = new File(textFile);
			realName.delete();
			new File("Database.temp").renameTo(realName);
		    } catch(IOException e){
			e.printStackTrace();
		    }
		}
    }

    public void write(String textFile, program program){
		department itsDepartment = program.itsdepartment;
	
		PrintWriter writer = null;
		BufferedReader bReader = null;
		FileReader fReader = null;
		try{
		    writer = new PrintWriter(new BufferedWriter(new FileWriter("Database.temp")));
		    fReader = new FileReader(textFile);
		    bReader = new BufferedReader(fReader);
		    String line;
		    while((line = bReader.readLine()) != null){
			if(itsDepartment.getFullLine().equals(line)){
			    writer.println(line);
			    writer.println("\n\t\t+ " + program.getName() + " " + program.getID());
			}
			else{
			    writer.println(line);
			}
		    }
		} catch(IOException e){
		    e.printStackTrace();
		} finally{
		    try{
			fReader.close();
			writer.close();
	
			File realName = new File(textFile);
			realName.delete();
			new File("Database.temp").renameTo(realName);
		    } catch(IOException e){
			e.printStackTrace();
		    }
		}
    }
    
    public void write(String textFile, course course){
		program itsProgram = course.itsprogram;
	
		PrintWriter writer = null;
		BufferedReader bReader = null;
		FileReader fReader = null;
		try{
		    writer = new PrintWriter(new BufferedWriter(new FileWriter("Database.temp")));
		    fReader = new FileReader(textFile);
		    bReader = new BufferedReader(fReader);
		    String line;
		    while((line = bReader.readLine()) != null){
			if(itsProgram.getFullLine().equals(line)){
			    writer.println(line);
			    writer.println("\n\t\t\t- " + course.getFullName() + " " + course.getID());
			}
			else{
			    writer.println(line);
			}
		    }
		} catch(IOException e){
		    e.printStackTrace();
		} finally{
		    try{
			fReader.close();
			writer.close();
	
			File realName = new File(textFile);
			realName.delete();
			new File("Database.temp").renameTo(realName);
		    } catch(IOException e){
			e.printStackTrace();
		    }
		}
    }
}
