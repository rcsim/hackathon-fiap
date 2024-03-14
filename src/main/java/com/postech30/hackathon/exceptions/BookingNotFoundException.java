package com.postech30.hackathon.exceptions;

public class BookingNotFoundException extends Exception {
    public BookingNotFoundException(String mensagem) {
        super(mensagem);
    }
}
