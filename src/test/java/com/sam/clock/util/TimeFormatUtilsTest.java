package com.sam.clock.util;

import com.sam.clock.model.TimeIn24HourFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeFormatUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void parseNullTimeTest() {
        LocalTime now = LocalTime.now();
        assertEquals(new TimeIn24HourFormat(now.getHour(), now.getMinute()), TimeFormatUtils.parse(null));
    }

    @Test
    void parseInvalidTimeTest() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> TimeFormatUtils.parse("25:43"));
        assertEquals("The hour should be between 0 and 23; the minute should be between 0 and 59.", e.getMessage());
    }

    @Test
    void parseInvalidDataTest() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> TimeFormatUtils.parse("abcd"));
        assertEquals("Input is not a valid 24-hour format time.", e.getMessage());
    }

    @Test
    void parseValidTimeTest() {
        assertEquals(new TimeIn24HourFormat(10, 20), TimeFormatUtils.parse("10:20"));
    }

    @Test
    void convert1200amTest() {
        assertEquals("Twelve o'clock in the morning.", TimeFormatUtils.convert(new TimeIn24HourFormat(0, 0)));
    }

    @Test
    void convert1200pmTest() {
        assertEquals("Twelve o'clock in the afternoon.", TimeFormatUtils.convert(new TimeIn24HourFormat(12, 0)));
    }

    @Test
    void convertEveningTest() {
        assertEquals("Ten o'clock in the evening.", TimeFormatUtils.convert(new TimeIn24HourFormat(22, 0)));
    }

    @Test
    void convertQuarterPastTest() {
        assertEquals("Quarter past ten in the evening.", TimeFormatUtils.convert(new TimeIn24HourFormat(22, 15)));
    }

    @Test
    void convertQuarterToTest() {
        assertEquals("Quarter to ten in the evening.", TimeFormatUtils.convert(new TimeIn24HourFormat(21, 45)));
    }

    @Test
    void convertHalfPastTest() {
        assertEquals("Half past ten in the evening.", TimeFormatUtils.convert(new TimeIn24HourFormat(22, 30)));
    }

    @Test
    void convertPastTest() {
        assertEquals("Twenty five past ten in the evening.", TimeFormatUtils.convert(new TimeIn24HourFormat(22, 25)));
    }

    @Test
    void convertToTest() {
        assertEquals("Twenty five to ten in the evening.", TimeFormatUtils.convert(new TimeIn24HourFormat(21, 35)));
    }
}