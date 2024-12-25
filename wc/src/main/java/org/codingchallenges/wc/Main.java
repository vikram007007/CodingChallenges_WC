package org.codingchallenges.wc;

import org.codingchallenges.wc.common.Command;
import org.codingchallenges.wc.factory.CommandFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting terminal....");
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.runCommand(scanner);
        scanner.close();
        System.out.println("Ending terminal....");
    }

    private void runCommand(Scanner scanner) {
        boolean run = true;
        while (run) {
            String input = scanner.nextLine();
            List<Command> commandSplits = splitCommand(input);
            String output = null;
            for (Command command : commandSplits) {
                output = command.execute(output);
            }
            System.out.println(output);
        }
    }

    private List<Command> splitCommand(String input) {
        List<Command> commandSplits = new ArrayList<>();
        List<String> commandArgs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0) {
                    commandArgs.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else if (c == '|') {
                if (!commandArgs.isEmpty()) {
                    commandSplits.add(CommandFactory.getCommand(commandArgs));
                    commandArgs = new ArrayList<>();
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            commandArgs.add(sb.toString());
        }
        if (!commandArgs.isEmpty()) {
            commandSplits.add(CommandFactory.getCommand(commandArgs));
        }
        System.out.println(commandSplits);
        return commandSplits;
    }
}
