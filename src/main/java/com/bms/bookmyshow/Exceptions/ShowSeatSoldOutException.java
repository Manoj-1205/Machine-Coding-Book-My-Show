package com.bms.bookmyshow.Exceptions;

public class ShowSeatSoldOutException extends RuntimeException{
    public ShowSeatSoldOutException(String message){
        super(message);
    }
}
