package org.avinashcodes.weatherforecast.service;

import org.avinashcodes.weatherforecast.dto.openweatherdtos.ForecastSummaryHourResponse;
import org.avinashcodes.weatherforecast.dto.rapidapidtos.ForecastSummaryDayResponse;

public interface ForecastService {

    ForecastSummaryDayResponse getForecastByDays(String city);

    ForecastSummaryHourResponse getForecastByHours(String city);

}
