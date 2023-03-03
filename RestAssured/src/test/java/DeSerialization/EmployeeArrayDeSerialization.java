package DeSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.EmployeeArray;

public class EmployeeArrayDeSerialization {
@Test
public void empArrayDeSerialize() throws JsonParseException, JsonMappingException, IOException
{
	ObjectMapper omp=new ObjectMapper();
	EmployeeArray data = omp.readValue(new File("./empArray.json"), EmployeeArray.class);
	System.out.println(data.getName());
	System.out.println(data.getId());
	System.out.println(data.getPhNo()[1]);
	System.out.println(data.getPhNo()[0]);
	
}
}
