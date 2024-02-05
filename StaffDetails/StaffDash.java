package com.StaffDetails;

import java.util.Scanner;

import com.AddBooks.AddingBook;
import com.AvailabelBooks.AvailableBooks;
import com.RemoveBooks.RemovingBooks;
import com.adminDashboard.AdminDashboard;

public class StaffDash {
    AvailableBooks availableBooks1 = new AvailableBooks();
    StaffDetails staffDetails1 = new StaffDetails();
    AddingBook addingBook = new AddingBook();
    RemovingBooks removingBooks = new RemovingBooks();
    AdminDashboard adminDashboard1 = new AdminDashboard();
    Scanner sc = new Scanner(System.in);

    public void StaffDashboard() {

        while (true) {
            System.out.println();
            System.out.println("     Staff Dashboard     ");
            System.out.println("*************************************");
            System.out.println("1) View Available Books");
            System.out.println("2) View Staff Details");
            System.out.println("3) Add Books");
            System.out.println("4) Remove Books");
            System.out.println("5) Main Menu");
            System.out.println("6) Exit");
            System.out.println("*************************************");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    availableBooks1.availableBooks();
                    break;
                case 2:
                    staffDetails1.staffInfo();
                    break;
                case 3:
                    addingBook.AddBooks();
                    break;
                case 4:
                    removingBooks.RemovBooks();
                    break;
                case 5:
                    adminDashboard1.MainMenu();
                    break;
                case 6:
                    adminDashboard1.Exit();
                    break;
                default:
                    System.out.println("You have entered invalid option. Please try");
                    break;
            }
        }
    }
}
