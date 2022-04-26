package com.sam.clock.cli.command;

public interface Command {
    String commandName();
    void run();
}
