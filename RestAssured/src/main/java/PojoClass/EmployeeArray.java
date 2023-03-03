package PojoClass;

public class EmployeeArray {
	String name;
	String id;
	long[] phNo;
	
	public EmployeeArray(String name, String id, long phNo[]) {
		super();
		this.name = name;
		this.id = id;
		this.phNo = phNo;
	}
	
	public EmployeeArray()
	{
		
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public long[] getPhNo() {
		return phNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPhNo(long[] phNo) {
		this.phNo = phNo;
	}
	
	
	
	
}
