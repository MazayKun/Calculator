package ru.mikheev.kirill.operations.binary;

import ru.mikheev.kirill.operations.ExpressionMember;
import ru.mikheev.kirill.operations.OperationPriority;

public class Subtraction extends BinaryOperation {

    public Subtraction(ExpressionMember minuend, ExpressionMember subtrahend) {
        super(minuend, subtrahend);
    }

    @Override
    protected double calculateOperation(ExpressionMember firstArg, ExpressionMember secondArg) {
        return firstArg.getValue() - secondArg.getValue();
    }

    @Override
    public OperationPriority getPriority() {
        return OperationPriority.SUM_PRIORITY;
    }
}
