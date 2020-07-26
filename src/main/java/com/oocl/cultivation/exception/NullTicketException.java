package com.oocl.cultivation.exception;

public class NullTicketException extends Exception{
    private String message;
    public NullTicketException(String message){
        this.message=message;
    }
}