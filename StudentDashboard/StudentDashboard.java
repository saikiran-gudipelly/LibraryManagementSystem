package com.StudentDashboard;

import java.util.Scanner;

import com.DeletingAccount.DeletingAccount;
import com.RequestBook.RequestingBook;
import com.SearchingBook.SearchingBook;
import com.admin.Admin;
import com.adminDashboard.AdminDashboard;

public class StudentDashboard {
    Scanner sc = new Scanner(System.in);
    AdminDashboard adminDashboard = new AdminDashboard();

    public void studentDashboard() {
        while (true) {
            System.out.println("    Student Dasboard      ");
            System.out.println("*********************************");
            System.out.println("1) View Available Books");
            System.out.println("2) Search a Book");
            System.out.println("3) Request a Book");
            System.out.println("4) Delete account");
            System.out.println("5) Main Menu");
            System.out.println("6) Exit");
            System.out.println("*********************************");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    AvailableBooks();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    RequestBook();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    MainMenu();
                    break;
                case 6:
                    Exit();
                    break;
                default:
                    break;
            }
        }
    }

    public void AvailableBooks() {
        adminDashboard.viewAvailableBooks();
    }

    public void searchBook() {
        SearchingBook searchingBook = new SearchingBook();
        searchingBook.searchBooks();
    }

    public void RequestBook() {
        RequestingBook requestingBook = new RequestingBook();
        requestingBook.BookRequest();
    }

    public void deleteAccount() {
        DeletingAccount deletingAccount = new DeletingAccount();
        deletingAccount.DeletAccount();
    }

    public void MainMenu() {
        Admin admin = new Admin();
        admin.Main_Menu();
    }

    public void Exit() {
        Admin admin = new Admin();
        admin.Exit();
    }
}
