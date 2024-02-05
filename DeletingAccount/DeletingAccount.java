package com.DeletingAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class DeletingAccount {
    Scanner sc = new Scanner(System.in);

    public void DeletAccount() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";
        String sql = "delete from student where susername = ? and spassword = ? ";
        System.out.println("Enter the Student username to remove");
        String susername = sc.nextLine();
        System.out.println("Enter student password to remove");
        String spassword = sc.nextLine();

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, susername);
            st.setString(2, spassword);
            int affectedRows = st.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Student account deleted successfully");
            } else {
                System.out.println("Student doesn't exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
