package partTwo;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double getValue(String promp) {
        return scanner.nextDouble();
    }

    public static double getValue(String message, double min, double max) {
        double value;
        while (true) {
            System.out.print(message);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Please use a value between " + min + " and " + max);
        }
        return value;
    }

}
