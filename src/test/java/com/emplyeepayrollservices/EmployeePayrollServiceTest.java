package com.emplyeepayrollservices;
import org.junit.Test;
import java.util.Arrays;

public class EmployeePayrollServiceTest {
    @Test
    public void given3EmployeeWhenWrittenToFileShouldMatchEmployeeEntries(){
        EmployeePayrollData[] arrayOfEmploys = {
                new EmployeePayrollData(1,"Jeff Bezos", 10000.0),
                new EmployeePayrollData(2, "Bill Gates", 20000.0),
                new EmployeePayrollData(3,"Mark Zuckerberg", 30000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmploys));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
    }

}