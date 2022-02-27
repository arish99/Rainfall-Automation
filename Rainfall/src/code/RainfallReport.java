package code;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class RainfallReport {

	//Write the required business logic as expected in the question description
	public List<AnnualRainfall> generateRainfallReport(String filePath) {
	    List<AnnualRainfall> list = new ArrayList<>();
	    try
	    {
	    	BufferedReader br = new BufferedReader(new FileReader(filePath));
	    	Scanner sc = new Scanner(br);
	    	while(sc.hasNext())
	    	{
	    		String[] cityNames = sc.nextLine().split(",");
	    		String cityPinCode = cityNames[0];
	    		try
	    		{
	    			boolean crtpin = validate(cityPinCode);
	    			if(crtpin)
	    			{
	    				AnnualRainfall a = new AnnualRainfall();
	    				int pin = Integer.parseInt(cityPinCode);
	    				a.setCityPincode(pin);
	    				String name = cityNames[1];
	    				a.setCityName(name);
	    				double[] rainfalls = new double[12];
	    				for(int i=0;i<12;i++)
	    				{
	    					rainfalls[i]=Double.parseDouble(cityNames[i+2]);
	    				}
	    				a.calculateAverageAnnualRainfall(rainfalls);
	    				list.add(a);
	    			}
	    			
	    		}
	    		catch (InvalidCityPincodeException e) {
					System.out.println(e.getMessage());
				}
	    		
	    		
	    	}
	    	sc.close();
	    }
	    catch (IOException e) {
			e.printStackTrace();
		}
		//fill the code
		return list;
	}
	
	public List<AnnualRainfall>  findMaximumRainfallCities() {
		 List<AnnualRainfall> list = new ArrayList<>();
		 try {
			 DBHandler db = new DBHandler();
			 Connection con = db.establishConnection();
			 Statement st = con.createStatement();
			 String query = "select * from AnnualRainfall where average_annual_rainfall=(select max(average_annual_rainfall) from AnnualRainfall);";
			 ResultSet rs = st.executeQuery(query);
			 AnnualRainfall annualRainfall = new AnnualRainfall();
			 while(rs.next())
			 {
				 int pincode = rs.getInt(1);
				 String name = rs.getString(2);
				 double rain = rs.getDouble(3);
				 annualRainfall.setAverageAnnualRainfall(rain);
				 annualRainfall.setCityName(name);
				 annualRainfall.setCityPincode(pincode);
				 list.add(annualRainfall);
			 }
		 }
		 catch (Exception e) {
			e.printStackTrace();
		}
		//fill the code
		return list;
	}
	
	
	public boolean validate(String cityPincode) throws InvalidCityPincodeException {
	    Pattern pattern  = Pattern.compile("^[\\d]{5}");
	    		Matcher matcher = pattern.matcher(cityPincode);
	    if(matcher.matches())
	    {
	    	return true;
	    }
	    else
	    {
	    	throw new InvalidCityPincodeException("Invalid City Pincode");
	    	
	    }
	    
		//fill the code
    		
	}

}
