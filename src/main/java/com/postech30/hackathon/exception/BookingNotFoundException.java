package com.postech30.hackathon.exception;

public class BookingNotFoundException extends Exception{
    public BookingNotFoundException(String mensagem){
        super(mensagem);
    }
}
