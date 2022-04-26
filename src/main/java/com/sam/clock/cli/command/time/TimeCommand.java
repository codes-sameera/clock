package com.sam.clock.cli.command.time;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.sam.clock.cli.command.Command;
import com.sam.clock.util.TimeFormatUtils;
import org.springframework.stereotype.Component;

@Component
@Parameters(commandNames = TimeCommand.COMMAND_NAME, commandDescription = "Time command, displays time (current or optionally input in numeric format) in human readable format")
public class TimeCommand implements Command {

    public static final String COMMAND_NAME = "time";

    @Parameter(
            names = { "--numeric-format-input", "-n" },
            description = "Time in numeric 24 hour format - Ex. 14:35"
    )
    private String timeInNumericFormat;

    @Override
    public String commandName() {
        return COMMAND_NAME;
    }

    @Override
    public void run() {
        System.out.println(TimeFormatUtils.convert(TimeFormatUtils.parse(timeInNumericFormat)));
    }
}
