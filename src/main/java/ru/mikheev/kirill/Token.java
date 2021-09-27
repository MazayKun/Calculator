package ru.mikheev.kirill;

import ru.mikheev.kirill.interfaces.ExpressionMember;

public class Token implements ExpressionMember {

    private double value;

    public Token(double value){
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public int getPriority() {
        return 4;
    }
}
