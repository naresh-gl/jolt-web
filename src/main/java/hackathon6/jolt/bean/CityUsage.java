package hackathon6.jolt.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityUsage {
	public int usageId, cityId, year, month, day, hour, temperature, usage;
	boolean forecast;
}
