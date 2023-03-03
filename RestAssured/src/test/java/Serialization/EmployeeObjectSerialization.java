package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.EmployeeObject;
import PojoClass.Spouse;

public class EmployeeObjectSerialization {
@Test
public void empObject() throws JsonGenerationException, JsonMappingException, IOException
{
long[] phNo= {83298392l,832932748l};
Spouse sp=new Spouse("rani", "tyss89");
EmployeeObject emp=new EmployeeObject("raja", phNo, sp);
ObjectMapper omp=new ObjectMapper();
omp.writeValue(new File("./details.json"), emp);
}
}


