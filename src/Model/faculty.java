package Model;

import java.util.ArrayList;

public class faculty {

  private static ArrayList<faculty> facultySet = new ArrayList<faculty>();
  private String name;
  private String ID;
  private static int newID;
  private static ArrayList<Integer> deletedIDs;
  private ArrayList<department> departmentSet = new ArrayList<department>();
  
  public faculty() {
	  facultySet.add(this);
	  newID = facultySet.size();
  }
  
  public boolean setName(String name) {
	  facultySet.remove(this);
	  String nameUpper = name.toUpperCase();
	  for (int i = 0 ; i < facultySet.size();i++) {
		  if (facultySet.get(i).getName().toUpperCase().equals(nameUpper)) {
			  facultySet.add(this);
			  return false;
		  }
	  }
	  this.name = name;
	  facultySet.add(this);
	  return true;
  }
  
  
  
  public String getName() {
	  return name;
  }
  
  public String getID() {
	  return this.ID;
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
	  facultySet.remove(this);
	  for(int i = 0; i < facultySet.size();i++) {
		  if(facultySet.get(i).getID().equals(ID)) {
			  facultySet.add(this);
			  return false;
		  }
	  }
	  this.ID = ID;
	  facultySet.add(this);
	  return true;
	  
  }
  
  public static ArrayList<faculty> getFacultySet(){
	  return facultySet;
  }

  
  public void removeFaculty() {
	  facultySet.remove(this);
  }
  
  public ArrayList<department> getDepartments(){
	  return departmentSet;
  }
  
  public String getFullLine(){
		return "> " + name + " " + ID;
	    }
  
  public static faculty getFaculty(String name) {
	  for(int i = 0; i < facultySet.size(); i++) {
		  if(facultySet.get(i).getName().equals(name)) {
			  return facultySet.get(i);
		  }
	  }
	  return null;
  }
  
  public static faculty getFaculty(faculty searchFaculty) {
	  for(int i = 0; i < facultySet.size(); i++) {
		  if(facultySet.get(i) == searchFaculty) {
			  return facultySet.get(i);
		  }
	  }
	  return null;
  }
  
  public department getDepartment(String name) {
	  for(int i = 0; i < departmentSet.size(); i++) {
		  if(departmentSet.get(i).getName().equals(name)) {
			  return departmentSet.get(i);
		  }
	  }
	  return null;
  }
  
  /*
   * This function takes in a faculty reference and will delete that faculty from the facultySet, then add its 
   * deleted index to the list of deleted indexes.
   */
  public static void deleteFaculty(faculty deleteFaculty) {
	  Integer tempIndex = 0;
	  for(int i = 0; i < facultySet.size(); i++) {
		  if(facultySet.get(i).equals(deleteFaculty)){
			  tempIndex = i;
		  }
	  }
	  facultySet.remove(deleteFaculty);
	  deletedIDs.add(tempIndex);
  }
  
  /*
   * This function takes in a faculty's Name and will delete that related faculty from the facultySet, then add its 
   * deleted index to the list of deleted indexes.
   */
  public static void deleteFaculty(String name) {
	  
  }
  
  /*
   * This function takes in a faculty's ID and will delete that related faculty from the facultySet, and add its 
   * deleted index to the list of deleted indexes.
   */
  public static void deleteFaculty(int id) {
	  
  }
  
  public static int getFacultyNewID() {
	  return newID;
  }
  
  public static ArrayList<Integer> getFacultyDeletedID() {
	  return deletedIDs;
  }
 
}