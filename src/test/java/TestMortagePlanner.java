import codetest.MortagePlanner;
import codetest.Prospect;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

//import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;


public class TestMortagePlanner {
    Prospect prospect = new Prospect(1, "Jon Testsson", 80000, 5, 10);
    MortagePlanner mortagePlanner = new MortagePlanner();


    @Test
    @DisplayName("Test for the method powerOf in class MortagePlanner")
    public void testPowerOf() {
        double powerOf = mortagePlanner.powerOf(2.0, 2.0 );
        System.out.println("Power of should be: " + 4.0 + ", \n" + "Power of was: " + powerOf +"\n");
        assertEquals(4.0, powerOf,  0.0);

        double powerOf2 = mortagePlanner.powerOf(2.0, 0.0 );
        System.out.println("Power of should be: " + 1.0 + ", \n" + "Power of was: " + powerOf2 +"\n");
        assertEquals(1.0, powerOf2,  0.0);
    }

    @Test
    @DisplayName("Test for the method for monthly interest calculation in class MortagePlanner. Negative monthly interest is not allowed")
    public void testCalcMonthlyInterest() {
        double monthlyInterest = mortagePlanner.calcMonthlyInterest(prospect);
        double assertedMonthlyInterest = 0.004166666666666666666;
        System.out.println("Monthly interest should be: " + assertedMonthlyInterest + ", \n" + "Monthly interest was: " + monthlyInterest +"\n");
        assertEquals(assertedMonthlyInterest, monthlyInterest, 0.0);

        prospect = new Prospect(10, "Jon Testsson", 80000, -1, 10);
        double monthlyInterestNegative = mortagePlanner.calcMonthlyInterest(prospect);
        double assertedMonthlyInterestNegative = 0.0;
        System.out.println("If negative interest, monthly interest should be: " + assertedMonthlyInterestNegative + ", \n" + "Monthly interest was: " + monthlyInterestNegative +"\n");
        assertEquals(assertedMonthlyInterestNegative, monthlyInterestNegative, 0.0);
    }

    @Test
    @DisplayName("test number of months")
    public void testCalcNumberOfMonths() {
        double numberOfMonths = mortagePlanner.calcNumberOfMonths(prospect);
        System.out.println("Number of months should be: " + 120 + ", \n" + "Number of months were: " + numberOfMonths +"\n");
        assertEquals((120), numberOfMonths, 0.0);

        Prospect prospect2 = new Prospect(2, "Isak", 80000 , 2, -1);
        double numberOfMonths2 = mortagePlanner.calcNumberOfMonths(prospect2);
        System.out.println("Number of months should be: " + 0.0 + ", \n" + "Number of months were: " + numberOfMonths2 +"\n");
        assertEquals((0.0), numberOfMonths2, 0.0);
    }

    @Test
    @DisplayName("calculate monthly fixed payment")
    public void testCalcFixedMontlyPayment() {
        double E = mortagePlanner.calcFixedMontlyPayment(prospect);
        System.out.println("Mortage should be: " + 848.50 + ", \n" + "Number of months were: " + E +"\n");
        assertEquals((848.5), E, 1);
    }

}
