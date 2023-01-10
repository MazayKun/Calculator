package ru.mikheev.kirill;

public class Engine {
//    String[] members = {"\\d+", "\\)", "\\(", "\\-", "\\*", "\\+", "/", "\\^"};
//    String template = "";
//    String corrector = "";
//    Pattern pattern;
//    Pattern correctorPattern;
//    {
//        for (String tmp : members){
//            corrector += tmp;
//            template += "|" + tmp;
//        }
//        template = template.substring(1);
//        pattern = Pattern.compile(template);
//        correctorPattern = Pattern.compile(corrector);
//    }
//    Matcher matcher;
//    ExpressionMember root;
//    Stack<String> brackets;
//
//    public Engine(){
//
//    }
//
//    public void read(String expression){
//        matcher = pattern.matcher(expression);
//        brackets = new Stack<>();
//        try {
//            root = read();
//            if(brackets.empty()) {
//                System.out.println(root.getValue());
//            }else {
//                System.out.println("Wrong expression, too few brackets");
//            }
//        }catch (NullPointerException e){
//            System.out.println("Wrong expression, excess : " + e.getMessage());
//        }
//    }
//
//    public boolean verify(String expression){
//        //matcher = correctorPattern.matcher(expression);
//        //System.out.println(correctorPattern.toString());
//        //return matcher.find();
//        return true;
//    }
//
//    private ExpressionMember read() throws NullPointerException{
//        ExpressionMember lastMember = null;
//        Operations lastOperation = null;
//        while(matcher.find()){
//            switch (matcher.group()){
//                case "(" : {
//                    brackets.push("(");
//                    if(lastMember == null){
//                        lastMember = read();
//                        if(lastMember instanceof  SubExpression) {
//                            ((SubExpression) lastMember).setNewLevel();
//                        }
//                        break;
//                    }
//                    ArrayList<ExpressionMember> newMain = new ArrayList<>();
//                    ExpressionMember tmp = read();
//                    if (lastOperation.getPriority() > lastMember.getPriority() ){
//                        ((SubExpression)lastMember).rotateExpression(tmp, lastOperation);
//                    }else {
//                        newMain.add(lastMember);
//                        newMain.add(tmp);
//                        lastMember = new SubExpression(newMain, lastOperation);
//                    }
//                    lastOperation = null;
//                    break;
//                }
//                case ")" : {
//                    if(brackets.empty()){
//                        throw new NullPointerException(")");
//                    }
//                    brackets.pop();
//                    return lastMember;
//                }
//                case "+" : {
//                    if(lastOperation != null){
//                        throw new NullPointerException("+");
//                    }
//                    lastOperation = Operations.ADDITION;
//                    break;
//                }
//                case "-" : {
//                    if(lastMember == null){
//                        matcher.find();
//                        lastMember = new Token(-1 * Double.parseDouble(matcher.group()));
//                    }else {
//                        if(lastOperation != null){
//                            throw new NullPointerException("-");
//                        }
//                        lastOperation = Operations.SUBTRACTION;
//                    }
//                    break;
//                }
//                case "/" : {
//                    if(lastOperation != null){
//                        throw new NullPointerException("/");
//                    }
//                    lastOperation = Operations.DIVISION;
//                    break;
//                }
//                case "*" : {
//                    if(lastOperation != null){
//                        throw new NullPointerException("*");
//                    }
//                    lastOperation = Operations.MULTIPLICATION;
//                    break;
//                }
//                case "^" : {
//                    if(lastOperation != null){
//                        throw new NullPointerException("^");
//                    }
//                    lastOperation = Operations.EXTENSION;
//                    break;
//                }
//                default:{
//                    if(lastMember != null){
//                        if (lastOperation.getPriority() > lastMember.getPriority() ){
//                            ((SubExpression)lastMember).rotateExpression(new Token(Double.parseDouble(matcher.group())), lastOperation);
//                        }else{
//                            ArrayList<ExpressionMember> newTokens = new ArrayList<>();
//                            newTokens.add(lastMember);
//                            newTokens.add(new Token(Double.parseDouble(matcher.group())));
//
//                            lastMember = new SubExpression(newTokens, lastOperation);
//                        }
//                    }else{
//                        lastMember = new Token(Double.parseDouble(matcher.group()));
//                    }
//                    lastOperation = null;
//                }
//            }
//        }
//        return lastMember;
//    }
}
