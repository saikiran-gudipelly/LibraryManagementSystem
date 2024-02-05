package com.StudentInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudentInfo {
    Scanner sc = new Scanner(System.in);

    public void StudentDetails() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";
        String sql = "select sid, susername, spassword, contact, email from student ";

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int sid = rs.getInt(1);
                String susername = rs.getString(2);
                String spassword = rs.getString(3);
                String contact = rs.getString(4);
                String email = rs.getString(5);

                System.out.println("sid = " + sid + " susername = " + susername + " spassword = " + spassword
                        + "contact = " + contact + "email = " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
