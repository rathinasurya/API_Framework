package PojoClass;

public class Spouse {
	String name;
	String id;
	
	public Spouse(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public Spouse()
	{
		
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
