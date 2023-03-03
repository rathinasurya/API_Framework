package PojoClass;

public class EmployeeObject {
	String name;
	long[] phNo;
	Spouse Spouse;
	
	public EmployeeObject(String name, long[] phNo, Spouse Spouse) {
		super();
		this.name = name;
		this.phNo = phNo;
		this.Spouse = Spouse;
	}
	
	public EmployeeObject()
	{
		
	}

	public String getName() {
		return name;
	}

	public long[] getPhNo() {
		return phNo;
	}

	public Spouse getSpouse() {
		return Spouse;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhNo(long[] phNo) {
		this.phNo = phNo;
	}

	public void setSpouse(Spouse spouse) {
		Spouse = spouse;
	}
	
	
}
