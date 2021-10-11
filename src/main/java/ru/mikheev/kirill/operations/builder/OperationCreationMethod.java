package ru.mikheev.kirill.operations.builder;

import ru.mikheev.kirill.operations.MathOperation;

@FunctionalInterface
public interface OperationCreationMethod {

    MathOperation create(MathOperation... args);

}
