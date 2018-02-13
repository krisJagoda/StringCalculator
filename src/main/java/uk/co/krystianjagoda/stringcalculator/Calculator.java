package uk.co.krystianjagoda.stringcalculator;

public class Calculator {

    public double calculate(String equation) {
        if (equation.contains("+")){
            return addition(equation);
        }
        if (equation.contains("-")){
            return subtraction(equation);
        }
        if (equation.contains("*")){
            return multiplication(equation);
        }
        if (equation.contains("/")){
            return division(equation);
        }
        if (equation.matches("[0-9]+")){
            return Double.parseDouble(equation);
        }
        return Double.NaN;

    }

    private double addition(String equation) {
        String[] components = equation.split("\\+");
        double result = 0.0;

        for (String component : components) {
            result += calculate(component);
        }
        return result;
    }

    private double subtraction(String equation) {
        String[] components = equation.split("-");
        double result = calculate(components[0]);

        for (int i = 1; i < components.length; i++) {
            result -= calculate(components[i]);
        }
        return result;
    }

    private double multiplication(String equation) {
        String[] components = equation.split("\\*");
        double result = 1.0;

        for (String component : components) {
            result *= calculate(component);
        }
        return result;
    }
    private double division(String equation) throws IllegalArgumentException {
        String[] components = equation.split("/");

        for (String component : components) {
            if (Integer.parseInt(component) == 0){
                throw new IllegalArgumentException("You cannot divide by 0");
            }
        }

        double result = calculate(components[0]);

        for (int i = 1; i < components.length; i++) {
            result /= calculate(components[i]);
        }
        return result;
    }
}
