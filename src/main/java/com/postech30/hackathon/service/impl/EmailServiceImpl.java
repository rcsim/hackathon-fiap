package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl  implements EmailService {

    @Autowired
    private JavaMailSenderImpl sender = new JavaMailSenderImpl();


    MimeMessage mimeMessage = sender.createMimeMessage();
    @Override
    public void sendMail(Booking booking) throws MessagingException {

        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

        message.setFrom(booking.getClient().getEmail());
        message.setTo(booking.getClient().getEmail());
        message.setSubject("Reserva Realizada com sucesso");

        message.setText(htmlMessage(),true);


        sender.send(mimeMessage);

    }

    private String htmlMessage(){
        return "<!DOCTYPE html> <html lang='pt-BR'> <head> <meta charset='UTF-8'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Confirmação de Reserva</title> <style> body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; } .container { width: 80%; margin: 0 auto; background-color: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); } .header, .footer, .content { text-align: center; padding: 20px; } .header, .footer { background-color: #800080; /* Cor roxo */ color: #fff; } .footer { margin-top: 20px; } </style> </head> <body> <div class='container'> <div class='header'> <h1>Confirmação de Reserva</h1> </div> <div class='content'> <p>Olá,</p> <p>Sua reserva foi feita com sucesso! </p> <p>Se precisar de mais informações ou assistência, por favor, entre em contato conosco.</p> <p>Obrigado por escolher nossos serviços.</p> </div> <div class='footer'> <p>&copy; 2024 Hackaton FIAP. Todos os direitos reservados.</p> </div> </div> </body> </html>";
    }

}
