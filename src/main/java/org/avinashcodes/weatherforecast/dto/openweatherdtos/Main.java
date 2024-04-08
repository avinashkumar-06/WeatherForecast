package org.avinashcodes.weatherforecast.dto.openweatherdtos;

import lombok.Data;

@Data
public class Main{
	private Object temp;
	private Object temp_min;
	private int grndLevel;
	private Object tempKf;
	private int humidity;
	private int pressure;
	private int seaLevel;
	private Object feelsLike;
	private Object temp_max;
}