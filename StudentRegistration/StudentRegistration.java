package com.StudentRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

public class StudentRegistration {
    Scanner sc = new Scanner(System.in);

    public void SignUp() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";
        String sql = "insert into student(sid, susername, spassword, contact, email) values (?, ?, ?, ?, ?)";
        System.out.println("Enter Student ID");
        int StudentId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student username");
        String Username = sc.nextLine();
        System.out.println("Enter Password");
        String password = sc.nextLine();
        System.out.println("Enter contact number");
        String contact = sc.nextLine();
        System.out.println("Enter email");
        String email = sc.nextLine();
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, StudentId);
            st.setString(2, Username);
            st.setString(3, password);
            st.setString(4, contact);
            st.setString(5, email);
            int affectedRows = st.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Student Registration Successful");
            } else {
                System.out.println("Student account already exists.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate entry detected. Please try entering different values for Book Id.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
