package org.codingchallenges.wc.operations;

import org.codingchallenges.wc.common.Operation;

import java.util.List;

public class WcWOperation extends Operation {

    public WcWOperation(List<String> operands) {
        super(operands);
    }

    @Override
    public String applyOperation(String input) {
        return String.valueOf(input.split("\\s+").length);
    }
}
