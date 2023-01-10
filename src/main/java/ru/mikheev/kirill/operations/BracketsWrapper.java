package ru.mikheev.kirill.operations;

import ru.mikheev.kirill.operations.builder.OperationCreationMethod;

public class BracketsWrapper implements ExpressionMember {

    private ExpressionMember expressionMember;

    public BracketsWrapper(ExpressionMember expressionMember) {
        this.expressionMember = expressionMember;
    }

    @Override
    public double getValue() {
        return expressionMember.getValue();
    }

    @Override
    public OperationPriority getPriority() {
        return OperationPriority.BRACKETS_PRIORITY;
    }

    @Override
    public ExpressionMember rotateOperation(ExpressionMember rightExpression, OperationCreationMethod generalOperationBuilder, OperationPriority generalOperationPriority) {
        throw new UnsupportedOperationException("Обертку скобочного выражения нельзя переставлять");
    }
}
