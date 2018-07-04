package webapp.db.aws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import webapp.extracao.*;


public class readDataBase {
    private static Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static  ExtracaoService ExecuteSqlQuery(Connection connect) throws Exception {
    	System.out.println("ExtracaoService ExecuteSqlQuery");
    	ExtracaoService result = new ExtracaoService();
        try {
            // This will load the MySQL driver, each DB has its own driver
            //Class.forName("com.mysql.jdbc.Driver");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select SERVC_ORD_CD, SLS_ORD_NR, PLNT_CD from dbserviceshom1.servc_ord ");
            result = writeResultSet(resultSet);
            return result;
        } catch (Exception e) {
        	System.out.println(e.toString());
            throw e;
        } finally {
            close(connect);
        }
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private static ExtracaoService writeResultSet(ResultSet resultSet) throws SQLException {
    	System.out.println("ExtracaoService writeResultSet");
    	ExtracaoService result = new ExtracaoService();
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String field1 = resultSet.getString(1);
            String field2 = resultSet.getString(2);
            String field3 = resultSet.getString(3);
            //Date date = resultSet.getDate("datum");
            //String comment = resultSet.getString("comments");
            System.out.println("field1: " + field1 + "field2: " + field2 + "field3: " + field3);
            result.addServiceOrder(new ServiceOrder(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
        }
        return result;
    }

    // You need to close the resultSet
    private static void close(Connection connect) {
    	System.out.println("ExtracaoService close");
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
        	System.out.println(e.toString());
        }
    }

}
