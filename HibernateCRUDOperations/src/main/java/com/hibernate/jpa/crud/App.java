package com.hibernate.jpa.crud;

import java.util.Scanner;

import com.hibernate.jpa.crud.dao.EmployeeDao;

public class App {
	public static void main(String[] args) {
		EmployeeDao ed = new EmployeeDao();
		Scanner sc = new Scanner(System.in);
		int input;
		System.out.println("********** JPA CRUD OPERATIONS **********");
		do {
			System.out.println("Enter a operation you want: ");
			System.out.println("1. CREATE NEW RECORD");
			System.out.println("2. FETCH SINGLE RECORD");
			System.out.println("3. FETCH MULTIPLE RECORD");
			System.out.println("4. UPDATE RECORD");
			System.out.println("5. DELETE RECORD");
			System.out.println("6.Exit");

			System.out.println("Enter a user input :");
			input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("Enter name:");
				String name = sc.next();
				System.out.println("Enter salary:");
				int salary = sc.nextInt();
				System.out.println("Enter city:");
				String city = sc.next();
				ed.saveEmployee(name, city, salary);
				break;
			case 2:
				System.out.println("Enter id of record that you want to search:");
				int id1 = sc.nextInt();
				ed.findEmployeeById(id1);
				break;
			case 3:
				ed.displayRecords();
				break;

			case 4:
				System.out.println("Enter id of record that you want to update:");
				int id2 = sc.nextInt();
				System.out.println("Enter name:");
				String name1 = sc.next();
//				System.out.println("Enter salary:");
//				int salary1 = sc.nextInt();
//				System.out.println("Enter city:");
//				String city1 = sc.next();
				ed.updateEmployee(name1, id2);
				break;
//			case 5:
//				System.out.println("Enter id of record that you want to delete:");
//				int id3 = sc.nextInt();
//				jp.deleteRecordById(id3);
//				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input");
				input++;
			}

		} while (input != 6);

	}
}
