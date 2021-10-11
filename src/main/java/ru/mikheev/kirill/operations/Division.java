package ru.mikheev.kirill.operations;

public class Division extends BinaryOperation {

    public Division(MathOperation dividend, MathOperation divider) {
        this.firstArg = dividend;
        this.secondArg = divider;
        this.priority = OperationPriority.MULTIPLICATION_PRIORITY;
    }

    @Override
    public double getCalculatedValue() {
        return firstArg.getCalculatedValue() / secondArg.getCalculatedValue();
    }

}
