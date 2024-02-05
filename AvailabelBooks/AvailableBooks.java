package com.AvailabelBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class AvailableBooks {
    public void availableBooks() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";

        try (Connection con = DriverManager.getConnection(url, user, pass);
                PreparedStatement st = con.prepareStatement("SELECT * FROM books");
                ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                int bookId = rs.getInt(1);
                String category = rs.getString(2);
                String bookName = rs.getString(3);
                String author = rs.getString(4);
                int copies = rs.getInt(5);

                System.out.println("Book Id = " + bookId +
                        ", Category = " + category +
                        ", Book Name = " + bookName +
                        ", Author = " + author +
                        ", Copies = " + copies);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
