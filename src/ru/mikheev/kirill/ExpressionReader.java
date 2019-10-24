package ru.mikheev.kirill;

public class ExpressionReader {
    public static void main(String argc[]){
        System.out.println("Puff");
        Engine engine = new Engine();
        engine.read("10 * 2 + ((2 + 4) / 3 + 1) / 3 + 1");

    }
}
