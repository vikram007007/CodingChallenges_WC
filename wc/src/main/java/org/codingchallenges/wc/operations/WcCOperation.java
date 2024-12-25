package org.codingchallenges.wc.operations;

import org.codingchallenges.wc.common.Operation;

import java.util.List;

public class WcCOperation extends Operation {

    public WcCOperation(List<String> operands) {
        super(List.copyOf(operands));
    }

    @Override
    public String applyOperation(String input) {
        return String.valueOf(input.getBytes().length);
    }
}
