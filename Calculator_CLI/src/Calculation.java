import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class Calculation {
    public Calculation() {}

    public static double add(Scanner sc) {
        double sum = 0;

        try {
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter count of numbers: "+ConsoleColors.RESET());
            int count = sc.nextInt();

            for (int i = 1; i <= count; i++) {
                System.out.print(ConsoleColors.WHITE_BOLD()+ "Enter number " + i + ": "+ConsoleColors.RESET());
                sum += sc.nextDouble();
            }

            UIUtil.showLoading(ConsoleColors.YELLOW()+"\nAdding"+ConsoleColors.RESET());
            return sum;

        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD() + "ERROR: Invalid input!" + ConsoleColors.RESET());
            sc.nextLine();
        }
        return sum;
    }


    public static double subtract(double a, double b){
        double diff = a-b;
        UIUtil.showLoading(ConsoleColors.YELLOW()+"\nSubtracting"+ConsoleColors.RESET());
        return diff;
    }

    public static double multiply(double a, double b){
        double result = a*b;
        UIUtil.showLoading(ConsoleColors.YELLOW()+"\nMultiplying"+ConsoleColors.RESET());
        return result;
    }

    public static double divide(double a, double b){
        double result = a/b;
        UIUtil.showLoading(ConsoleColors.YELLOW()+"\nDividing"+ConsoleColors.RESET());
        return result;
    }

    public static double exponent(double base, double power){
        double result = 1;

        UIUtil.showLoading(ConsoleColors.YELLOW()+"\nCalculating"+ConsoleColors.RESET());
        for (int i=0; i<power; i++){
            result *= base;
        }

        return result;
    }

    public static double percentOf(double percent, double value){
        UIUtil.showLoading(ConsoleColors.YELLOW()+"\nCalculating"+ConsoleColors.RESET());

        return (percent/100)*value;
    }

    public static BigInteger factorial(int n){
        if (n<0) throw new IllegalArgumentException(ConsoleColors.RED()+"n should be >= 0"+ConsoleColors.RESET());

        if (n==0){
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }

    public static double compInterest(Scanner sc){
        System.out.print(ConsoleColors.WHITE_BOLD()+"Enter principal: "+ConsoleColors.RESET());
        double p = sc.nextDouble();
        System.out.print(ConsoleColors.WHITE_BOLD()+"Enter rate of interest: "+ConsoleColors.RESET());
        double r = sc.nextDouble();
        System.out.print(ConsoleColors.WHITE_BOLD()+"Enter no. of times interest compounded: "+ConsoleColors.RESET());
        int n = sc.nextInt();
        System.out.print(ConsoleColors.WHITE_BOLD()+"Enter time[in year(s)]: "+ConsoleColors.RESET());
        int t = sc.nextInt();

        return p + exponent((1+(r/n)), (n*t));
    }

    public static double simpInterest(Scanner sc){
        System.out.print(ConsoleColors.WHITE_BOLD()+"Enter principal: "+ConsoleColors.RESET());
        double p = sc.nextDouble();
        System.out.print(ConsoleColors.WHITE_BOLD()+"Enter rate of interest: "+ConsoleColors.RESET());
        double r = sc.nextDouble();
        System.out.print(ConsoleColors.WHITE_BOLD()+"Enter time[in year(s)]: "+ConsoleColors.RESET());
        int t = sc.nextInt();

        double a = p*r*t;

        UIUtil.showLoading(ConsoleColors.YELLOW()+"\nCalculating"+ConsoleColors.YELLOW());
        return a;
    }
}
