package Model;

import java.util.ArrayList;

public class course {
	private String name;
	private String courseNum;
	private String ID;
	public program itsprogram;
	//private static ArrayList<Integer> deletedIDs;
	public static ArrayList<course> allCourses = new ArrayList<course>();
	
	public course() {
		allCourses.add(this);
	}
	
	public boolean setProgram(program newprogram) {
		program oldprogram = itsprogram;
		itsprogram = newprogram;
		if(setName(this.name,this.courseNum)&&setID(this.ID)) {
			return true;
		}
		itsprogram = oldprogram;
		return false;
	}
	
	public boolean setName(String name,String courseNum) {
		if(courseNum.length()!=3) {
			return false;
		}
		try{
			Integer.parseInt(courseNum);
		}catch(Exception e){
			return false;
		}
		
		if(itsprogram == null) {
			this.name = name;
			this.courseNum=courseNum;
			return true;
		}
		String nameUpper = name.toUpperCase()+courseNum;
		itsprogram.courseSet.remove(this);
		for (int i = 0; i < itsprogram.courseSet.size();i++) {
			if(itsprogram.courseSet.get(i).getFullName().toUpperCase().equals(nameUpper)){
				itsprogram.courseSet.add(this);
				return false;
			}
		}
		this.name = name;
		this.courseNum = courseNum;
		itsprogram.courseSet.add(this);
		return true;	
	}
	
	public boolean setID(String ID) {
		if (ID.length()!=2) {
			return false;
		}
		try {
			Integer.parseInt(ID);
		}catch(Exception e) {
			return false;
		}
		if (itsprogram == null) {
			this.ID = ID;
			return true;
		}
		itsprogram.courseSet.remove(this);
		for(int i = 0; i < itsprogram.courseSet.size();i++) {
			if(itsprogram.courseSet.get(i).getID().equals(ID)) {
				itsprogram.courseSet.add(this);
				return false;
			}
		}
		this.ID = ID;
		itsprogram.courseSet.add(this);
		return true;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCourseNum() {
		return Integer.parseInt(courseNum);
	}
	
	public String getFullName() {
		return name+ " " + courseNum;
	}
	
	public String getFullID() {
		//System.out.println(this.itsprogram.getID());
		//System.out.println(this.itsprogram.itsdepartment.itsfaculty.getDepartments().size());
		for(int i = 0; i < this.itsprogram.itsdepartment.itsfaculty.getDepartments().size(); i ++) {
			//System.out.println(this.itsprogram.itsdepartment.getName());
			//System.out.println(this.itsprogram.itsdepartment.getID());
			
		}
		//System.out.println(this.itsprogram.itsdepartment.getID());
		//System.out.println(this.itsprogram.itsdepartment.itsfaculty.getID());
		return this.itsprogram.itsdepartment.itsfaculty.getID()+this.itsprogram.itsdepartment.getID()+this.itsprogram.getID()+this.getID();
	}
	
	public String getFullLine(){
		return "\t\t\t- " + name + " " + courseNum + " " + ID;
	    }

	/*
	 * This function assumes a course reference and will delete that course from allCourses, then add its 
	 * deleted index to the list of deleted indexes.
	 */
	public void deleteCourse() {
		int tempIndex = 0;
		for(int i = 0; i < allCourses.size(); i++) {
			if(allCourses.get(i).equals(this)){
				tempIndex = i;
			}
		}
		//deletedIDs.add(tempIndex);
		allCourses.remove(this);  
		itsprogram.deleteCourseFromSet(this);
	}
	
}