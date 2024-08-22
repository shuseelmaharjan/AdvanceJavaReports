import custom.InvalidAgeException;
import main.AgeValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AgeValidator validator = new AgeValidator();

        System.out.println("Enter an age:");
        Scanner input = new Scanner(System.in);
        int age = input.nextInt();

        try{
            validator.validateAge(age);
        }catch (InvalidAgeException e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
    }
}