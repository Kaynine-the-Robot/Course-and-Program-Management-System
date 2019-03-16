import java.util.ArrayList;

public class Main{
    public static void main(String[] args){

        Database database = new Database();

        database.read("Database.txt");

        for(int i = 0; i < Faculty.getFacultySet().size(); i++){
            System.out.println(Faculty.getFacultySet().get(i).getName());
            for(int j = 0; j < Faculty.getFacultySet().get(i).departmentSet.size(); j++){
                System.out.println("\t" + Faculty.getFacultySet().get(i).departmentSet.get(j).getName());
                for(int k = 0; k < Faculty.getFacultySet().get(i).departmentSet.get(j).programSet.size(); k++){
                    System.out.println("\t\t" + Faculty.getFacultySet().get(i).departmentSet.get(j).programSet.get(k).getName());
                    for(int l = 0; l < Faculty.getFacultySet().get(i).departmentSet.get(j).programSet.get(k).courseSet.size(); l++){
                        System.out.println("\t\t\t" + Faculty.getFacultySet().get(i).departmentSet.get(j).programSet.get(k).courseSet.get(l).getFullName() +
                                           " [" + Faculty.getFacultySet().get(i).departmentSet.get(j).programSet.get(k).courseSet.get(l).getFullID() + "]");
                    }
                }
            }
        }
    }
}