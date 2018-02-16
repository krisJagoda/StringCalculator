package uk.co.krystianjagoda.stringcalculator.helpers;

import java.util.Scanner;

public class IOHelper {

    public String getInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a valid equation:");
        return scanner.nextLine();
    }

    public void printResult(double result){

        System.out.println(String.format("The calculated result is: %.4f",result));
    }

}
