package com.sam.clock.model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
public class TimeIn24HourFormat {
    int hour;
    int minute;
}
