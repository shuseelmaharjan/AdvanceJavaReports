package main;
import custom.InvalidAgeException;
public class AgeValidator {
    public void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative.");
        } else if (age < 18) {
            throw new InvalidAgeException("Age must be at least 18.");
        }
        System.out.println("Age is valid.");
    }
}
