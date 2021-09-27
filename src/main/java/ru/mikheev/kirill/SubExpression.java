package ru.mikheev.kirill;

import ru.mikheev.kirill.interfaces.ExpressionMember;

import java.util.ArrayList;

public class SubExpression implements ExpressionMember {

    private ArrayList<ExpressionMember> parts;
    private ExpressionMember secondPart;
    private Operations operation;
    private boolean newLevel = false;

    public SubExpression(ArrayList<ExpressionMember> parts, Operations operation){
        this.parts = parts;
        this.operation = operation;
    }

    public void setNewLevel(){
        newLevel = true;
    }

    public void rotateExpression(ExpressionMember newMain, Operations newOperation){
        ArrayList<ExpressionMember> newMembers = new ArrayList<>();
        newMembers.add(this.parts.get(1));
        newMembers.add(newMain);
        SubExpression tmp = new SubExpression(newMembers , newOperation);
        this.parts.set(1, tmp);
    }

    @Override
    public double getValue() {
        return operation.calculation(parts);
    }

    @Override
    public int getPriority() {
        return newLevel ? 4 : operation.getPriority();
    }
}
