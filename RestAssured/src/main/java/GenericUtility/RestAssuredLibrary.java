package GenericUtility;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredLibrary {

public String getJsonData(Response response,String path)
{
	String jsonData=response.jsonPath().get(path);
	return jsonData;
	
}
}
