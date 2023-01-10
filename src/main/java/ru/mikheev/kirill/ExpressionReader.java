package ru.mikheev.kirill;

public class ExpressionReader {
    public static void main(String argc[]){
        System.out.println("Puff");
        ExpressionParser parser = new ExpressionParser();
        var result = parser.parseExpression("(1 + 2 + 3) / 2 * 2 * 2 * 2 + 1");
        System.out.println(result.getCalculatedValue());
    }
}
