package com.lockedme;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Driver {

	// To access the file service for performing the operations.
	private static FileService fs = FileService.getService();
	
	// Scanner object to be used across.
	private static Scanner sc = new Scanner(System.in);
	
	// Getting configuration from configuration.properties.
	private final static ResourceBundle rb = ResourceBundle.getBundle("configuration");
	private final static String header = rb.getString("header");
	private final static String author = rb.getString("author");
	private final static String fileheader = rb.getString("fileheader");
	
	
	public Driver() {
	}
	

	private static void homeScreenDisplay() {
		System.out.println(header + "\n" + author);
	}
	
	private static void homeScreen() throws IOException {
		int option;
		do {
			homeScreenDisplay();
			System.out.println("Please select any of the below operation you would like to perform...\n"
					          + "\t1. Display all the files in the current directory.\n"
					          + "\t2. Choose this to perform other operations in the current directory.\n"
					          + "\t3. Close Application.");
			option = sc.nextInt();
			
			switch (option) {
			case 1:
				System.out.println("\t" + "--".repeat(fileheader.length()));
				System.out.println(fileheader);
				System.out.println("\t" + "--".repeat(fileheader.length()));
				for(FileOrganizer organiser : fs.displayFiles()) {
					System.out.println("\t| " + organiser.getFileid() + "\t| " + organiser.getFilename());
				}
				System.out.println("\t" + "--".repeat(fileheader.length()));
				break;
			case 2:
				operationScreen();
				break;
			case 3:
				break;
			}
		} while(option != 3);
	}
	
	private static void operationScreen() throws IOException {
		int option;
		String filename;
		do {
			System.out.println("Select any of the below operation you would like to perform...\n"
					+ "\t1. Create File\n"
					+ "\t2. Delete File\n"
					+ "\t3. Search File\n"
					+ "\t4. Previous Menu\n");
			option = sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Please input the filename for creating it...");
				filename = sc.next();
				if(fs.createFile(filename))
					System.out.println("Status ... Ok.\n");
				else
					System.out.println("Status ... Failed.\n");
				break;
			case 2:
				System.out.println("Please input the filename for deleting it...");
				filename = sc.next();
				if(fs.deleteFile(filename) != true)
					System.out.println("File not found.\n");
				else
					System.out.println("Status ... Ok.\n");
				break;
			case 3:
				System.out.println("Please input the filename for searching it...");
				filename = sc.next();
				if(fs.searchFile(filename) != true)
					System.out.println("File not found.\n");
				else
					System.out.println("Status ... Ok.\n");
				break;
			case 4:
				break;
			}
		} while(option != 4);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		homeScreen();
		sc.close();
	}
}
