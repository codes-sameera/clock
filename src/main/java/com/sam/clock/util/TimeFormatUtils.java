package com.sam.clock.util;

import com.sam.clock.model.TimeIn24HourFormat;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

import java.time.LocalTime;
import java.util.Locale;

@UtilityClass
public class TimeFormatUtils {

    private final String[] num = {
            "Twelve", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen", "Twenty", "Twenty one",
            "Twenty two", "Twenty three", "Twenty four",
            "Twenty five", "Twenty six", "Twenty seven",
            "Twenty eight", "Twenty nine"
    };

    /**
     * Parses the time string to a TimeIn24HourFormat object.
     * If time string is null, creates a TimeIn24HourFormat object with current time.
     * @param time - numeric format time to parse.
     * @return the TimeIn24HourFormat object.
     */
    public TimeIn24HourFormat parse (String time) {

        if (time == null) {
            LocalTime now = LocalTime.now();
            return new TimeIn24HourFormat(now.getHour(), now.getMinute());
        }

        int h;
        int m;
        try {
            String[] timeArray = time.split(":");
            h = Integer.parseInt(timeArray[0]);
            m = Integer.parseInt(timeArray[1]);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Input is not a valid 24-hour format time");
        }
        if (h > 23 || m > 59 || h < 0 || m < 0) {
            throw new IllegalArgumentException("The hour should be between 0 and 23; the minute should be between 0 and 59.");
        }
        return new TimeIn24HourFormat (h, m);
    }


    /**
     * Converts the timeIn24HourFormat object to a human format time string.<br><br/>
     * Example: If input is 22:35, output is Twenty five to eleven in the evening.<br><br/>
     * @param timeIn24HourFormat - timeIn24HourFormat object to parse.
     * @return the human format time string.
     */
    public String convert(TimeIn24HourFormat timeIn24HourFormat) {
        StringBuilder timeInHumanFormat = new StringBuilder();
        int m = timeIn24HourFormat.getMinute();
        int h = timeIn24HourFormat.getHour();
        switch (m) {
            case 0:
                timeInHumanFormat.append(num[h % 12]).append(" o'clock");
                break;
            case  15:
                timeInHumanFormat.append("Quarter past ").append(num[h % 12]);
                break;
            case  30:
                timeInHumanFormat.append("Half past ").append(num[h % 12]);
                break;
            case  45:
                timeInHumanFormat.append("Quarter to ").append(num[(h % 12) + 1]);
                break;
            default:
                if (m < 30) {
                    timeInHumanFormat.append(num[m]).append(" past ").append(num[h % 12]);
                }
                else {
                    timeInHumanFormat.append(num[60 - m]).append(" to ").append(num[(h % 12) + 1]);
                }
        }

        appendTimeOfDay(timeInHumanFormat, h);

        return StringUtils.capitalize(timeInHumanFormat.toString().toLowerCase(Locale.ROOT));
    }

    private void appendTimeOfDay(StringBuilder timeInHumanFormat, int h) {
        if (h < 12) {
            timeInHumanFormat.append(" in the morning.");
        }
        else if (h < 16) {
            timeInHumanFormat.append(" in the afternoon.");
        }
        else {
            timeInHumanFormat.append(" in the evening.");
        }
    }
}
