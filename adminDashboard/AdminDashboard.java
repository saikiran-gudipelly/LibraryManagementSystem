package com.adminDashboard;

import java.util.*;

import com.AddBooks.AddingBook;
import com.AddingStaff.AddingStaff;
import com.AvailabelBooks.AvailableBooks;
import com.EditAdmin.EditAdmin;
import com.RemoveBooks.RemovingBooks;
import com.RemovingStaff.RemovingStaff;
import com.RemovingStudent.RemovingStudent;
import com.StaffDetails.StaffDetails;
import com.StudentInfo.StudentInfo;
import com.admin.Admin;

public class AdminDashboard {
    Scanner sc = new Scanner(System.in);
    Admin admin = new Admin();
    AvailableBooks availableBooks1 = new AvailableBooks();

    public void AdminDash() {
        while (true) {
            System.out.println();
            System.out.println("     Admin Dashboard     ");
            System.out.println("*********************************");
            System.out.println("1) View Available Books");
            System.out.println("2) Add Books");
            System.out.println("3) Remove Books");
            System.out.println("4) View Staff Details");
            System.out.println("5) Add Staff Member");
            System.out.println("6) Remove Staff Member");
            System.out.println("7) Student Details");
            System.out.println("8) Edit Admin");
            System.out.println("9) Remove Student");
            System.out.println("10) Main Menu");
            System.out.println("11) Exit");
            System.out.println("*********************************");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    viewAvailableBooks();
                    break;
                case 2:
                    addBooks();
                    break;
                case 3:
                    removeBooks();
                    break;
                case 4:
                    viewStaffDetails();
                    break;
                case 5:
                    addStaffMember();
                    break;
                case 6:
                    removeStaffMember();
                    break;
                case 7:
                    studentDetails();
                    break;
                case 8:
                    editAdmin();
                    break;
                case 9:
                    removeStudent();
                    break;
                case 10:
                    MainMenu();
                    break;
                case 11:
                    Exit();
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }
    }

    public void viewAvailableBooks() {
        availableBooks1.availableBooks();
    }

    public void addBooks() {
        AddingBook addingBook = new AddingBook();
        addingBook.AddBooks();
    }

    public void removeBooks() {
        RemovingBooks removingBooks = new RemovingBooks();
        removingBooks.RemovBooks();
    }

    public void viewStaffDetails() {
        StaffDetails staffDetails1 = new StaffDetails();
        staffDetails1.staffInfo();
    }

    public void addStaffMember() {
        AddingStaff addingStaff = new AddingStaff();
        addingStaff.AddStaff();
    }

    public void removeStaffMember() {
        RemovingStaff removingStaff = new RemovingStaff();
        removingStaff.RemoveStaff();
    }

    public void studentDetails() {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.StudentDetails();
    }

    public void editAdmin() {
        EditAdmin editAdmin1 = new EditAdmin();
        editAdmin1.editAdmin();
    }

    public void removeStudent() {
        RemovingStudent removingStudent = new RemovingStudent();
        removingStudent.RemoveStudent();
    }

    public void MainMenu() {
        admin.Main_Menu();
    }

    public void Exit() {
        admin.Exit();
    }

    public static void main(String[] args) {

    }

}
