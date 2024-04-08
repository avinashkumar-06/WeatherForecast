package org.avinashcodes.weatherforecast.dto.rapidapidtos;

import java.util.List;
import lombok.Data;

@Data
public class Forecast{

	private List<ItemsItem> items;

}