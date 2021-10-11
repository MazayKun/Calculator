package ru.mikheev.kirill;

import ru.mikheev.kirill.operations.AnswerWrapper;
import ru.mikheev.kirill.operations.MathOperation;
import ru.mikheev.kirill.operations.Number;
import ru.mikheev.kirill.operations.OperationPriority;
import ru.mikheev.kirill.operations.builder.OperationBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

    private OperationBuilder operationBuilder;
    private Pattern pattern;

    public ExpressionParser() {
        this.operationBuilder = new OperationBuilder();
        String template = "";
        for (String operationSign : operationBuilder.getAllowedOperations()) {
            template += "\\" + operationSign + "|";
        }
        template += "\\(|\\)|\\d+";
        pattern = Pattern.compile(template);
    }

    public AnswerWrapper parseExpression(String expression) {
        MathOperation lastOperation = null;
        String lastSign = null;
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            switch (matcher.group()) {
                //case "(" :
                //case ")" :
                default  : {
                    double number;
                    try {
                        number = Double.parseDouble(matcher.group());
                    }catch (NumberFormatException e) {
                        if(operationBuilder.getAllowedOperations().contains(matcher.group())) {
                            if(lastSign == null) {
                                lastSign = matcher.group();
                            }else{
                                throw new RuntimeException(matcher.group() + " лишний знак");
                            }
                        }else{
                            throw new RuntimeException(matcher.group() + " операция не поддерживается");
                        }
                        break;
                    }
                    Number newToken = new Number(number);
                    if(lastSign == null) {
                        lastOperation = newToken;
                    }else {
                        if(lastOperation.getPriorityValue() > OperationPriority.getPriorityBySign(matcher.group()).getPriorityValue()) {
                            lastOperation = operationBuilder.buildMathOperation(matcher.group(), lastOperation, newToken);
                        }else{
                            operationBuilder.rotateOperation(lastSign, lastOperation, newToken);
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean verifyBracketsSequence(String expression) {
        return true; // TODO
    }
}
