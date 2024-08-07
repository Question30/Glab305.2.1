package org.example;

import java.sql.*;

public class Update_preparesSt_Example {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String dburl = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root";
        String password = "password";

        try{
            con = DriverManager.getConnection(dburl, user, password);
            System.out.println("Connection established successfully!");
            String sql = "UPDATE employees SET firstName=? , lastName=? WHERE" +
                    " employeeNumber = ?";

            prepStmt = con.prepareStatement(sql);
            prepStmt.setString(1, "Gary");
            prepStmt.setString(2, "Larson");
            prepStmt.setLong(3, 0003);

            int rowsAffected = prepStmt.executeUpdate();

            prepStmt = con.prepareStatement("SELECT * FROM employees WHERE " +
                    "employeeNumber=?");
            prepStmt.setInt(1, 1401);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("firstName"));
                System.out.println(rs.getString("lastName"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("officeCode"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
