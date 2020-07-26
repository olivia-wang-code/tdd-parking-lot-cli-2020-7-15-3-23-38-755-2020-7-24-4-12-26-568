package com.oocl.cultivation.exception;

public class WrongTicketException extends Exception{
    private String message;
    public WrongTicketException(String message){
        this.message=message;
    }
}
