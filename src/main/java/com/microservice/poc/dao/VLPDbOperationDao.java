package com.microservice.poc.dao;

import com.microservice.poc.domain.PersonLawfulDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class VLPDbOperationDao extends AbstractDao<PersonLawfulDetail> {

    // JDBC driver name and database URL
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:mem:microservice-pocdb;DB_CLOSE_DELAY=-1";

    //  Database credentials
    final String USER = "sa";
    final String PASS = "sa";

    @Autowired
    @Override
    public void setDataSource(@Qualifier(value = "h2DS") DataSource dataSource) {

    }

    @Override
    public PersonLawfulDetail create(PersonLawfulDetail personLawfulDetail) {
        {
            Connection conn = null;
            Statement stmt = null;
            try {
                // STEP 1: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                // STEP 2: Open a connection
                System.out.println("Connecting to a selected database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connected database successfully...");

                // STEP 3: Execute a query
                stmt = conn.createStatement();
                String sql = "INSERT INTO Registration " + "VALUES (100, 'Zara', 'Ali', 18)";

                stmt.executeUpdate(sql);
                sql = "INSERT INTO Registration " + "VALUES (101, 'Mahnaz', 'Fatma', 25)";

                stmt.executeUpdate(sql);
                sql = "INSERT INTO Registration " + "VALUES (102, 'Zaid', 'Khan', 30)";

                stmt.executeUpdate(sql);
                sql = "INSERT INTO Registration " + "VALUES(103, 'Sumit', 'Mittal', 28)";

                stmt.executeUpdate(sql);
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

            return personLawfulDetail;
        }
    }
}
