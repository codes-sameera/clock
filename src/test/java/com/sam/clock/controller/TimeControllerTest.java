package com.sam.clock.controller;

import com.sam.clock.service.TimeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TimeControllerTest {

    @Mock
    private TimeService timeService;

    @InjectMocks
    private TimeController timeController;

    @BeforeAll
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCurrentTimeInHumanFormatTest() {
        when(timeService.fetchTimeInHumanFormat(null)).thenReturn("hello");
        assertEquals("hello", timeController.getTimeInHumanFormat(null));
        verify(timeService).fetchTimeInHumanFormat(null);
    }

    @Test
    void getArbitraryInputTimeInHumanFormatTest() {
        when(timeService.fetchTimeInHumanFormat("10:20")).thenReturn("hello");
        assertEquals("hello", timeController.getTimeInHumanFormat("10:20"));
        verify(timeService).fetchTimeInHumanFormat("10:20");
    }
}