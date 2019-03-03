package Model;

import java.util.ArrayList;

public class faculty {

  private static ArrayList<faculty> facultySet = new ArrayList<faculty>();
  private String name;
  private String ID;
  public ArrayList<department> departmentSet = new ArrayList<department>();
  
  public faculty() {
	  facultySet.add(this);
	  
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
  
  public void removeFaculty() {
	  facultySet.remove(this);
  }
}