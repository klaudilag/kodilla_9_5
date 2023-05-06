package org.example;

public class NoAirportException extends Exception{
    public NoAirportException(){
        super();
    }
    public NoAirportException(String message){
        super(message);
    }
}
