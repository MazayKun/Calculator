package ru.mikheev.kirill.operations.binary;

import ru.mikheev.kirill.operations.ExpressionMember;
import ru.mikheev.kirill.operations.OperationPriority;

public class Addition extends BinaryOperation {

    public Addition(ExpressionMember term1, ExpressionMember term2) {
        super(term1, term2);
    }

    @Override
    protected double calculateOperation(ExpressionMember firstArg, ExpressionMember secondArg) {
        return firstArg.getValue() + secondArg.getValue();
    }

    @Override
    public OperationPriority getPriority() {
        return OperationPriority.SUM_PRIORITY;
    }
}
