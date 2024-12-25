package org.codingchallenges.wc.commands;

import org.codingchallenges.wc.common.Command;

import java.util.List;

public class ExitCommand extends Command {

    public ExitCommand(List<String> commandArgs) {
        super(commandArgs);
    }

    @Override
    public String execute(String previousOutput) {
        System.exit(0);
        return "";
    }
}
