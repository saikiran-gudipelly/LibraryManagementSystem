package com.RemovingStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class RemovingStudent {
    Scanner sc = new Scanner(System.in);

    public void RemoveStudent() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";
        String sql = "delete from student where sid = ? and susername = ?";
        System.out.println("Enter student id");
        int sid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter student username");
        String username = sc.nextLine();
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, sid);
            st.setString(2, username);
            int affectedRows = st.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Student removed successfully");
            } else {
                System.out.println("Student doesen't exitst");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
