package hackathon6.jolt.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hackathon6.jolt.bean.CityUsage;
import hackathon6.jolt.service.PredictionService;

@RestController
@RequestMapping("/api")
public class DashBoardController {
	
	@Autowired
	PredictionService predictionService;
	
	@RequestMapping(value = "/refresh/{cityId}", method = RequestMethod.GET)
	public List<CityUsage> getWCValues(@PathVariable("cityId") String cityId) {
		List<CityUsage> prediction = predictionService.getPredictionForCity();
		return prediction;
	}
}
