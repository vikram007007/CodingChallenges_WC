package org.codingchallenges.wc.factory;

import org.codingchallenges.wc.commands.CatCommand;
import org.codingchallenges.wc.commands.ExitCommand;
import org.codingchallenges.wc.commands.WcCommand;
import org.codingchallenges.wc.common.Command;
import org.codingchallenges.wc.common.CommandType;

import java.util.List;

public class CommandFactory {

    public static Command getCommand(List<String> commandArgs) {
        Command command;
        CommandType commandType = CommandType.valueOf(commandArgs.get(0));
        switch (commandType) {
            case wc :
                command = new WcCommand(commandArgs);
                break;
            case cat :
                command = new CatCommand(commandArgs);
                break;
            case exit:
                command = new ExitCommand(commandArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown command type: " + commandArgs.get(0));
        }
        return command;
    }

}
