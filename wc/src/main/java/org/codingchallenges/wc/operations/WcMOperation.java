package org.codingchallenges.wc.operations;

import org.codingchallenges.wc.common.Operation;

import java.util.List;

public class WcMOperation extends Operation {

    public WcMOperation(List<String> operands) {
        super(operands);
    }

    @Override
    public String applyOperation(String input) {
        return String.valueOf(input.length());
    }
}
