import java.util.ArrayList;

public class TempDatabase {
	
	private static ArrayList<faculty> facultyList = new ArrayList<faculty>();
	private static ArrayList<department> departmentList = new ArrayList<department>();
	private static ArrayList<program> programList = new ArrayList<program>();
	private static ArrayList<course> courseList = new ArrayList<course>();
	
	public TempDatabase() {
		this.facultyList.add("Science");
		this.departmentList.add("Computer Science");
		this.programList.add("Undergraduate");
		this.courseList.add("CPSC 101");
	}
	
	public ArrayList<faculty> getFacultyList() {
		return this.facultyList;
	}
	
	public static void addToFacultyList(faculty newFaculty) {
		this.facultyList.add(newFaculty);
	}
	
	public ArrayList<String> getDepartmentList() {
		return this.departmentList;
	}
	
	public void addToDepartmentList(String newDepartment) {
		this.departmentList.add(newDepartment);
	}
	
	public ArrayList<String> getProgramList() {
		return this.programList;
	}
	
	public void addToProgramList(String newProgram) {
		this.programList.add(newProgram);
	}
	
	public ArrayList<String> getCourseList() {
		return this.courseList;
	}
	
	public void addToCourseList(String newCourse) {
		this.courseList.add(newCourse);
	}

}
