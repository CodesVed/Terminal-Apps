import java.awt.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class CalculatorUI_Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean enableColors = !Arrays.asList(args).contains("--no-color");
        ConsoleColors.setEnabled(enableColors);

        System.out.println(enableColors ? "🌈 Colors ON" : "Colors OFF");

        System.out.println(ConsoleColors.GOLDEN()+ "===== Just Calculator ====="+ConsoleColors.RESET());

        int choice;
        do{
            choice = -1;

            System.out.println(ConsoleColors.GREEN()+"""
                    \nAvailable Features:
                    1. Addition         2. Subtraction
                    3. Multiplication   4. Division
                    5. Exponent         6. Percent of #
                    7. Factorial        8. Interest Calculator
                    0. Exit"""+ConsoleColors.RESET());

            System.out.print(ConsoleColors.WHITE()+"\nChoose Option: "+ConsoleColors.RESET());
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e){
                System.out.println(ConsoleColors.RED_BOLD()+"ERROR: Invalid Input!"+ConsoleColors.RESET());
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> handleSum();
                case 2 -> handleSubtract();
                case 3 -> handleMultiply();
                case 4 -> handleDiv();
                case 5 -> handleExponent();
                case 6 -> handlePercentOf();
                case 7 -> handleFactorial();
                case 8 -> handleInterestCalc();
                case 0 -> exitApp();
                default -> System.out.println(ConsoleColors.RED_BOLD()+"ERROR: Invalid Input!"+ConsoleColors.RESET());
            }
        } while (choice != 0);
    }

    private static void handleSum(){
        try {
            double result = Calculation.add(sc);
            System.out.printf(ConsoleColors.BLUE_BOLD()+"Sum: %.2f%n"+ConsoleColors.RESET(), result);
        } catch (Exception e){
            System.out.println(ConsoleColors.RED_BOLD()+"Failed Operation!"+ConsoleColors.RESET());
            sc.nextLine();
        }
    }

    private static void handleSubtract(){
        try {
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter first number: "+ConsoleColors.RESET());
            double n1 = sc.nextDouble();
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter second number: "+ConsoleColors.RESET());
            double n2 = sc.nextDouble();
            double result = Calculation.subtract(n1,n2);

            System.out.printf(ConsoleColors.BLUE_BOLD()+"Difference: %.2f%n"+ConsoleColors.RESET(), result);
            UIUtil.pause(500);
        } catch (Exception e){
            System.out.println(ConsoleColors.RED_BOLD()+"Failed Operation!"+ ConsoleColors.RESET());
            sc.nextLine();
        }
    }

    private static void handleMultiply(){
        try {
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter first number: "+ConsoleColors.RESET());
            double n1 = sc.nextDouble();
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter second number: "+ConsoleColors.RESET());
            double n2 = sc.nextDouble();
            double result = Calculation.multiply(n1,n2);

            System.out.printf(ConsoleColors.BLUE_BOLD()+"Result: %.2f%n"+ConsoleColors.RESET(), result);
            UIUtil.pause(500);

        } catch (Exception e){
            System.out.println(ConsoleColors.RED_BOLD()+"Failed Operation!"+ ConsoleColors.RESET());
            sc.nextLine();
        }
    }

    private static void handleDiv(){
        try {
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter first number: "+ConsoleColors.RESET());
            double n1 = sc.nextDouble();
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter second number: "+ConsoleColors.RESET());
            double n2 = sc.nextDouble();
            double result = Calculation.divide(n1,n2);

            System.out.printf(ConsoleColors.BLUE_BOLD()+"Quotient: %.2f%n"+ConsoleColors.RESET(), result);
            UIUtil.pause(500);
        } catch (Exception e){
            System.out.println(ConsoleColors.RED_BOLD()+"Failed Operation!"+ ConsoleColors.RESET());
            sc.nextLine();
        }
    }

    private static void handleExponent(){
        try {
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter base: "+ConsoleColors.RESET());
            double b = sc.nextDouble();
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter power: "+ConsoleColors.RESET());
            double p = sc.nextDouble();
            double result = Calculation.exponent(b,p);

            System.out.printf(ConsoleColors.BLUE_BOLD()+"%.2f raised to the power %.2f is: %.2f%n"+ConsoleColors.RESET(), b,p,result);
            UIUtil.pause(500);
        } catch (Exception e){
            System.out.println(ConsoleColors.RED_BOLD()+"Failed Operation!"+ ConsoleColors.RESET());
            sc.nextLine();
        }
    }

    private static void handlePercentOf(){
        try {
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter percentage: "+ConsoleColors.RESET());
            double p = sc.nextDouble();
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter value: "+ConsoleColors.RESET());
            double v = sc.nextDouble();
            double result = Calculation.percentOf(p,v);

            System.out.printf(ConsoleColors.BLUE_BOLD()+"%.2f%% of %.2f is: %.2f%n"+ConsoleColors.RESET(), p,v,result);
            UIUtil.pause(500);
        } catch (Exception e){
            System.out.println(ConsoleColors.RED_BOLD()+"Failed Operation!"+ ConsoleColors.RESET());
            sc.nextLine();
        }
    }

    private static void handleFactorial(){
        try {
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter number: "+ConsoleColors.RESET());
            int num = sc.nextInt();

            UIUtil.showLoading(ConsoleColors.YELLOW()+"\nCalculating"+ConsoleColors.RESET());
            BigInteger result = Calculation.factorial(num);

            System.out.printf(ConsoleColors.BLUE_BOLD()+"Factorial of %d is: %d%n"+ConsoleColors.RESET(), num,result);
            UIUtil.pause(500);
        } catch (Exception e){
            System.out.println(ConsoleColors.RED_BOLD()+"Failed Operation!"+ ConsoleColors.RESET());
            sc.nextLine();
        }
    }

    private static void handleInterestCalc(){
        try {
            System.out.println(ConsoleColors.GREEN()+"""
                    Select from:
                    *Compound Interest (c)
                    *Simple Interest (s)"""+ConsoleColors.RESET());

            System.out.print(ConsoleColors.WHITE_BOLD()+"\nEnter c/s: "+ConsoleColors.RESET());
            String ch = sc.next().toUpperCase();

            double result = 0;
            if (ch.equals("C")){
                result = Calculation.compInterest(sc);
            } else if (ch.equals("S")){
                result = Calculation.simpInterest(sc);
            } else {
                System.out.println(ConsoleColors.RED_BOLD()+"ERROR: Invalid Input!"+ ConsoleColors.RESET());
            }

            System.out.printf(ConsoleColors.BLUE_BOLD()+"Amount: %.2f%n"+ConsoleColors.RESET(), result);
            UIUtil.pause(500);
        } catch (Exception e){
            System.out.println(ConsoleColors.RED_BOLD()+"Failed Operation!"+ ConsoleColors.RESET());
            sc.nextLine();
        }
    }

    private static void exitApp(){
        System.out.println(ConsoleColors.SILVER_BOLD()+"\nThank You for using our calculator.\nHave a Good Day :)\n"+ConsoleColors.RESET());
        sc.close();
    }
}