package codetest;

import java.util.Formatter;

public class FixedPaymentForID {

    public FixedPaymentForID() {

    }

    // Method to create a new Prospect object from the information of a prospect corresponding to the argument prospectID.
    // the information is retrieved from the connected prospects database table
    public void calcFixedMonthlyPaymentFor(int prospectID) {
        JDBC jdbc = new JDBC();
        MortagePlanner mp = new MortagePlanner();


        String customer = jdbc.returnSqlQuery("SELECT name from prospects where id = " + prospectID, "name" );
        String totLoanSTR = jdbc.returnSqlQuery("SELECT totalLoan from prospects where id = " + prospectID, "totalLoan");
        String interestYrSTR = jdbc.returnSqlQuery("SELECT interest_yr from prospects where id = " + prospectID , "interest_yr");
        String yearsSTR = jdbc.returnSqlQuery("SELECT year from prospects where id = " + prospectID, "year" );

        Double totLoan = Double.valueOf(totLoanSTR);
        Double interestYr = Double.valueOf(interestYrSTR);
        Double years = Double.valueOf(yearsSTR);

        Prospect prospect = new Prospect(prospectID, customer, totLoan,interestYr, years);

        mp.calcFixedMontlyPayment(prospect);
        printProspect( prospect);
    }



    //print a prospect of a certain index in the prospect list
    public void printProspect(Prospect prospect) {
        MortagePlanner mp = new MortagePlanner();
        Formatter formatter = new Formatter();


        String years = "years";
        if (prospect.getYears() ==1.0) {
            years = "year";
        }

        System.out.println("****************************************************************************************************" + "\n" +
                "Prospect " + prospect.getID() + ": " + prospect.getName() + " wants to borrow "+ prospect.getTotalLoan() +" € for a period of " + prospect.getYears()+ " " + years +" and pay " + formatter.format("%.2f", mp.calcFixedMontlyPayment(prospect)) + " € each month" + "\n"+
                "****************************************************************************************************");
        formatter.close();
    }
}
