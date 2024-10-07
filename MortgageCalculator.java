import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    private static Scanner scanner = new Scanner(System.in);

    public static double calculator(int principal, float annualInterest, byte years) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
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

    public static void main(String[] args) {
        int principal = (int) getValue("Principal (€1k - €1M): ", 1000, 1_000_000, scanner);
        float annualInterest = (float) getValue("Annual Interest Rate: ", 1.0, 3.0, scanner);
        byte years = (byte) getValue("Years: ", 1, 30, scanner);

        double mortgage = calculator(principal, annualInterest, years);

        String payment = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Monthly Payments: " + payment + "\n");

        scanner.close();
    }
}
