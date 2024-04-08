package org.avinashcodes.weatherforecast.dto;


import lombok.Data;

@Data
public class DayHourForecastDto {

    private String date;
    private String minTemp;

    private String maxTemp;

    private String humidity;

    private String weatherDescription;





}
