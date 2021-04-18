package com.emplyeepayrollservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    public enum IOService{ CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

    public EmployeePayrollService() {}

     public EmployeePayrollService(List<EmployeePayrollData>
                                   employeePayrollData){
    }

    ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    public static void main(String []args0){
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
    }

    private void readEmployeePayrollData(Scanner consoleInputReader){
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    public void writeEmployeePayrollData(IOService consoleIo){
        if(consoleIo.equals(IOService.CONSOLE_IO))
        System.out.println("\nWriting Employee Payroll Roaster to Console\n"+employeePayrollList);
        else if(consoleIo.equals(IOService.FILE_IO))
            new PayRollFileIO().writeDataToAFile(employeePayrollList);
    }

    public void printData(IOService consoleIo) {
        if(consoleIo.equals(IOService.FILE_IO))
            new PayRollFileIO().printData();
    }

    public long countEntries(IOService consoleIo) {
        if(consoleIo.equals(IOService.FILE_IO));
        return new PayRollFileIO().countEntries();
    }
}
