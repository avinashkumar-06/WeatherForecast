package org.avinashcodes.weatherforecast.dto.rapidapidtos;

import lombok.Data;

@Data
public class ItemsItem{
	private String date;
	private String dateWithTimezone;
	private int freshSnow;
	private Astronomy astronomy;
	private Temperature temperature;
	private Windchill windchill;
	private Wind wind;
}