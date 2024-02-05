package com.StaffDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDetails {
    public void staffInfo() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";

        try (Connection con = DriverManager.getConnection(url, user, pass);
                PreparedStatement st = con
                        .prepareStatement("select sid, susername, spassword, contact, email from staff");
                ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                int staffId = rs.getInt("sid");
                String staffName = rs.getString("susername");
                String staffPassword = rs.getString("spassword");
                String contact = rs.getString("contact");
                String email = rs.getString("email");

                System.out.println("Staff Id = " + staffId +
                        ", Staff Name = " + staffName +
                        ", Password = " + staffPassword +
                        ", Contact = " + contact +
                        ", Email = " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
