package codetest;

import java.sql.*;

public class JDBC  {
    public static void main (String args[]) {}

    //Method for collecting data from the prospects table via the Java DataBase Connector
    public String returnSqlQuery(String query, String column) {
        String sqlQuery ="";
        String url = "jdbc:mysql://localhost:3306/prospectDB";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                sqlQuery = resultSet.getString(column);
            }


            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* Ignored */}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sqlQuery;

    }

    //Method for inserting data into the prospects table via the Java DataBase Connector
    public void insertProspect(String name, double totalLoan, double interestYr, double years) {
        String sqlQuery ="";
        String url = "jdbc:mysql://localhost:3306/prospectDB";
        String username = "root";
        String password = "root";
        try(Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement()) {
            // Execute a query
            String insertQuery = "INSERT INTO prospects ( name, totalLoan, interest_yr, year)  VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, totalLoan);
            preparedStatement.setDouble(3, interestYr);
            preparedStatement.setDouble(4, years);
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
            ResultSet res = preparedStatement.getGeneratedKeys();

            //Close database connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* Ignored */}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

