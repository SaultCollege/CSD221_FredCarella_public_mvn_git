/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture4b_jdbc.mysql;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author fcarella
 */
public class Main {

    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static void main(String[] args) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/try1?"
                            + "user=root&password=itstudies123");
            // Statements allow to issue SQL queries to the database
      statement = (Statement) connect.createStatement();
      // PreparedStatements can use variables and are more efficient
      preparedStatement = (PreparedStatement) connect
          .prepareStatement("insert into  try1.Publication ("+
                    "title," +
                    "price," +
                    "copies) values (?, ?, ?)"
      );
      // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setString(1, "Title1");
      preparedStatement.setDouble(2, 4.50);
      preparedStatement.setInt(3, 5);
      preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }
// You need to close the resultSet

    private static void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
