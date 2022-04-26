package com.sam.clock.controller;

import com.sam.clock.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public String getTimeInHumanFormat(@RequestParam(required = false, name = "t") String timeInNumericFormat) {
        return timeService.fetchTimeInHumanFormat(timeInNumericFormat);
    }
}
