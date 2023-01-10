package ru.mikheev.kirill.operations.builder;

import ru.mikheev.kirill.operations.ExpressionMember;

@FunctionalInterface
public interface OperationCreationMethod {

    ExpressionMember create(ExpressionMember... args);

}
