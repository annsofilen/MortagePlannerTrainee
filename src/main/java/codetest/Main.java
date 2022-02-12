package codetest;

public class Main {
    public static void main (String args[]) {


        /*------------------------------INSERT DATA FROM A FILE-------------------------------------------------------*/

        //FileReader fr = new FileReader();

        // if you have a new file from which you want to insert data to the prospects database table,
        // insert the link to the file inside quotation marks
        //fr.readFile("src/evenMoreProspects.txt");

        /*------------------------------CALCULATE FIXED MONTHLY PAYMENTS----------------------------------------------*/

        FixedPaymentForID fixedPayment = new FixedPaymentForID();

        // set the integer ID for the prospect you want to retrieve from the database
        fixedPayment.calcFixedMonthlyPaymentFor(4);
    }
}
