package ru.mikheev.kirill.operations;

public class Subtraction extends BinaryOperation{

    public Subtraction(MathOperation minuend, MathOperation subtrahend) {
        this.firstArg = minuend;
        this.secondArg = subtrahend;
        this.priority = OperationPriority.SUM_PRIORITY;
    }

    @Override
    public double getCalculatedValue() {
        return firstArg.getCalculatedValue() - secondArg.getCalculatedValue();
    }
}
