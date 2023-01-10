package ru.mikheev.kirill.operations.binary;

import ru.mikheev.kirill.operations.ExpressionMember;
import ru.mikheev.kirill.operations.OperationPriority;
import ru.mikheev.kirill.operations.builder.OperationCreationMethod;

public abstract class BinaryOperation implements ExpressionMember {

    protected ExpressionMember firstArg, secondArg;

    public BinaryOperation(ExpressionMember firstArg, ExpressionMember secondArg) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    @Override
    public double getValue() {
        return calculateOperation(firstArg, secondArg);
    }

    @Override
    public ExpressionMember rotateOperation(ExpressionMember rightExpression,
                                            OperationCreationMethod generalOperationBuilder,
                                            OperationPriority generalOperationPriority) {
        if(generalOperationPriority.getPriorityValue() > secondArg.getPriority().getPriorityValue()) {
            this.secondArg = secondArg.rotateOperation(rightExpression, generalOperationBuilder, generalOperationPriority);
        }else{
            this.secondArg = generalOperationBuilder.create(secondArg, rightExpression);
        }
        return this;
    }

    protected abstract double calculateOperation(ExpressionMember firstArg, ExpressionMember secondArg);
}
