package codetest;


public class MortagePlanner {

    //constructor
    public MortagePlanner() {

    }


    //calculate an exponential expression
    public double powerOf(double base, double power){
        if(power == 0) {
            return 1;
        }
        return base * powerOf(base, --power);
    }

    //calculate the monthly interest from a Prospect object
    //does not allow for a negative interest
    public double calcMonthlyInterest(Prospect prospect) {
        double monthlyInterest = prospect.getInterest() / 100 / 12;
        if (monthlyInterest < 0) {
            return 0.0;
        }
        return monthlyInterest;
    }

    //calculate the number of months the prospect is required to pay off the loan
    //does not allow for a negative value for the time input
    public double calcNumberOfMonths(Prospect prospect) {
        double numberOfMonths = prospect.getYears() * 12;
        if (numberOfMonths <0 ) {
            return 0;
        }
        return numberOfMonths;
    }

    //method for calculating the fixed monthly payment for a Prospect object
    //
    // b = interest on a monthly basis
    // U = total loan
    // p = number of payments
    // E = fixed monthly payments. to be calculated
    // formula:
    // E = U[b(1 + b)^p]/[(1 + b)^p - 1]

    public double calcFixedMontlyPayment(Prospect prospect) {
        double b = calcMonthlyInterest(prospect);
        double U = prospect.getTotalLoan();
        double p = calcNumberOfMonths(prospect);
        double E = 0.0;
        double powerOfExpression = powerOf(1 + b, p);

        E = U * ((b * powerOfExpression) / (powerOfExpression - 1));
        return E;

    }


}

