package codetest;


import java.io.File;
import java.util.Scanner;

//read
public class FileReader {

    public FileReader() {

    }
    //create a new MortagePlanner object and a new JDBC object
    MortagePlanner mp = new MortagePlanner();
    JDBC jdbc = new JDBC();

    //read text file, add new prospects into the prospects database
    public void readFile(String file) {
        Scanner scan;
        try {
            scan = new Scanner(new File(file));
            String firstLine = scan.nextLine();

            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                String[] parts = line.split(",");
                if (parts.length == 5 ) {
                    String customer = parts[0] +" " + parts[1];
                    customer = customer.replaceAll("\"", "");
                    double totLoan = Double.valueOf(parts[2]);
                    double interest = Double.valueOf(parts[3]);
                    double years = Double.valueOf(parts[4]);

                    jdbc.insertProspect(customer, totLoan, interest, years);

                } else if (parts.length == 4) {
                    String customer = parts[0];
                    customer = customer.replaceAll("\"", "");
                    double totLoan = Double.valueOf(parts[1]);
                    double interest = Double.valueOf(parts[2]);
                    double years = Double.valueOf(parts[3]);

                    jdbc.insertProspect(customer, totLoan, interest, years);
                } else {
                    continue;
                }
            }
            scan.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }





}
