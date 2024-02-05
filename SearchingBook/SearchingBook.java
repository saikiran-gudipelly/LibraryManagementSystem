package com.SearchingBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SearchingBook {
    Scanner sc = new Scanner(System.in);

    public void searchBooks() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";

        String sql = "SELECT book_id, category, name, author, copies FROM books WHERE name = ?";

        try (

                Connection connection = DriverManager.getConnection(url, user, pass);

                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            System.out.println("Enter the name of the book");
            String name = sc.nextLine();

            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {

                    System.out.println("Book ID: " + resultSet.getInt("book_id"));
                    System.out.println("Category: " + resultSet.getString("category"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Author: " + resultSet.getString("author"));
                    System.out.println("Copies: " + resultSet.getInt("copies"));
                } else {
                    System.out.println("Book not found.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
