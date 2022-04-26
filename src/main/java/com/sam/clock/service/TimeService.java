package com.sam.clock.service;

import com.sam.clock.util.TimeFormatUtils;
import org.springframework.stereotype.Service;

@Service
public class TimeService {
    public String fetchTimeInHumanFormat(String timeInNumericFormat) {
        return TimeFormatUtils.convert(TimeFormatUtils.parse(timeInNumericFormat));
    }
}
