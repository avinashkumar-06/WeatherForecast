package org.avinashcodes.weatherforecast.dto.rapidapidtos;

import lombok.Data;

@Data
public class Windchill{
	private int min;
	private Object avg;
	private int max;
}