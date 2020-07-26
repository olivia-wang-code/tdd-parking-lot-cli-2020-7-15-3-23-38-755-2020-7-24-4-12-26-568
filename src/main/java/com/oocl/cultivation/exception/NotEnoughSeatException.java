package com.oocl.cultivation.exception;

public class NotEnoughSeatException extends Exception{
    private String message;
    public NotEnoughSeatException(String message){
        this.message=message;
    }
}