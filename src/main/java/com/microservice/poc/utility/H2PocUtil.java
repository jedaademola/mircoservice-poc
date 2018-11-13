package com.microservice.poc.utility;

import com.microservice.poc.domain.PersonLawfulDetail.AdditionalLawfulDetail;
import com.microservice.poc.domain.PersonLawfulDetail.PersonLawfulDetail;
import com.microservice.poc.domain.TwoParam;

import java.sql.*;
import java.util.List;

public class H2PocUtil {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:microservice-pocdb;DB_CLOSE_DELAY=-1";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "sa";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // createTable(); //TODO run ONCE

        createTablePersonLawfulDetail();

        //  insertIntoDb ();

        // read();

        // update();

    }

    public static void delete() throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        Statement stmt = null;
        try {

            // STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "DELETE FROM Registration " + "WHERE id = 101";
            stmt.executeUpdate(sql);

            // Now you can extract all the records
            // to see the remaining records
            sql = "SELECT id, first, last, age FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }

    public static void update() throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        Statement stmt = null;
        try {

            // STEP 3: Execute a query
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "UPDATE Registration " + "SET age = 30 WHERE id in (100, 101)";
            stmt.executeUpdate(sql);

            // Now you can extract all the records
            // to see the updated records
            sql = "SELECT id, first, last, age FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }

    public static TwoParam read() throws SQLException, ClassNotFoundException {
        //
        createTable();
        insertIntoDb();
        //
        Connection conn = null;
        Statement stmt = null;
        TwoParam fromDb = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT id, first, last, age FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);

                fromDb = new TwoParam();
                fromDb.setContent(first + " " + last);
                fromDb.setId(Long.valueOf(id));
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");

        return fromDb;
    }

    public static void createTable() {

        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE   REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
    }

    static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        // STEP 1: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        // STEP 2: Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");

        return conn;

    }

    public static void insertIntoDb() throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        Statement stmt = null;
        try {

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            int uuid = Utility.generateRandom(5) + 1;
            String sql = "INSERT INTO Registration " + "VALUES (" + uuid + ", 'Zara', 'Ali', 18)";

            stmt.executeUpdate(sql);
            //sql = "INSERT INTO Registration " + "VALUES (101, 'Mahnaz', 'Fatma', 25)";

            // stmt.executeUpdate(sql);
            // sql = "INSERT INTO Registration " + "VALUES (102, 'Zaid', 'Khan', 30)";

            //stmt.executeUpdate(sql);
            // sql = "INSERT INTO Registration " + "VALUES(103, 'Sumit', 'Mittal', 28)";

            //stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }

    public static void createTablePersonLawfulDetail() throws SQLException, ClassNotFoundException {

        Connection conn = getDbConnection();
        Statement stmt = null;
        try {

            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE   PersonLawfulDetail " +
                    "(id INTEGER not NULL, " +
                    " eligibilityStatementCode VARCHAR(50), " +
                    " nonCitCoaCode VARCHAR(50), " +
                    " fiveYearBarMet VARCHAR(50), " +
                    " qualifiedCitizenCode VARCHAR(50), " +
                    " lawfulPreseneCode VARCHAR(50), " +
                    " responseCode VARCHAR(50), " +
                    " caseNumber VARCHAR(50), " +
                    " agencyAction VARCHAR(50), " +
                    " status VARCHAR(50), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table PersonLawfulDetail in given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
    }

    public static void createTableAdditionalLawfulDetail() throws SQLException, ClassNotFoundException {

        Connection conn = getDbConnection();
        Statement stmt = null;
        try {

            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE   AdditionalLawfulDetail " +
                    "(id INTEGER not NULL, " +
                    " uuid VARCHAR(50), " +
                    " detailName VARCHAR(50), " +
                    " detailValue VARCHAR(50), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table AdditionalLawfulDetail in given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
    }



    public static void insertIntoPersonLawfulDetail(PersonLawfulDetail personLawfulDetail) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        Statement stmt = null;
        try {

            createTablePersonLawfulDetail();
            createTableAdditionalLawfulDetail();

            int id = Utility.generateRandom(5) + 1;
            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO PersonLawfulDetail " + "VALUES (" + id + ","
                    + personLawfulDetail.getUUID() + ","
                    + personLawfulDetail.getEligibilityStatementCode() + ","
                    + personLawfulDetail.getNonCitCoaCode() + ","
                    + personLawfulDetail.getFiveYearBarMet() + ","
                    + personLawfulDetail.getQualifiedCitizenCode() + ","
                    + personLawfulDetail.getLawfulPreseneCode() + ","
                    + personLawfulDetail.getResponseCode() + ","
                    + personLawfulDetail.getCaseNumber() + ","
                    + personLawfulDetail.getAgencyAction() + ","
                    + personLawfulDetail.getGrantDate() + ","
                    + "0"
                    + ")";
            stmt.executeUpdate(sql);

            List<AdditionalLawfulDetail> additionalLawfulDetail = personLawfulDetail.getAdditionalLawfulDetail();
            for (AdditionalLawfulDetail detail : additionalLawfulDetail) {
                int uuidDetails = Utility.generateRandom(5) + 1;
                sql = "INSERT INTO AdditionalLawfulDetail " + "VALUES ("
                        + uuidDetails + ","
                        + id + ","
                        + detail.getDetailName() + ","
                        + detail.getDetailValue() + ")";
                stmt.executeUpdate(sql);
            }


            System.out.println("Inserted records into the table PersonLawfulDetail...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }
}
