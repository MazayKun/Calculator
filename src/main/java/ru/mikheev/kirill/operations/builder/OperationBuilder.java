package ru.mikheev.kirill.operations.builder;

import ru.mikheev.kirill.operations.ExpressionMember;
import ru.mikheev.kirill.operations.OperationPriority;
import ru.mikheev.kirill.operations.binary.Addition;
import ru.mikheev.kirill.operations.binary.Division;
import ru.mikheev.kirill.operations.binary.Multiplication;
import ru.mikheev.kirill.operations.binary.Subtraction;

import java.util.*;

public class OperationBuilder {

    private Map<String, OperationCreationMethod> builders;
    private List<String> allowedOperations = new ArrayList<>();

    public OperationBuilder() {
        init();
    }

    public List<String> getAllowedOperations() {
        return allowedOperations;
    }

    public ExpressionMember buildMathOperation(String operationSign, ExpressionMember... args) {
        if(!builders.containsKey(operationSign)) {
            throw new NullPointerException(operationSign + " не поддерживаемый тип операции");
        }
        return builders.get(operationSign).create(args);
    }

    public ExpressionMember rotateOperation(String operationSign, ExpressionMember oldExpression, ExpressionMember nextNumber) {
        return oldExpression.rotateOperation(nextNumber, builders.get(operationSign), OperationPriority.getPriorityBySign(operationSign));
    }

    private void init() {
        builders = new HashMap<>();

        builders.put("+", this::createAddition);
        allowedOperations.add("+");
        builders.put("-", this::createSubtraction);
        allowedOperations.add("-");
        builders.put("*", this::createMultiplication);
        allowedOperations.add("*");
        builders.put("/", this::createDivision);
        allowedOperations.add("/");
    }

    private Addition createAddition(ExpressionMember... args) {
        return new Addition(args[0], args[1]);
    }

    private Subtraction createSubtraction(ExpressionMember... args) {
        return new Subtraction(args[0], args[1]);
    }

    private Multiplication createMultiplication(ExpressionMember... args) {
        return new Multiplication(args[0], args[1]);
    }

    private Division createDivision(ExpressionMember... args) {
        return new Division(args[0], args[1]);
    }
}
