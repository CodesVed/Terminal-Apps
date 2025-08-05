import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("======Guess It======");

        int choice;
        do{
            choice = -1;
            System.out.println("""
                    \nGame Modes:
                    1. Guess The Number
                    2. High/Low
                    0. Exit""");

            System.out.print("\nSelect: ");
            try{
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e){
                System.out.println("ERROR: invalid argument");
                sc.nextLine();
            }

            switch (choice){
                case 1 -> handleGuessingNumber();
                case 2 -> handleHighLow();
                case 0 -> exitApp();
                default -> System.out.println("ERROR: Invalid Input.");
            }
        } while (choice != 0);
    }

    private static void handleGuessingNumber(){
        int range = 0, min = 1, max, attempt;
        while (range != 3){
            try {
                System.out.println("""
                    \nSelect Range:
                    1. 1-10
                    2. 1-25
                    3. Main Menu""");

                System.out.print("\nYour choice: ");
                try {
                    range = sc.nextInt();
                    sc.nextLine();

                    switch (range) {
                        case 1 -> {
                            max = 10;
                            attempt = 3;
                            Methods.guessNumber(min, max, attempt);
                        }
                        case 2 -> {
                            attempt = 5;
                            max = 25;
                            Methods.guessNumber(min, max, attempt);
                        }
                        case 3 -> System.out.println("Returning to main menu...");
                        default -> System.out.println("Please enter a valid option (1-3).");
                    }
                } catch (Exception e){
                    System.out.println("Invalid Input. Please enter number.");
                    sc.nextLine();
                }


            } catch (Exception e){
                System.out.println("ERROR: Invalid Input.");
                sc.nextLine();
            }
        }
    }

    private static void handleHighLow(){
        int attempt = 4;
        Methods.highLow(attempt);
    }

    private static void exitApp(){
        System.out.println("\nGG! See you Soon.");
        sc.close();
    }
}