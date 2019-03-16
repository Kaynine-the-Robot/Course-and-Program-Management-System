import java.util.ArrayList;

public class Department {
	private String name;
	private String ID;
	public Faculty itsfaculty;
	public ArrayList<Program> programSet = new ArrayList<Program>();
	
	
	public boolean setFaculty(Faculty newfaculty) {
		Faculty oldfaculty = itsfaculty;
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
		itsfaculty.departmentSet.remove(this);
		for (int i = 0; i < itsfaculty.departmentSet.size();i++) {
			if(itsfaculty.departmentSet.get(i).getName().toUpperCase().equals(nameUpper)){
				itsfaculty.departmentSet.add(this);
				return false;
			}
		}
		this.name = name;
		itsfaculty.departmentSet.add(this);
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
		itsfaculty.departmentSet.remove(this);
		for(int i = 0; i < itsfaculty.departmentSet.size();i++) {
			if(itsfaculty.departmentSet.get(i).getID().equals(ID)) {
				itsfaculty.departmentSet.add(this);
				return false;
			}
		}
		this.ID = ID;
		itsfaculty.departmentSet.add(this);
		return true;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
}
