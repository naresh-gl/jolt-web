package hackathon6.jolt.service;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hackathon6.jolt.DataStore;
import hackathon6.jolt.bean.CityUsage;

@Service
public class PredictionService {
	public List<CityUsage> getPredictionForCity() {

		Calendar c = Calendar.getInstance();
		int currDate = c.get(Calendar.DAY_OF_MONTH);
		int currHour = c.get(Calendar.HOUR_OF_DAY);
		System.out.println("currDate: " + currDate + ", currHour: " + currHour);
		
		List<CityUsage> useageList = DataStore.usage.stream()
				.filter(x -> (x.hour <= currHour && x.hour + 5 > currHour && x.day == currDate))
				.collect(Collectors.toList());
		
		
		List<CityUsage> filteredList_1 = DataStore.usage.stream()
				.filter(x -> (x.hour >= currHour && x.hour - 3 < currHour))
				.collect(Collectors.toList());
		System.out.println(filteredList_1);
		int forecastUsage_1 = filteredList_1.stream().mapToInt(CityUsage::getUsage).sum() / filteredList_1.size();
		System.out.println("Forecaste Use: " + forecastUsage_1);
		
		CityUsage usage_1 = new CityUsage(0, 1, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), currHour+1, -1, forecastUsage_1, true);
		useageList.add(usage_1);
		
		return useageList;
	}
}
