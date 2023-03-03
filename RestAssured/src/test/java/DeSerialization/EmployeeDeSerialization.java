package DeSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.Employee;

public class EmployeeDeSerialization {
	@Test
	public void empDeserialization() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper omp=new ObjectMapper();
		Employee data = omp.readValue(new File("./emp.json"), Employee.class);
		System.out.println(data.getName());
		System.out.println(data.getId());
		System.out.println(data.getPhNo());
		
	}

}
