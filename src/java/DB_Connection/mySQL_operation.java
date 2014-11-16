package DB_Connection;

//STEP 1. Import required packages
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;

public class mySQL_operation {

    //JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/emp";

    //DB credentails
    static final String USER = "root";
    static final String PASS = "123456";

    //creating connection , statment and Resulteset
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    //string to carry your query
    String sql_query = "";

    public mySQL_operation() {
        try {
            //STEP 2: Register JDBC driver
            //And load the JDBC connector/driver to the momery
            Class.forName(JDBC_DRIVER);//don't forget to add connector.jar for every databaseserver ^_^
            //STEP 3: Open a connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 4: Execute a query
            //we can use PreparedStatment for more Security Issues 
            stmt = con.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Error");
        } catch (SQLException ex) {
            System.out.println("Connection Error");
        }
    }

    //Selecting by id 
    Employee select_by_ID(int ID) {

        int age = 0;
        String Fname = null, Lname = null;

        Employee emp = null;
        sql_query = "select * from employees where id = " + ID + ";";
        try {
            // for using select query we use stmt.executeQuery(sql_query)
            rs = stmt.executeQuery(sql_query);

            //STEP 5: Extract data from result set
            //while (rs.next()) {
            rs.next();
                age = rs.getInt("age");
                Fname = rs.getString("first");
                Lname = rs.getString("last");
            //}
            emp = new Employee(age, ID, Fname, Lname);

        } catch (SQLException ex) {
            System.out.println("Selection Error");
        }
        return emp;
    }

    //Select all records
    void select_all() {
        int id, age;
        String first, last;
        sql_query = "select * from employees ;";

        try {
            // for using select query we use stmt.executeQuery(sql_query)
            rs = stmt.executeQuery(sql_query);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                id = rs.getInt("id");
                age = rs.getInt("age");
                first = rs.getString("first");
                last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
        } catch (SQLException ex) {
            System.out.println("Selection Error");
        }
    }

    //inserting data
    void insert(int id, int age, String first, String last) {
        try {
            sql_query = "insert into employees (id, age, first, last) values(" + id
                    + "," + age
                    + ", '" + first + "' , '" + last + "' );";
            stmt.executeUpdate(sql_query);
        } catch (SQLException ex) {
            System.out.println("Insertion Error");
        }
    }

    //Deleting record by ID
    void delete_by_ID(int ID) {
        sql_query = "Delete from employees where id = " + ID;
        try {
            stmt.executeUpdate(sql_query);
        } catch (SQLException ex) {
            System.out.println("Deleting Error");
        }
    }

    //Deleting all records
    void delete_all() {
        sql_query = "Delete from employees";
        try {
            stmt.executeUpdate(sql_query);
        } catch (SQLException ex) {
            System.out.println("Deleting Error");
        }
    }

    //don't forget to close the DB connection
    //STEP 6: Clean-up environment
    void close_connection() {
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Close done");
        }
    }

}
