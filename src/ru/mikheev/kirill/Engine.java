package ru.mikheev.kirill;

import ru.mikheev.kirill.interfaces.ExpressionMember;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Engine {
    String[] members = {"\\d+", "\\)", "\\(", "\\-", "\\*", "\\+", "/"};
    String template = "";
    String corrector = "";
    Pattern pattern;
    Pattern correctorPattern;
    {
        for (String tmp : members){
            corrector += tmp;
            template += "|" + tmp;
        }
        template = template.substring(1);
        pattern = Pattern.compile(template);
        correctorPattern = Pattern.compile(corrector);
    }
    Matcher matcher;
    ExpressionMember root;

    public Engine(){

    }

    public void read(String expression){
        matcher = pattern.matcher(expression);
        root = read();
        System.out.println(root.getValue());
    }

    public boolean verify(String expression){
        //matcher = correctorPattern.matcher(expression);
        //System.out.println(correctorPattern.toString());
        //return matcher.find();
        return false;
    }

    private ExpressionMember read(){
        ExpressionMember lastMember = null;
        Operations lastOperation = null;
        while(matcher.find()){
            switch (matcher.group()){
                case "(" : {
                    if(lastMember == null){
                        lastMember = read();
                        ((SubExpression)lastMember).setNewLevel();
                        break;
                    }
                    ArrayList<ExpressionMember> newMain = new ArrayList<>();
                    ExpressionMember tmp = read();
                    if (lastOperation.getPriority() > lastMember.getPriority() ){
                        ((SubExpression)lastMember).rotateExpression(tmp, lastOperation);
                    }else {
                        newMain.add(lastMember);
                        newMain.add(tmp);
                        lastMember = new SubExpression(newMain, lastOperation);
                    }
                    break;
                }
                case ")" : {
                    return lastMember;
                }
                case "+" : {
                    lastOperation = Operations.ADDITION;
                    break;
                }
                case "-" : {
                    lastOperation = Operations.SUBTRACTION;
                    break;
                }
                case "/" : {
                    lastOperation = Operations.DIVISION;
                    break;
                }
                case "*" : {
                    lastOperation = Operations.MULTIPLICATION;
                    break;
                }
                default:{
                    if(lastMember != null){
                        if (lastOperation.getPriority() > lastMember.getPriority() ){
                            ((SubExpression)lastMember).rotateExpression(new Token(Double.parseDouble(matcher.group())), lastOperation);
                        }else{
                            ArrayList<ExpressionMember> newTokens = new ArrayList<>();
                            newTokens.add(lastMember);
                            newTokens.add(new Token(Double.parseDouble(matcher.group())));

                            lastMember = new SubExpression(newTokens, lastOperation);
                        }
                    }else{
                        lastMember = new Token(Double.parseDouble(matcher.group()));
                    }
                }
            }
        }
        return lastMember;
    }
}
