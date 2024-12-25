package org.codingchallenges.wc.common;

import java.util.List;

public abstract class Operation {

    private final List<String> operands;

    public Operation(List<String> operands) {
        this.operands = operands;
    }

    protected List<String> getOperands() {
        return this.operands;
    }

    public abstract String applyOperation(String input);

}
