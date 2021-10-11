package ru.mikheev.kirill.operations;


import ru.mikheev.kirill.operations.builder.OperationCreationMethod;

public interface MathOperation{

    double getCalculatedValue();

    void rotateOperation(MathOperation additionalArg, OperationCreationMethod builder);

    int getPriorityValue();

    void setBracketsPriority();

    int comparePriority(MathOperation mathOperation);
}
