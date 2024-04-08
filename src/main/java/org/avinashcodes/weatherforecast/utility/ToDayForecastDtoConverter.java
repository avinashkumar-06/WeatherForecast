package org.avinashcodes.weatherforecast.utility;

import org.avinashcodes.weatherforecast.dto.DayForecastDto;
import org.avinashcodes.weatherforecast.dto.rapidapidtos.ForecastSummaryDayResponse;
import org.avinashcodes.weatherforecast.dto.rapidapidtos.ItemsItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ToDayForecastDtoConverter {

    String date;
    String minTemp;
    String maxTemp;
    String windSpeed;
    String sunRiseTime;
    String sunSetTime;

    public DayForecastDto convertToDayForecastDto(ItemsItem item){

        date = getDateFormatted(item.getDate());
        minTemp = String.valueOf(item.getTemperature().getMin());
        maxTemp = String.valueOf(item.getTemperature().getMax());
        windSpeed = String.valueOf(item.getWind().getMax());
        sunRiseTime = formatTime(item.getAstronomy().getSunrise());
        sunSetTime = formatTime(item.getAstronomy().getSunset());
        
        DayForecastDto dayForecastDto = 
                new DayForecastDto(date,minTemp,maxTemp,windSpeed,sunRiseTime,sunSetTime);

        return dayForecastDto;
    }
    
    public List<DayForecastDto>  convert(ForecastSummaryDayResponse response){
        List<ItemsItem> items = response.getForecast().getItems();
        return items.stream().map(this::convertToDayForecastDto).toList();
    }

    // method to convert time to hh:mm am/pm time
    public static String formatTime(String inputTime) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(inputTime, inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("hh : mm a");
        return dateTime.format(outputFormatter);
    }


    // Method to extract and format date
    public static String getDateFormatted(String dateString) {
        String[] parts = dateString.split("-");

        String month = parts[1];  // Month
        String day = parts[2];    // Day
        String year = parts[0];   // Year

        String result = getMonthName(Integer.parseInt(month)) + " " + day + ", " + year;

        return result;
    }

    // Method to get month name from its number
    public static String getMonthName(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "";
        }
    }

}
