package _06_payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
        //given
    	double hourlyWage = 1.5;
    	int numhours = 10;
    	double expected = 15;
    	
        //when
    	double actual = payroll.calculatePaycheck(hourlyWage, numhours);
    	
        //then
    	assertEquals(expected, actual);
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given
    	int milesTraveled = 10;
    	double expected = 5.75;
    	
        //when
    	double actual = payroll.calculateMileageReimbursement(milesTraveled);
    	
        //then
    	assertEquals(expected, actual);
    }

    @Test
    void itShouldCreateOfferLetter() {
        //given
    	String employeeName = "Bob";
    	double hourlyWage = 1.5;
    	String expected = "Hello Bob, We are pleased to offer you an hourly wage of 1.5";
    	
        //when
    	String actual = payroll.createOfferLetter(employeeName, hourlyWage);
    	
        //then
    	assertEquals(expected, actual);
    }

}