package ru.mikheev.kirill.operations;

public class Addition extends BinaryOperation{

    public Addition(MathOperation term1, MathOperation term2) {
        this.firstArg = term1;
        this.secondArg = term2;
        this.priority = OperationPriority.SUM_PRIORITY;
    }

    @Override
    public double getCalculatedValue() {
        return firstArg.getCalculatedValue() + secondArg.getCalculatedValue();
    }

}
