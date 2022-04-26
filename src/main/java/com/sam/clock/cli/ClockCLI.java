package com.sam.clock.cli;

import com.beust.jcommander.JCommander;
import com.sam.clock.cli.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClockCLI implements CommandLineRunner {

    @Autowired
    private List<Command> commands;

    @Override
    public void run(String... args) {
        JCommander.Builder builder = JCommander.newBuilder().programName("clock-cli");
        commands.forEach(builder::addCommand);
        JCommander jc = builder.build();
        jc.parse(args);
        Optional<Command> command = commands.stream().filter(c -> c.commandName().equals(jc.getParsedCommand())).findFirst();
        command.ifPresentOrElse(Command::run, jc::usage);
    }
}
