package uk.co.krystianjagoda.stringcalculator;

public class App {
    public static void main(String[] args) {
        String equation = "3+4*5-6";
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(equation));
    }
}
