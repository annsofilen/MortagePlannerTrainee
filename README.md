<h1>Mortage Planner</h1>

<h2>Project Description</h2>

<p>The Mortage Planner is a Java project able to calculate the exact amount a customer of Money Bin Inc. is required to pay each month over a period of time after having taking a loan. In order to calculate the monthly payment, the user is required to input the desired total amount of the loan, the yearly interest and the time duration of the loan. The calculation follows the formula </p>



   <p>     E = U[ b(1 + b)^p ] / [ (1 + b)^p - 1 ] ,</p>
    <p> where</p>
    <p>   b = interest on a monthly basis</p>
    <p>  U = total loan</p>
    <p>   p = number of payments and</p>
    <p>   E = fixed monthly payments </p>

****
<p>The Mortage Planner programme is written in Java and uses the build tool Maven. The loan prospects can be read into the programme from a text file by reading it into the class main.java. In order to calculate the monthly payments for a customer, one inputs the database ID of the customer in question, and the monthly payments of the customer is printed to the console.  </p>

<p>A JDBC connector is used to connect all prospects to a MySQL database.
The programme is tested using the test framework Junit 4.</p>

****
<p>Future improvements of the project includes a web interface, for example built in the JavaScript framework React. In order to connect the React frontend to the Java programme, it would be interesting to build an API using the Spring boot Java framework.</p>

****

<h2>Java Classes</h2>


<h4>Main.java</h4> 
<p>The class Main.java is where the user selects for which prospect the fixed monthly payment is calculated. The Main.java class contains the possibility to insert new prospects from a text file into the database. </p>

<h4>Prospect.java </h4>

<p>The class Prospect.java that describes the prospects who wish to make a loan from the bank. The class has private instance variables for the name of the prospect and prospectID, the total sum of the loan, the yearly interest rate and the time period for the loan in years.</p>

<h4>MortagePlanner.java</h4>

<p>The class MortagePlanner.java is where the calculations take place. It contains methods for determining the time period of the loan in months, for determining the monthly interest rate (in decimals) for calculating exponent expressions, and lastly for calculating the fixed amount a customer has to pay each month over a period of time after borrowing money from a bank.</p>

<h4>Filereader.java</h4>

<p>The class Filereader.java is the class used for handling text file insertions into the prospects database table. The method reads input from a file. The input file is required to have a first line of representing headings for each column. All fields are separated by "," commas.

The fields of the file should be Customer, TotalLoan, YearlyInterest, Year.

The class is able to handle some format variations, such as a first and last name mistakenly separated by "," or unintended quotation marks and dots.</p>

<h4>JDBC.java</h4>

<p>The class JDBC.java handles the connection to the local MySQL database. The class contains two methods, one for taking data from the database, and another for inserting data to the database from a file.</p>

<h4>FixedPaymentForID.java</h4>

<p>The class FixedPaymentForID.java contains logic for creating a new Prospect object, and for calling the mortage calculations found in the MortagePlanner.java class on the object . The main purpose of the class is to hide application logic from the Main.java class.</p>