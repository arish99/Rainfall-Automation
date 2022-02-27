package code;


public class AnnualRainfall {
	
	
	private int cityPincode;
	private String cityName;
	private double averageAnnualRainfall;

	public int getCityPincode() {
		return cityPincode;
	}

	public void setCityPincode(int cityPincode) {
		this.cityPincode = cityPincode;
	}

	public String getCityName(){
		return cityName;
	}

	public void setCityName(String cityName){
		this.cityName = cityName;
	}


	public double getAverageAnnualRainfall(){
		return averageAnnualRainfall;
	}


	public void setAverageAnnualRainfall(double averageAnnualRainfall){
		this.averageAnnualRainfall = averageAnnualRainfall;
	}

	//Write the required business logic as expected in the question description
	public void calculateAverageAnnualRainfall (double monthlyRainfall [ ]){
	    double avg = 0;
	    for(double d : monthlyRainfall)
	    {
	    	avg+=d;
	    }
	    averageAnnualRainfall = avg/12.0;
		//fill the code
		
	}


}
