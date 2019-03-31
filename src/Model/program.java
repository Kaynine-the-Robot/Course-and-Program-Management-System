package Model;

import java.util.ArrayList;

public class program {
	private String name;
	private String ID;
	public department itsdepartment;
	public ArrayList<course> courseSet = new ArrayList<course>();
	
	
	public boolean setDepartment(department newdepartment) {
		department olddepartment = itsdepartment;
		itsdepartment = newdepartment;
		if(setName(this.name)&&setID(this.ID)) {
			return true;
		}
		itsdepartment = olddepartment;
		return false;
	}
	
	public boolean setName(String name) {
		if(itsdepartment == null) {
			this.name = name;
			return true;
		}
		String nameUpper = name.toUpperCase();
		itsdepartment.programSet.remove(this);
		for (int i = 0; i < itsdepartment.programSet.size();i++) {
			if(itsdepartment.programSet.get(i).getName().toUpperCase().equals(nameUpper)){
				itsdepartment.programSet.add(this);
				return false;
			}
		}
		this.name = name;
		itsdepartment.programSet.add(this);
		return true;	
	}
	
	public boolean setID(String ID) {
		if (ID.length()!=2) {
			return false;
		}
		int intID;
		try {
			intID = Integer.parseInt(ID);
		}catch(Exception e) {
			return false;
		}
		if (itsdepartment == null) {
			this.ID = ID;
			return true;
		}
		itsdepartment.programSet.remove(this);
		for(int i = 0; i < itsdepartment.programSet.size();i++) {
			if(itsdepartment.programSet.get(i).getID()==intID) {
				itsdepartment.programSet.add(this);
				return false;
			}
		}
		this.ID = ID;
		itsdepartment.programSet.add(this);
		return true;
	}
	
	public int getID() {
		return Integer.parseInt(this.ID);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getFullLine(){
		return "\t\t+ " + name + " " + ID;
	    }

}