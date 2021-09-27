package ru.mikheev.kirill;

import ru.mikheev.kirill.interfaces.ExpressionMember;

import java.util.ArrayList;

public enum Operations {
    ADDITION(0),
    SUBTRACTION(0),
    MULTIPLICATION(1),
    DIVISION(1),
    EXTENSION(2);

    private int priority;

    Operations(int priority){
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }

    public double calculation(ArrayList<ExpressionMember> expressions){
        switch (this){
            case ADDITION:{
                return expressions.get(0).getValue() + expressions.get(1).getValue();
            }
            case SUBTRACTION:{
                return expressions.get(0).getValue() - expressions.get(1).getValue();
            }
            case MULTIPLICATION:{
                return expressions.get(0).getValue() * expressions.get(1).getValue();
            }
            case DIVISION:{
                return expressions.get(0).getValue() / expressions.get(1).getValue();
            }
            case EXTENSION:{
                return Math.pow(expressions.get(0).getValue(), expressions.get(1).getValue());
            }
            default:{
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        switch (this){
            case SUBTRACTION:{
                return "SUBTRACTION";
            }
            case ADDITION:{
                return "ADDITION";
            }
            case MULTIPLICATION:{
                return "MULTIPLICATION";
            }
            case DIVISION:{
                return "DIVISION";
            }
            case EXTENSION:{
                return "EXTENSION";
            }
        }
        return null;
    }
}
