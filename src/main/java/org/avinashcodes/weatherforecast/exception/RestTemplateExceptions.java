package org.avinashcodes.weatherforecast.exception;

public class RestTemplateExceptions extends RuntimeException{

    private String message;

    public RestTemplateExceptions() {

    }

    public RestTemplateExceptions(String message) {
       super(message);
        this.message = message;
    }

}
