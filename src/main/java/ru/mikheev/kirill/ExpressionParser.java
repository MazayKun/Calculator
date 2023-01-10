package ru.mikheev.kirill;

import ru.mikheev.kirill.operations.AnswerWrapper;
import ru.mikheev.kirill.operations.ExpressionMember;
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
        ExpressionMember lastToken = null;
        ExpressionMember answer = null;
        String lastSign = null;
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            switch (matcher.group()) {
                //case "(" :
                //case ")" :
                default  : {
                    double number;
                    try {
                        var group = matcher.group();
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
                        answer = newToken;
                    }else {
                        if(answer.getPriority().getPriorityValue() >= OperationPriority.getPriorityBySign(lastSign).getPriorityValue()) {
                            answer = operationBuilder.buildMathOperation(lastSign, answer, newToken);
                        }else{
                            answer = operationBuilder.rotateOperation(lastSign, answer, newToken);
                        }
                        lastSign = null;
                    }
                }
            }
        }
        return new AnswerWrapper(answer);
    }

    public boolean verifyBracketsSequence(String expression) {
        return true; // TODO
    }
}
