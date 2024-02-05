package com.AddBooks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

public class AddingBook {
    Scanner sc = new Scanner(System.in);

    public void AddBooks() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String sql = "insert into books(book_id, category, name, author, copies) values(?, ?, ?, ?, ?)";
            System.out.println("Enter the Book Id");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer for Book Id.");
                sc.nextLine();
            }
            int Book_Id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the category of the book");
            String Category = sc.nextLine();
            System.out.println("Enter the book name");
            String Book_Name = sc.nextLine();
            System.out.println("Enter Author name");
            String Author = sc.nextLine();
            System.out.println("Enter the number of copies");
            String Copies = sc.nextLine();

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Book_Id);
            st.setString(2, Category);
            st.setString(3, Book_Name);
            st.setString(4, Author);
            st.setString(5, Copies);
            int affectedRows = st.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Book added successfully");
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
