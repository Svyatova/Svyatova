import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (!"q".equals(userInput)) {
            try {

                System.out.print("firstNumber: ");
                int firstNumber = scanner.nextInt();
                System.out.print("secondNumber: ");
                int secondNumber = scanner.nextInt();
                System.out.print("operations: ");
                userInput = scanner.next();
                System.out.print("result: ");
                double result;

                switch (userInput) {
                    case "+":
                        result = plus(firstNumber, secondNumber);
                        break;
                    case "-":
                        result = minus(firstNumber, secondNumber);
                        break;
                    case "*":
                        result = ymn(firstNumber, secondNumber);
                        break;
                    case "!":
                        result = fact(firstNumber);
                        break;
                    default:
                        result = 0;
                        break;
                    case "/":
                        if (secondNumber == 0) {
                            continue;
                        }
                        result = del(firstNumber, secondNumber);
                        break;
                }
                System.out.println(result);
            } catch (InputMismatchException ex) {
                System.out.println("Wrong input data!");
                continue;
            }
            System.out.println("Enter numbers!");
        }
    }
    private static int plus ( int numberOne, int numberTwo){
        return numberOne + numberTwo;
    }

    private static int minus ( int numberOne, int numberTwo){
        return numberOne - numberTwo;
    }

    private static int ymn ( int numberOne, int numberTwo){
        return numberOne * numberTwo;
    }

    private static int del ( int numberOne, int numberTwo){
        return numberOne / numberTwo;
    }
    private static int fact ( int numberOne){
        int res = 1;
        for (int i = 1; i < numberOne; i++) {
            res *= i;
        }
        return res;
    }
}

