package com.RemoveBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;
import java.sql.DriverManager;

public class RemovingBooks {
    Scanner sc = new Scanner(System.in);

    public void RemovBooks() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String sql = "delete from books where book_id = ? and name = ?";

            System.out.println("Enter the Book Id");
            int Book_Id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Book Name");
            String Book_Name = sc.nextLine();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Book_Id);
            st.setString(2, Book_Name);
            int affectedRows = st.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Book Deleted successfully");
            } else {
                System.out.println("Book doesen't exist in the database");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate entry detected. Please try entering different values for Book Id.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
