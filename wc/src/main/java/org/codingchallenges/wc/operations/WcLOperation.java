package org.codingchallenges.wc.operations;

import org.codingchallenges.wc.common.Operation;

import java.util.List;

public class WcLOperation extends Operation {

    public WcLOperation(List<String> operands) {
        super(operands);
    }

    @Override
    public String applyOperation(String input) {
        int line = 0;
        for (char c : input.toCharArray()) {
            if (c == '\n') {
                line++;
            }
        }
        return String.valueOf(line);
    }
}
