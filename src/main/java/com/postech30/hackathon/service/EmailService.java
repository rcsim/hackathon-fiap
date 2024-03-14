package com.postech30.hackathon.service;

import com.postech30.hackathon.entity.Booking;
import jakarta.mail.MessagingException;

public interface EmailService {

    public void sendMail(Booking booking) throws MessagingException;
}
