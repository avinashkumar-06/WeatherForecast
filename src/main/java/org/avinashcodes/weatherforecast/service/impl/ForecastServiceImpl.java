package org.avinashcodes.weatherforecast.service.impl;

import org.avinashcodes.weatherforecast.exception.RestTemplateExceptions;
import org.avinashcodes.weatherforecast.dto.openweatherdtos.ForecastSummaryHourResponse;
import org.avinashcodes.weatherforecast.dto.rapidapidtos.ForecastSummaryDayResponse;
import org.avinashcodes.weatherforecast.service.ForecastService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;



@Service
public class ForecastServiceImpl implements ForecastService {

    private final String rapidApiKey = "2750bae9f8msh9d4a32a641001ffp1eba5fjsnf2525a756229";
    private final String rapidApiHost = "forecast9.p.rapidapi.com";

    @Override
    public ForecastSummaryDayResponse getForecastByDays(String city) {

        String finalApi = String.format("https://forecast9.p.rapidapi.com/rapidapi/forecast/%s/summary/",city);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", rapidApiHost);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<ForecastSummaryDayResponse> responseEntity = restTemplate.exchange(finalApi, HttpMethod.GET, entity, ForecastSummaryDayResponse.class);
            return responseEntity.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new RestTemplateExceptions("Error response from server: " + e.getStatusCode() + " - " + e.getStatusText());
        } catch (ResourceAccessException e) {
            throw new RestTemplateExceptions("Error executing request: " + e.getMessage());
        } catch (Exception e){
            throw new RestTemplateExceptions("Error happened in getting weather data from RapidApi "+e.getMessage());
        }
    }

    @Override
    public ForecastSummaryHourResponse getForecastByHours(String city) {

        final String finalApi =
                String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=a9a7e5afe817c8b43721d5f411a206ff&units=metric",city);
       RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<ForecastSummaryHourResponse> responseEntity =
                    restTemplate.exchange(finalApi, HttpMethod.GET, null, ForecastSummaryHourResponse.class);
            return responseEntity.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new RestTemplateExceptions("Error response from server: " + e.getStatusCode() + " - " + e.getStatusText());
        } catch (ResourceAccessException e) {
            throw new RestTemplateExceptions("Error executing request: " + e.getMessage());
        } catch (Exception e){
            throw new RestTemplateExceptions("Error happened in getting weather data from RapidApi "+e.getMessage());
        }

    }

//    public static void main(String[] args) {
//
//        ForecastServiceImpl fs = new ForecastServiceImpl();
//        ForecastSummaryHourResponse delhi = fs.getForecastByHours("delhi");
//        System.out.println(delhi);
//
//    }

}
