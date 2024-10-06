import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
        private static final byte PERCENT = 100;
        private static final byte MONTHS_IN_YEAR = 12;
        private static Scanner scanner = new Scanner(System.in);


    // public static long principal() {
    //      // principal
    //     System.out.println("Principal: ");
    //     return scanner.nextLong();
    // }
    public static long principal() {
        System.out.println("Principal (default 100,000): ");
        String input = scanner.nextLine();

        // Check if the user input is empty
        if (input.isEmpty()) {
            return 100000; // Default value
        }

    // Parse and return the user input if provided
    return Long.parseLong(input);
}

    public static float interest() {
        System.out.println("Annual Interest Rate (default 5.0%): ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            return 5.0f / PERCENT / MONTHS_IN_YEAR; // Default rate: 5%
        }

        float annualRate = Float.parseFloat(input);
        return annualRate / PERCENT / MONTHS_IN_YEAR;
    }


    public static int period() {
        System.out.println("Period (years, default 30): ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            return 30 * MONTHS_IN_YEAR; // Default period: 30 years
        }

        int years = Integer.parseInt(input);
        return years * MONTHS_IN_YEAR;
    }


    public static float calculator(long principal, double period, double rate) {
    // Calculate the monthly payment (m) using the formula
    float m = (float) (principal * (rate * Math.pow(1 + rate, period)) / (Math.pow(1 + rate, period) - 1));

    return m;
}

    public static void main(String[] args) {
        long principal = principal();
        double period = period();
        double rate = interest();
        float mortgage = calculator(principal, period, rate);

        String payment = NumberFormat.getCurrencyInstance().format(mortgage);
       
        System.out.println("your mortgage: " + payment);
        scanner.close();


   } 
}
