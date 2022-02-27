package code;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHandler {

	//Write the required business logic as expected in the question description
	public Connection establishConnection() {
		try
		{
			Connection con=null;
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream("db.properties");
		    properties.load(fis);
		    Class.forName(properties.getProperty("db.classname"));
		    con = DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.username"),properties.getProperty("db.password"));
		    return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		//fill the code
		return null;

	}
}
