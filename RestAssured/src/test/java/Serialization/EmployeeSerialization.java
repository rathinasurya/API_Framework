package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.Employee;

public class EmployeeSerialization {
	@Test
	public void empSerialization() throws JsonGenerationException, JsonMappingException, IOException
	{
		Employee emp=new Employee("surya", "Ty303", 9444855939l);
		ObjectMapper omp=new ObjectMapper();
		omp.writeValue(new File("./emp.json"), emp);
	}
	

}
