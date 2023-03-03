package PojoClass;

public class Employee {
	
	//Step1: Declare the variables Globally
		String name;
		String id;
		long phNo;
		
	//Step2: Create Constructor to initialize values
		public Employee(String name, String id, long phNo) {
			super();
			this.name = name;
			this.id = id;
			this.phNo = phNo;
		}
//		public Employee()
//		{
//			
//		}

	//Step3: To Trigger
		public String getName() {
			return name;
		}

		public String getId() {
			return id;
		}

		public long getPhNo() {
			return phNo;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setPhNo(long phNo) {
			this.phNo = phNo;
		}
		
		
		
		
	}


