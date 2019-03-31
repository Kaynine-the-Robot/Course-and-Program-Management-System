package Model;

import java.util.ArrayList;

public class department {
	private String name;
	private String ID;
	public faculty itsfaculty;
	public ArrayList<program> programSet = new ArrayList<program>();
	
	
	public boolean setFaculty(faculty newfaculty) {
		faculty oldfaculty = itsfaculty;
		itsfaculty = newfaculty;
		if(setName(this.name)&&setID(this.ID)) {
			return true;
		}
		itsfaculty = oldfaculty;
		return false;
	}
	
	public boolean setName(String name) {
		if(itsfaculty == null) {
			this.name = name;
			return true;
		}
		String nameUpper = name.toUpperCase();
		itsfaculty.getDepartments().remove(this);
		for (int i = 0; i < itsfaculty.getDepartments().size();i++) {
			if(itsfaculty.getDepartments().get(i).getName().toUpperCase().equals(nameUpper)){
				itsfaculty.getDepartments().add(this);
				return false;
			}
		}
		this.name = name;
		itsfaculty.getDepartments().add(this);
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
		if (itsfaculty == null) {
			this.ID = ID;
			return true;
		}
		itsfaculty.getDepartments().remove(this);
		for(int i = 0; i < itsfaculty.getDepartments().size();i++) {
			if(itsfaculty.getDepartments().get(i).getID().equals(ID)) {
				itsfaculty.getDepartments().add(this);
				return false;
			}
		}
		this.ID = ID;
		itsfaculty.getDepartments().add(this);
		return true;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getFullLine(){
		return "\t= " + name + " " + ID;
	    }

}