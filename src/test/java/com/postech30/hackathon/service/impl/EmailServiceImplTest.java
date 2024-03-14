package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.entity.Client;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmailServiceImplTest {

    @Mock
    private JavaMailSenderImpl mockSender;
    @Mock
    private MimeMessage mockMimeMessage;

    @InjectMocks
    private EmailServiceImpl emailServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        emailServiceImplUnderTest.mimeMessage = mockMimeMessage;
    }

    @Test
    void testSendMail() throws Exception {
        final Booking booking = new Booking();
        booking.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        client.setCountry("country");
        client.setEmail("email");
        booking.setClient(client);

        emailServiceImplUnderTest.sendMail(booking);

        verify(mockSender).send(any(MimeMessage.class));
    }

}
