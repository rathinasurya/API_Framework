package DeSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.EmployeeObject;

public class EmployeeObjectDeSerialization {
@Test
public void empObjSeserialize() throws JsonParseException, JsonMappingException, IOException
{
	ObjectMapper omp=new ObjectMapper();
	EmployeeObject data = omp.readValue(new File("./details.json"), EmployeeObject.class);
	System.out.println(data.getName());
	System.out.println(data.getPhNo()[1]);
	System.out.println(data.getSpouse().getName());
	System.out.println(data.getSpouse().getId());
			
}
}
