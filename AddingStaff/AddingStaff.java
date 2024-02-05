package com.AddingStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddingStaff {
    Scanner sc = new Scanner(System.in);

    public void AddStaff() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String sql = "insert into staff(sid, susername, spassword, contact, email) values(?, ?, ?, ?, ?)";
            System.out.println("Enter the Staff Id");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer for Book Id.");
                sc.nextLine();
            }
            int Staff_Id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Username");
            String Username = sc.nextLine();
            System.out.println("Enter Password");
            String Password = sc.nextLine();
            System.out.println("Enter Contact Number");
            String Contact = sc.nextLine();
            System.out.println("Enter Email Address");
            String Email = sc.nextLine();

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Staff_Id);
            st.setString(2, Username);
            st.setString(3, Password);
            st.setString(4, Contact);
            st.setString(5, Email);
            int affectedRows = st.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Staff member successfully");
            } else {
                System.out.println("Something went wrong please try again.");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate entry detected. Please try entering different values for Book Id.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
