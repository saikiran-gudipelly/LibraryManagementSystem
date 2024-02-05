package com.RemovingStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RemovingStaff {
    Scanner sc = new Scanner(System.in);

    public void RemoveStaff() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "Shinchan";
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String sql = "delete from staff where sid = ? and susername = ?";

            System.out.println("Enter the Staff Id");
            int Staff_Id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Staff Username");
            String Staff_Usename = sc.nextLine();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Staff_Id);
            st.setString(2, Staff_Usename);
            int affectedRows = st.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Staff member Deleted successfully");
            } else {
                System.out.println("Staff member doesen't exist in the database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
