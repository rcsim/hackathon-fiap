package com.postech30.hackathon.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ServicesBookedTest {

    @Test
    void testBookIdGetterAndSetter() {
        final ServicesBooked servicesBookedUnderTest = new ServicesBooked(0L, 0L);
        final Long bookId = 0L;
        servicesBookedUnderTest.setBookId(bookId);
        assertThat(servicesBookedUnderTest.getBookId()).isEqualTo(bookId);
    }

    @Test
    void testServiceIdGetterAndSetter() {
        final ServicesBooked servicesBookedUnderTest = new ServicesBooked(0L, 0L);
        final Long serviceId = 0L;
        servicesBookedUnderTest.setServiceId(serviceId);
        assertThat(servicesBookedUnderTest.getServiceId()).isEqualTo(serviceId);
    }
}
