package org.codingchallenges.wc.commands;

import org.codingchallenges.wc.common.Command;
import org.codingchallenges.wc.common.Operation;
import org.codingchallenges.wc.factory.OperationFactory;
import org.codingchallenges.wc.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WcCommand extends Command {

    private int indexToFetchPath;

    public WcCommand(List<String> commandArgs) {
        super(List.copyOf(commandArgs));
    }

    //TODO wc -c test.txt -> number of bytes
    //TODO wc -l test.txt
    //TODO wc -w test.txt
    //TODO wc -m test.txt
    //TODO wc test.txt -> -c -l -w

    @Override
    public String execute(String previousOutput) {
        List<String> commandArgs = getCommandArgs();
        //validate args size
        int commandArgsSize = commandArgs.size();
        boolean isChainedOutput = Objects.nonNull(previousOutput) && !previousOutput.isEmpty();
        if (Objects.nonNull(previousOutput) && !previousOutput.isEmpty() && (commandArgsSize > 2)) {
            throw new RuntimeException("wc command with chain does not require more than 2 arguments. Given argument size : " + commandArgsSize);
        } else if (Objects.isNull(previousOutput) && (commandArgsSize > 3 || commandArgsSize < 2)) {
            throw new RuntimeException("wc command without chain with number of arguments " + commandArgsSize + " is not supported in this version");
        }
        List<Operation> operations = parseOperands(commandArgs, isChainedOutput);
        StringBuilder stringBuilder = new StringBuilder();
        String output = isChainedOutput ? null : CommonUtils.convertFileInputToString(commandArgs.get(indexToFetchPath));
        for (Operation operation : operations) {
            stringBuilder.append(operation.applyOperation(isChainedOutput ? previousOutput : output)).append(" ");
        }
        if (!isChainedOutput) {
            stringBuilder.append(commandArgs.get(indexToFetchPath));
        } else if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private List<Operation> parseOperands(List<String> commandArgs, boolean isChainedOutput) {
        String operandArg = commandArgs.get(1);
        List<Operation> operations = new ArrayList<>();
        boolean isDefault = operandArg.charAt(0) != '-';
        operandArg = isDefault ? "-lwc" : operandArg;
        indexToFetchPath = isDefault ? 1 : 2;
        for (char c : operandArg.toCharArray()) {
            if (c != '-') {
                Operation operation = OperationFactory.getWcOperation(List.of(String.valueOf(c), (isChainedOutput) ? "" : commandArgs.get(indexToFetchPath)));
                operations.add(operation);
            }
        }
        return operations;
    }
}
