package partTwo;

public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.getValue("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.getValue("Annual Interest: ", 1, 5);
        byte years = (byte) Console.getValue("Period (years)", 1, 30);

        // an overloaded class. Here passing values
        var calculator = new MortgageCalculator(principal, annualInterest, years);
        // here passing the instance with values baked in.
        var report = new MortgageReport(calculator);

        report.printPayment();
        report.printBalance();

    }

}
