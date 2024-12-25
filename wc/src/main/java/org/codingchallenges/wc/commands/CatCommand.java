package org.codingchallenges.wc.commands;

import org.codingchallenges.wc.common.Command;
import org.codingchallenges.wc.utils.CommonUtils;

import java.io.BufferedReader;
import java.util.List;

public class CatCommand extends Command {

    public CatCommand(List<String> commandArgs) {
        super(List.copyOf(commandArgs));
    }

    @Override
    public String execute(String previousOutput) {
        //verify number of args
        //then print the lines of file as it is
        List<String> commandSplits = getCommandArgs();
        if (commandSplits.size() != 2) {
            System.out.println("Less than or more than 2 arguments given. So please re-enter");
            return "";
        }
        return CommonUtils.convertFileInputToString(commandSplits.get(1));
    }
}
