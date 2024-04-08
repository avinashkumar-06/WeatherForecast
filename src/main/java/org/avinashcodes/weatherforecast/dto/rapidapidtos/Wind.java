package org.avinashcodes.weatherforecast.dto.rapidapidtos;

import lombok.Data;

@Data
public class Wind{
	private String unit;
	private Object avg;
	private int min;
	private int max;
	private String text;
	private String direction;
	private boolean significationWind;
}