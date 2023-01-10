package ru.mikheev.kirill.operations.binary;

import ru.mikheev.kirill.operations.ExpressionMember;
import ru.mikheev.kirill.operations.OperationPriority;

public class Multiplication extends BinaryOperation {

    public Multiplication(ExpressionMember multiplied1, ExpressionMember multiplied2) {
        super(multiplied1, multiplied2);
    }

    @Override
    protected double calculateOperation(ExpressionMember firstArg, ExpressionMember secondArg) {
        return firstArg.getValue() * secondArg.getValue();
    }

    @Override
    public OperationPriority getPriority() {
        return OperationPriority.MULTIPLICATION_PRIORITY;
    }
}
