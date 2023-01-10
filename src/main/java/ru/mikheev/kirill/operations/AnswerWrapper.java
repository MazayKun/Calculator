package ru.mikheev.kirill.operations;

public class AnswerWrapper {

    private ExpressionMember answer;

    public AnswerWrapper(ExpressionMember answer) {
        this.answer = answer;
    }

    public double getCalculatedValue() {
        return answer.getValue();
    }
}
