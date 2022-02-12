package codetest;

public class Prospect {
    private int ID;
    private String name;
    private double totalLoan;
    private double interest;
    private double years;

    public Prospect(int ID, String name, double totalLoan, double interest, double years) {
        this.ID = ID;
        this.name = name;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;

    }


    //getters: collect private instance variables
    public int getID() { return ID;}

    public String getName() {
        return name;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getInterest() {
        return this.interest;
    }

    public double getYears() {
        return years;
    }


    //setters: update private instance variables
    public void setName(String name) {
        this.name = name;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setYears(double years) {
        this.years = years;
    }

}

