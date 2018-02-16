package uk.co.krystianjagoda.stringcalculator.main;


import uk.co.krystianjagoda.stringcalculator.calculator.Calculator;
import uk.co.krystianjagoda.stringcalculator.helpers.IOHelper;
import uk.co.krystianjagoda.stringcalculator.helpers.ValidationHelper;

public class App {


    public static void main(String[] args) {

        IOHelper ioHelper = new IOHelper();
        ValidationHelper validationHelper = new ValidationHelper();
        Calculator calculator = new Calculator();

        while (true) {
            String inputFromUser = ioHelper.getInputFromUser();

            if (validationHelper.validateInputFromUser(inputFromUser)) {
                double result = calculator.calculate(inputFromUser);
                ioHelper.printResult(result);
                break;
            }
            System.out.println("You have entered invalid data, try again");
        }
    }
}
