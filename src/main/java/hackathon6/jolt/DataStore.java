package hackathon6.jolt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import hackathon6.jolt.bean.CityUsage;
import hackathon6.jolt.bean.WeatherForecast;

public class DataStore {
	
	public static List<CityUsage> usage = new ArrayList<>();;
	public static List<WeatherForecast> forecast = new ArrayList<>();;
	
	static {
		Random randomTemp = new Random();
		Random randomUsage = new Random();
        final int maxTemp = 48, minTemp = 3, maxUse = 20, minUse = 0;
		
		for (int d=0; d<31; d++) {
			for (int h=0; h<24; h++) {
				Calendar c = Calendar.getInstance();
				c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), d, 0, 0);  

				CityUsage cu = new CityUsage(d*24 + h, 1,
						c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, d+1, h, 
						randomTemp.nextInt((maxTemp - minTemp) + 1) + minTemp, 
						randomUsage.nextInt((maxUse - minUse) + 1) + minUse, false);
				
				usage.add(cu);
				//System.out.println(cu);
			}
		}
		
		for (int d=0; d<31; d++) {
			for (int h=0; h<24; h++) {
				Calendar c = Calendar.getInstance();
				c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), d, 0, 0);  

				WeatherForecast fc = new WeatherForecast(d*24 + h, 1,
						c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, d+1, h, 
						randomTemp.nextInt((maxTemp - minTemp) + 1) + minTemp);
				
				forecast.add(fc);
				//System.out.println(fc);
			}
		}
	}
}
