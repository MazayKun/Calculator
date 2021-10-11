package ru.mikheev.kirill.operations;

public class Multiplication extends BinaryOperation{

    public Multiplication(MathOperation multiplied1, MathOperation multiplied2) {
        this.firstArg = multiplied1;
        this.secondArg = multiplied2;
        this.priority = OperationPriority.MULTIPLICATION_PRIORITY;
    }

    @Override
    public double getCalculatedValue() {
        return firstArg.getCalculatedValue() * secondArg.getCalculatedValue();
    }
}
