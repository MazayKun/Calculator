package ru.mikheev.kirill.operations.binary;

import ru.mikheev.kirill.operations.ExpressionMember;
import ru.mikheev.kirill.operations.OperationPriority;

public class Division extends BinaryOperation {

    public Division(ExpressionMember dividend, ExpressionMember divider) {
        super(dividend, divider);
    }

    @Override
    protected double calculateOperation(ExpressionMember firstArg, ExpressionMember secondArg) {
        return firstArg.getValue() / secondArg.getValue();
    }

    @Override
    public OperationPriority getPriority() {
        return OperationPriority.MULTIPLICATION_PRIORITY;
    }
}
