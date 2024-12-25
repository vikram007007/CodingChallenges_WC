package org.codingchallenges.wc.factory;

import org.codingchallenges.wc.common.Operation;
import org.codingchallenges.wc.operations.WcCOperation;
import org.codingchallenges.wc.operations.WcLOperation;
import org.codingchallenges.wc.operations.WcMOperation;
import org.codingchallenges.wc.operations.WcWOperation;

import java.util.List;

public class OperationFactory {

    public static Operation getWcOperation(List<String> operands) {
        Operation operation;
        switch (operands.get(0)) {
            case "c" :
                operation = new WcCOperation(operands);
                break;
            case "l" :
                operation = new WcLOperation(operands);
                break;
            case "m" :
                operation = new WcMOperation(operands);
                break;
            case "w" :
                operation = new WcWOperation(operands);
                break;
            default :
                throw new IllegalArgumentException("Unknown argument type: " + operands.get(0));
        }
        return operation;
    }

}
