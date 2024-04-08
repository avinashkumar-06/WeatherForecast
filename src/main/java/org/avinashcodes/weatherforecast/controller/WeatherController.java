package org.avinashcodes.weatherforecast.controller;

import lombok.AllArgsConstructor;
import org.avinashcodes.weatherforecast.dto.DayForecastDto;
import org.avinashcodes.weatherforecast.dto.DayHourForecastDto;
import org.avinashcodes.weatherforecast.dto.openweatherdtos.ForecastSummaryHourResponse;
import org.avinashcodes.weatherforecast.dto.rapidapidtos.ForecastSummaryDayResponse;
import org.avinashcodes.weatherforecast.service.ForecastService;
import org.avinashcodes.weatherforecast.utility.ToDayForecastDtoConverter;
import org.avinashcodes.weatherforecast.utility.ToDayHourForecastDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather/api")
@AllArgsConstructor
public class WeatherController {

    private final ForecastService forecastService;
    private final ToDayForecastDtoConverter toDayForecastDtoConverter;
    private final ToDayHourForecastDtoConverter toDayHourForecastDtoConverter;

    @GetMapping("/daysforecast/{city}")
    public ResponseEntity<List<DayForecastDto>> getWeatherForecastByDays(@PathVariable String city){

        ForecastSummaryDayResponse forecastByDays = forecastService.getForecastByDays(city);
        List<DayForecastDto> listOfForecastByDays = toDayForecastDtoConverter.convert(forecastByDays);
        return new ResponseEntity<>(listOfForecastByDays, HttpStatus.OK);
    }

    @GetMapping("/hoursforecast/{city}")
    public ResponseEntity<List<DayHourForecastDto>> getWeatherForecastByHours(@PathVariable String city){

        ForecastSummaryHourResponse forecastByHours = forecastService.getForecastByHours(city);
        List<DayHourForecastDto> listOfForecastByDays = toDayHourForecastDtoConverter.convert(forecastByHours);
        return new ResponseEntity<>(listOfForecastByDays, HttpStatus.OK);
    }


}
