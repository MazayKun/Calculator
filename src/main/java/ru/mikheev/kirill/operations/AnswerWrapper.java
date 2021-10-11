package ru.mikheev.kirill.operations;

public class AnswerWrapper{

    private MathOperation answer;

    public AnswerWrapper(MathOperation answer) {
        this.answer = answer;
    }

    public double getCalculatedValue() {
        return answer.getCalculatedValue();
    }
}
