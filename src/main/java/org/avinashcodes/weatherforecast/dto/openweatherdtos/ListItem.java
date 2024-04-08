package org.avinashcodes.weatherforecast.dto.openweatherdtos;

import java.util.List;
import lombok.Data;

@Data
public class ListItem{
	private int dt;
	private int pop;
	private String dt_txt;
	private List<WeatherItem> weather;
	private Main main;

	@Override
	public String toString() {
		return "ListItem{" +
				"dt=" + dt +
				", dtTxt='" + dt_txt + '\'' +
				", weather=" + weather +
				", main=" + main +
				'}';
	}
}