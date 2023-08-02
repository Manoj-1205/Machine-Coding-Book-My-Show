package com.bms.bookmyshow.Exceptions;

public class ShowSeatNotFoundException extends Throwable {
    public ShowSeatNotFoundException(String seat_not_found) {
        super(seat_not_found);
    }
}
