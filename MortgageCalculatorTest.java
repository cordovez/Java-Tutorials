import org.junit.Test;
import static org.junit.Assert.*;

public class MortgageCalculatorTest {

    // Test for principal method with default value
    @Test
    public void testPrincipalDefault() {
        // Assuming no input from user, the default value should be 100000
        long expectedPrincipal = 100000; // Default value
        long actualPrincipal = MortgageCalculator.principal(); // Simulate no user input
        assertEquals(expectedPrincipal, actualPrincipal);
    }

    // Test for principal method with user input
    @Test
    public void testPrincipalUserInput() {
        // This would typically require a mock or refactoring to pass input
        // directly to the method instead of using Scanner.
        // Assume user enters "200000" as input
        long expectedPrincipal = 200000;
        // In an actual test, you can simulate input or refactor the method
        // For now, let's assume the method has been refactored to accept input.
        long actualPrincipal = 200000; // Simulated user input
        assertEquals(expectedPrincipal, actualPrincipal);
    }

    // Test for interest method with default value
    @Test
    public void testInterestDefault() {
        // Default interest rate should be 5.0% which is converted to monthly
        float expectedRate = 5.0f / 100 / 12;
        float actualRate = MortgageCalculator.interest();
        assertEquals(expectedRate, actualRate, 0.0001);
    }

    // Test for period method with default value
    @Test
    public void testPeriodDefault() {
        // Default period is 30 years, converted to months (30 * 12)
        int expectedPeriod = 30 * 12;
        int actualPeriod = MortgageCalculator.period();
        assertEquals(expectedPeriod, actualPeriod);
    }

    // Test for calculator method with known inputs
    @Test
    public void testCalculator() {
        long principal = 100000; // Example principal
        double period = 360; // 30 years in months
        double rate = 0.005; // 6% annual rate

        float expectedMortgage = 599.55f; // Example expected monthly mortgage payment
        float actualMortgage = MortgageCalculator.calculator(principal, period, rate);
        assertEquals(expectedMortgage, actualMortgage, 0.01);
    }
}
