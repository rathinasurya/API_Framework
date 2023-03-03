package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.EmployeeArray;

public class EmployeeArraySerialization
{
@Test
public void empArraySerialize() throws JsonGenerationException, JsonMappingException, IOException
{
	long phNo[]= {9876736823l, 928387839l};
	EmployeeArray emp1=new EmployeeArray("gopi","Tyss452",phNo);
	ObjectMapper omp=new ObjectMapper();
	omp.writeValue(new File("./empArray.json"), emp1);
}
}
