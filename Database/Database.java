import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Database{

    private Faculty newFaculty = null;
    private Department newDepartment = null;
    private Program newProgram = null;        
    private Course newCourse = null;

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
                        newFaculty = new Faculty();
                        if(!newFaculty.setName(splitLine[1]) || !newFaculty.setID(splitLine[2])){
                            System.out.println("Line " + lineNumber + " is unable to be parsed!");
                            System.out.println(lineNumber + ": " + Arrays.toString(splitLine));
                        }
                    }
                    //PARSER FOR DEPARTMENTS
                    else if(splitLine[0].equals("=")){
                        newDepartment = new Department();
                        if((!newDepartment.setName(splitLine[1]) || !newDepartment.setID(splitLine[2])) || !newDepartment.setFaculty(newFaculty)){
                            System.out.println("Line " + lineNumber + " is unable to be parsed!");
                            System.out.println(lineNumber + ": " + Arrays.toString(splitLine));
                        }
                    }
                    //PARSER FOR PROGRAMS
                    else if(splitLine[0].equals("+")){
                        newProgram = new Program();
                        if((!newProgram.setName(splitLine[1]) || !newProgram.setID(splitLine[2])) || !newProgram.setDepartment(newDepartment)){
                            System.out.println("Line " + lineNumber + " is unable to be parsed!");
                            System.out.println(lineNumber + ": " + Arrays.toString(splitLine));
                        }
                    }
                    //PARSER FOR COURSES
                    else if(splitLine[0].equals("-")){
                        newCourse = new Course();
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
}
