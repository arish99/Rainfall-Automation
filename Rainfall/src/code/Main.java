package code;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		RainfallReport rainfallReport = new RainfallReport();
		List<AnnualRainfall> annualRainfalls = rainfallReport.generateRainfallReport("AllCityMonthlyRainfall.txt");
		System.out.println("Cities in .txt file:");
		for (AnnualRainfall annualRainfall : annualRainfalls) {
			System.out.println("CityName:" + annualRainfall.getCityName() + " PinCode:"
					+ annualRainfall.getCityPincode() + " Avg Rainfall:" + annualRainfall.getAverageAnnualRainfall());
		}
		List<AnnualRainfall> maxAnnualRainfalls = rainfallReport.findMaximumRainfallCities();
		for(AnnualRainfall annualRainfall : maxAnnualRainfalls)
		{
			System.out.println(annualRainfall.getCityName());
		}


		// fill the code

	}
}
