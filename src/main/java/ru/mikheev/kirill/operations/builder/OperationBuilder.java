package ru.mikheev.kirill.operations.builder;

import ru.mikheev.kirill.operations.Addition;
import ru.mikheev.kirill.operations.Division;
import ru.mikheev.kirill.operations.MathOperation;
import ru.mikheev.kirill.operations.Multiplication;
import ru.mikheev.kirill.operations.Number;
import ru.mikheev.kirill.operations.Subtraction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OperationBuilder {

    private Map<String, OperationCreationMethod> builders;
    private ArrayList<String> allowedOperations;

    public OperationBuilder() {
        init();
    }

    public ArrayList<String> getAllowedOperations() {
        ArrayList<String> copy = new ArrayList<>();
        Collections.copy(allowedOperations, copy);
         return copy;
    }

    public MathOperation buildMathOperation(String operationSign, MathOperation... args) {
        if(!builders.containsKey(operationSign)) {
            throw new NullPointerException(operationSign + " не поддерживаемый тип операции");
        }
        return builders.get(operationSign).create(args);
    }

    public void rotateOperation(String operationSign, MathOperation oldExpression, Number nextNumber) {
        oldExpression.rotateOperation(nextNumber, builders.get(operationSign));
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

    private Addition createAddition(MathOperation... args) {
        return new Addition(args[0], args[1]);
    }

    private Subtraction createSubtraction(MathOperation... args) {
        return new Subtraction(args[0], args[1]);
    }

    private Multiplication createMultiplication(MathOperation... args) {
        return new Multiplication(args[0], args[1]);
    }

    private Division createDivision(MathOperation... args) {
        return new Division(args[0], args[1]);
    }
}
