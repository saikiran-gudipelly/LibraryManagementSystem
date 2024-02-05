package com.EditAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EditAdmin {
    Scanner sc = new Scanner(System.in);

    public void editAdmin() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            int adminIdToUpdate = 1;
            System.out.println("Enter new admin username");
            String newUsername = sc.nextLine();
            System.out.println("Enter new admin password");
            String newPassword = sc.nextLine();
            System.out.println("Enter new admin contact number");
            String newContact = sc.nextLine();
            System.out.println("Enter new admin email address");
            String newEmail = sc.nextLine();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                try (Connection connection = DriverManager.getConnection(url, user, pass)) {
                    String updateQuery = "UPDATE admin SET ausername=?, apassword=?, contact=?, email=? WHERE aid=?";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                        preparedStatement.setString(1, newUsername);
                        preparedStatement.setString(2, newPassword);
                        preparedStatement.setString(3, newContact);
                        preparedStatement.setString(4, newEmail);
                        preparedStatement.setInt(5, adminIdToUpdate);
                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            System.out.println("Admin details updated successfully!");
                        } else {
                            System.out.println("No admin found with the specified ID.");
                        }
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}