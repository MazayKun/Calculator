package ru.mikheev.kirill.operations;

import ru.mikheev.kirill.operations.builder.OperationCreationMethod;

public class Number implements MathOperation{

    private double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double getCalculatedValue() {
        return value;
    }

    @Override
    public void rotateOperation(MathOperation additionalArg, OperationCreationMethod builder) {
        throw new RuntimeException("Токен числа не поддерживает операцию вращения");
    }

    @Override
    public int getPriorityValue() {
        return OperationPriority.TOKEN_PRIORITY.getPriorityValue();
    }

    @Override
    public void setBracketsPriority() {}

    @Override
    public int comparePriority(MathOperation mathOperation) {
        return 1;
    }
}
