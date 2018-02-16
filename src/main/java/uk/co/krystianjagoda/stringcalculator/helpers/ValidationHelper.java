package uk.co.krystianjagoda.stringcalculator.helpers;

import uk.co.krystianjagoda.stringcalculator.calculator.Calculator;

public class ValidationHelper {

    private Calculator calculator;
    private IOHelper helper;

    public ValidationHelper() {
    }

    public ValidationHelper(Calculator calculator, IOHelper helper) {
        this.calculator = calculator;
        this.helper = helper;
    }

    public boolean validateInputFromUser(String input) throws IllegalArgumentException {

        String regex = "([-+]?[0-9]*\\.?[0-9]+[/+\\-*])*([-+]?[0-9]*\\.?[0-9]+)";
        String validatedInput = input.replaceAll("\\s+", "");

        return !validatedInput.isEmpty() && validatedInput.matches(regex);
    }
}
