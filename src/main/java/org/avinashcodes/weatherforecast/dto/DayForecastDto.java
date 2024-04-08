package org.avinashcodes.weatherforecast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DayForecastDto {

    private String date;

    private String minTemp;

    private String maxTemp;

    private String windSpeed;

    private String sunRiseTime;

    private String sunSetTime;
}
