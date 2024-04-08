package org.avinashcodes.weatherforecast.utility;

import org.avinashcodes.weatherforecast.dto.DayHourForecastDto;
import org.avinashcodes.weatherforecast.dto.openweatherdtos.ForecastSummaryHourResponse;
import org.avinashcodes.weatherforecast.dto.openweatherdtos.ListItem;
import org.avinashcodes.weatherforecast.dto.openweatherdtos.Main;
import org.avinashcodes.weatherforecast.dto.openweatherdtos.WeatherItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDayHourForecastDtoConverter {


    public List<DayHourForecastDto> convert(ForecastSummaryHourResponse response){

        ArrayList<ListItem> listItems = new ArrayList<>(response.getList());
        List<DayHourForecastDto> dayHourForecastDtos = new ArrayList<>();

        for (ListItem item : listItems){
            DayHourForecastDto dayHourForecastDto = new DayHourForecastDto();
            dayHourForecastDto.setDate(item.getDt_txt());
            dayHourForecastDto.setMinTemp(String.valueOf(item.getMain().getTemp_min()));
            dayHourForecastDto.setMaxTemp(String.valueOf(item.getMain().getTemp_max()));
            dayHourForecastDto.setHumidity(String.valueOf(item.getMain().getHumidity()));
            List<WeatherItem> weatherItems = item.getWeather();
            for (WeatherItem weatherItem : weatherItems){
                dayHourForecastDto.setWeatherDescription(weatherItem.getDescription());
            }
            dayHourForecastDtos.add(dayHourForecastDto);
        }

        return dayHourForecastDtos;
    }


}
