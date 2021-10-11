package ru.mikheev.kirill.operations;

import ru.mikheev.kirill.operations.builder.OperationCreationMethod;

public abstract class BinaryOperation implements MathOperation{

    protected MathOperation firstArg, secondArg;
    protected OperationPriority priority;

    @Override
    public abstract double getCalculatedValue();

    @Override
    public void rotateOperation(MathOperation additionalArg, OperationCreationMethod builder) {
        MathOperation newSecondArg = builder.create(secondArg, additionalArg);
        secondArg = newSecondArg;
    }

    @Override
    public int getPriorityValue() {
        return priority.getPriorityValue();
    }

    @Override
    public void setBracketsPriority() {
        priority = OperationPriority.BRACKETS_PRIORITY;
    }

    @Override
    public int comparePriority(MathOperation mathOperation) {
        return Integer.compare(this.priority.getPriorityValue(), mathOperation.getPriorityValue());
    }
}
