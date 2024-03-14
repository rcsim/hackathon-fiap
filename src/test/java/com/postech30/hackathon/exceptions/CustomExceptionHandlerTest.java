package com.postech30.hackathon.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

class CustomExceptionHandlerTest {

    private CustomExceptionHandler customExceptionHandlerUnderTest;

    @BeforeEach
    void setUp() {
        customExceptionHandlerUnderTest = new CustomExceptionHandler();
    }

    @Test
    void testResourceNotFound() {
        final ResourceNotFoundException e = new ResourceNotFoundException("message");
        final MockHttpServletRequest request = new MockHttpServletRequest();

        final ResponseEntity<Object> result = customExceptionHandlerUnderTest.resourceNotFound(e, request);

    }

    @Test
    void testBookingNotFound() {
        final BookingNotFoundException e = new BookingNotFoundException("mensagem");
        final MockHttpServletRequest request = new MockHttpServletRequest();

        final ResponseEntity<Object> result = customExceptionHandlerUnderTest.BookingNotFound(e, request);

    }

    @Test
    void testBadRequest() {
        final BadRequestException e = new BadRequestException("message");
        final MockHttpServletRequest request = new MockHttpServletRequest();

        final ResponseEntity<Object> result = customExceptionHandlerUnderTest.badRequest(e, request);

    }
}
