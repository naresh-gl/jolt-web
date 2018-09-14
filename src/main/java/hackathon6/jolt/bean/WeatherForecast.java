package hackathon6.jolt.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherForecast {
	public int forecastId, cityId, year, month, day, hour, temperature;
}
