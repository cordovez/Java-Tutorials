package partTwo;

import java.lang.classfile.instruction.ExceptionCatch;

public class Main {
    public static void main(String[] args) {
        var employee = new Employee();
        employee.setBaseSalary(50800);
        employee.setHourlyRate(10);
        int wage = employee.calculateWage(10);
        System.out.println(wage);

    }

}
