package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseLibrary {
Driver driverRef;
Connection con;
public void connectToDB() throws SQLException
{
	driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	con=DriverManager.getConnection(IpathConstant.dbURL,IpathConstant.dbUserName,IpathConstant.dbPassword);
}

public void closeDB() throws SQLException
{
	con.close();
}
public String readDataFromDBAndValidate(String query, int coloumnIndex, String expData) throws SQLException
{
	boolean flag=false;
	ResultSet result = con.createStatement().executeQuery(query);
	while(result.next())
	{
		if(result.getString(coloumnIndex).equalsIgnoreCase(expData))
		{
			flag=true;
			break;
		}
	}
	if(flag)
	{
		System.out.println("Project Stored In DB");
		return expData;
	}
	else
	{
		System.out.println("Project not Stored In DB");
		return "";
	}
}
public int deleteDataFromDB(String query1) throws SQLException
{
		Statement state = con.createStatement();
		int result = state.executeUpdate(query1);
		if(result==1)
		{
			System.out.println("Project Deleted Sucessfully");
		}
		else
		{
			System.out.println("Project not deleted");
		}
		return result;
	
}
public void createProjectInDB(String ProjectID, String CreatedBy, String CreatedOn,String Projectname,String Status,int teamSize) throws SQLException
{
	Statement state = con.createStatement();
	String query = "Insert into project values('"+ProjectID+"','"+CreatedBy+"','"+CreatedOn+"','"+Projectname+"','"+Status+"','"+teamSize+"')";
	int data = state.executeUpdate(query);
	if(data==1)
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("failed");
	}
	
	
}
}
