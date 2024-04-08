package org.avinashcodes.weatherforecast.dto.openweatherdtos;

import java.util.List;
import lombok.Data;

@Data
public class ForecastSummaryHourResponse{
	private int cnt;
	private String cod;
	private int message;
	private List<ListItem> list;


}