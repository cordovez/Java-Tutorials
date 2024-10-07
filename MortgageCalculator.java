import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int principal = (int) getValue("Principal (€1k - €1M): ", 1000, 1_000_000, scanner);
        float annualInterest = (float) getValue("Annual Interest Rate: ", 1.0, 3.0, scanner);
        byte years = (byte) getValue("Years: ", 1, 30, scanner);

        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        printPayment(principal, numberOfPayments, monthlyInterest);
        printBalance(principal, numberOfPayments, monthlyInterest);
    }

    public static double paymentCalculator(int principal, float monthlyInterest, int numberOfPayments) {
        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
    }

    public static double balanceCalculator(int principal, float monthlyInterest, int numberOfPayments) {
        int count = 0;
        double balance = 0;
        while (count <= numberOfPayments) {
            balance = (principal
                    * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, count)))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
            count++;
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
        return balance;
    }

    public static double getValue(String message, double min, double max, Scanner scanner) {
        double value;
        while (true) {
            System.out.print(message);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Please use a value between " + min + " and " + max);
        }
        return value;
    }

    public static void printBalance(int principal, int numberOfPayments, float monthlyInterest) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        balanceCalculator(principal, monthlyInterest, numberOfPayments);
        scanner.close();
    }

    public static void printPayment(int principal, int numberOfPayments, float monthlyInterest) {
        double mortgage = paymentCalculator(principal, monthlyInterest, numberOfPayments);
        String payment = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + payment + "\n");
    }
}
