package ru.mikheev.kirill.operations;


import ru.mikheev.kirill.operations.builder.OperationCreationMethod;

public interface ExpressionMember {

    double getValue();

    OperationPriority getPriority();

    ExpressionMember rotateOperation(ExpressionMember rightExpression,
                                     OperationCreationMethod generalOperationBuilder,
                                     OperationPriority generalOperationPriority);
}
