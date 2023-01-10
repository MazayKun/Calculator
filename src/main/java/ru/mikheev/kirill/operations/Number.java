package ru.mikheev.kirill.operations;

import ru.mikheev.kirill.operations.builder.OperationCreationMethod;

public class Number implements ExpressionMember {

    private double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public OperationPriority getPriority() {
        return OperationPriority.TOKEN_PRIORITY;
    }

    @Override
    public ExpressionMember rotateOperation(ExpressionMember rightExpression,
                                            OperationCreationMethod generalOperationBuilder,
                                            OperationPriority generalOperationPriority) {
        return generalOperationBuilder.create(this, rightExpression);
    }
}
