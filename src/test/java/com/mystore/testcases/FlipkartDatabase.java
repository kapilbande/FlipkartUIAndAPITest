package com.mystore.testcases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class FlipkartDatabase {

        public String getSecondHighestPricedProduct() {
            try (Connection conn = DriverManager.getConnection("your_db_connection_string", "username", "password");
                 Statement stmt = conn.createStatement()) {

                String query = "SELECT ProductName FROM products " +
                        "ORDER BY ProductPrice DESC " +
                        "LIMIT 1, 1"; // Offset to get the second result

                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()) {
                    return rs.getString("ProductName");
                }

            } catch (Exception e) {
                // Handle database exceptions
                e.printStackTrace();
            }
            return null;
        }
    }

