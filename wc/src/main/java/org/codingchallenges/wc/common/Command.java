package org.codingchallenges.wc.common;

import java.util.List;

public abstract class Command {

    private final List<String> commandArgs;

    public Command(List<String> commandArgs) {
        this.commandArgs = commandArgs;
    }

    protected List<String> getCommandArgs() {
        return commandArgs;
    }

    public abstract String execute(String previousOutput);

    @Override
    public String toString() {
        return "Command{" +
                "commandArgs=" + commandArgs +
                '}';
    }
}
