package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.Mail.NotificationMail;
import com.StaffDetails.StaffDash;
import com.StudentDashboard.StudentDashboard;
import com.StudentRegistration.StudentRegistration;
import com.adminDashboard.AdminDashboard;

public class Admin {
    private Scanner sc = new Scanner(System.in);

    public void Main_Menu() {
        while (true) {
            System.out.println("     Main Menu     ");
            System.out.println("***************************");
            System.out.println("1) Admin Login");
            System.out.println("2) Student SignUp");
            System.out.println("3) Student LogIn");
            System.out.println("4) Staff Login");
            System.out.println("5) Exit");
            System.out.println("***************************");
            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        adminLogin();
                        break;
                    case 2:
                        studentSignUp();
                        break;
                    case 3:
                        studentLogin();
                        break;
                    case 4:
                        staffLogin();
                        break;
                    case 5:
                        Exit();
                        break;
                    default:
                        System.out.println("You have entered an invalid option. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please choose a valid option.");
                sc.nextLine();
            }
        }
    }

    public void adminLogin() {
        AdminDashboard adminDashboard1 = new AdminDashboard();
        try {
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String pass = "Shinchan";
            String sql = "select ausername, apassword from admin where ausername = ? and apassword = ?";

            try (Connection con = DriverManager.getConnection(url, user, pass);
                    PreparedStatement st = con.prepareStatement(sql)) {

                System.out.println("Enter Admin username");
                String username = sc.nextLine();

                System.out.println("Enter Admin password");
                String password = sc.nextLine();

                st.setString(1, username);
                st.setString(2, password);

                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Admin Successfully Logged In. Welcome Mr. " + username);
                        NotificationMail notificationMail = new NotificationMail();
                        notificationMail.sendNotification();
                        adminDashboard1.AdminDash();
                    } else {
                        System.out.println("You have entered wrong username or password. Please try again.");
                    }
                }

            }
        } catch (SQLException e) {
            System.out.println("Error during admin login. Please try again.");
        }
    }

    public void studentSignUp() {
        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.SignUp();
    }

    public void studentLogin() {
        try {
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String pass = "Shinchan";
            String sql = "select susername, spassword from student where susername = ? and spassword = ?";

            try (Connection con = DriverManager.getConnection(url, user, pass);
                    PreparedStatement st = con.prepareStatement(sql)) {

                System.out.println("Enter Student username");
                String username = sc.nextLine();

                System.out.println("Enter Student password");
                String password = sc.nextLine();

                st.setString(1, username);
                st.setString(2, password);

                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Student Successfully Logged In. Welcome Mr. " + username);
                        StudentDashboard studentDashboard1 = new StudentDashboard();
                        studentDashboard1.studentDashboard();
                    } else {
                        System.out.println("You have entered wrong username or password. Please try again.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error during student login. Please try again.");
        }
    }

    public void staffLogin() {
        try {
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String pass = "Shinchan";
            String sql = "select susername, spassword from staff where susername = ? and spassword = ?";

            try (Connection con = DriverManager.getConnection(url, user, pass);
                    PreparedStatement st = con.prepareStatement(sql)) {

                System.out.println("Enter Staff username");
                String username = sc.nextLine();

                System.out.println("Enter Staff password");
                String password = sc.nextLine();

                st.setString(1, username);
                st.setString(2, password);

                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Staff Successfully Logged In. Welcome Mr. " + username);
                        StaffDash staffDash = new StaffDash();
                        staffDash.StaffDashboard();
                    } else {
                        System.out.println("You have entered wrong username or password. Please try again.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error during staff login. Please try again.");
        }
    }

    public void Exit() {
        System.out.print("Exiting");
        for (int i = 0; i <= 4; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted during exit. Exiting abruptly.");
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        new Admin().Main_Menu();
    }
}
