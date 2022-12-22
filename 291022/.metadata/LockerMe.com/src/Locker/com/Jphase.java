package Locker.com;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jphase {
	
	
	private int getOption() {
		Scanner in = new Scanner(System.in);

		int returnOption = 0;
		try {
			returnOption = in.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("Invalid input");
		}
		return returnOption;
	}

	public static void main(String args[]) throws IOException {
		
		
		
		
		int option;
		
		System.out.println("Application Developer : Srinivas");
		System.out.println("File Menu Related Application");
		do {
		try {
			    Scanner sc = new Scanner(System.in);
				System.out.println(" your are in Main Menu");
				System.err.println("Choose your option");
				System.out.println(" 1 - Enter the number 1 for  Display the Current File Names");
				System.out.println(" 2 - Enter the number 2 for Display the user interface");
				System.out.println(" 3 - Enter the number 3 for Exit");
				Jphase obj1 =new Jphase();
				option = obj1.getOption();
				
				
				fileOperations(sc, option);

			
		} catch (Exception e) {
			//System.err.println("Exception Is: " +e.getMessage());
		
			System.err.println("Please enter valid input...");

		}} while (true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void fileOperations(Scanner sc, int option) {
		int suboption;
		switch (option) {
		case 1:

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Directory of a File : ");
			String dirPath = scanner.nextLine(); // Takes the directory path as the user input

			File folder = new File(dirPath);
			if (folder.isDirectory()) {
				File[] fileList = folder.listFiles();

				Arrays.sort(fileList);

				System.out.println("\nTotal number of items present in the directory: " + fileList.length);

				// Creating a filter to return only files.
				FileFilter fileFilter = new FileFilter() {
					@Override
					public boolean accept(File file) {
						return !file.isDirectory();
					}
				};

				fileList = folder.listFiles(fileFilter);

				// Sort files by name
				Arrays.sort(fileList, new Comparator() {
					@Override
					public int compare(Object f1, Object f2) {
						return ((File) f1).getName().compareTo(((File) f2).getName());
					}
				});

				// Prints the files in file name ascending order
				for (File file : fileList) {
					System.out.println(file.getName());
				}

			}

			break;
		case 2: // you need to write the logic to display the user
			// interface to perform various operations of file
			// System.out.println("You are in Case 2");

			do {
				System.out.println("Choose the operation to do...");
				System.out.println("11 - Enter the number 11 to Add File");
				System.out.println("12 - Enter the number 12 to Delete File");
				System.out.println("13 - Enter the number 13 to Search File");
				System.out.println("14 - Enter the number 14 Back to Main Menu");
				Jphase obJphase =new Jphase();
				suboption = obJphase.getOption();
				switch (suboption)

				{
				case 11:

					try {
						Scanner sc1 = new Scanner(System.in); // object of Scanner class
						System.out.print(" enter file name with correct directory \n");
						String name = sc1.nextLine(); // variable name to store the file name
						FileOutputStream fos = new FileOutputStream(name, true); // true for append mode
						System.out.print("Enter file content\n ");
						String str = sc1.nextLine() + "\n"; // str stores the string which we have entered
						byte[] b = str.getBytes(); // converts string into bytes
						fos.write(b); // writes bytes into file
						fos.close(); // close the file
						System.out.println("file and content is succefully added");
					} catch (Exception e) {
						e.printStackTrace();
					}

					break;
				case 12:
					// you need to write a logic to delete a file

					Scanner scanD = new Scanner(System.in);

					System.out.println("Enter the directory where to delete a file ");
					String directoryPathD = scanD.nextLine();

					System.out.println("Enter the file to be deleted.. ");
					String fileNme = scanD.nextLine();

					File directoryD = new File(directoryPathD.trim());

					// store all names with same name
					// with/without extension
					String[] flistD = directoryD.list();
					int flagD = 0;
					if (flistD == null) {
						System.out.println("Empty directory.");
					} else {

						// Linear search in the array
						for (int i = 0; i < flistD.length; i++) {
							String filename = flistD[i];
							if (filename.equalsIgnoreCase(fileNme.trim())) {
								System.out.println(filename + " found");
								flagD = 1;
								File myObj = new File(directoryPathD + "\\" + fileNme);
								if (myObj.delete()) {
									System.out.println("File Deleted Successfully..!");
								}

							}
						}
					}

					if (flagD == 0) {
						System.out.println(fileNme + " File Not Found in the " + directoryPathD);
					}

					break;
				case 13:

					// you need to write a logic to search a file
					Scanner scan = new Scanner(System.in);

					System.out.println("Enter the directory where to search a file ");
					String directoryPath = scan.nextLine();

					System.out.println("Enter the file name to be searched.. ");
					String fileName = scan.nextLine();

					// Create an object of the File class
					// Replace the file path with path of the directory
					File directory = new File(directoryPath.trim());

					// store all names with same name
					// with/without extension
					String[] flist = directory.list();
					int flag = 0;
					if (flist == null) {
						System.out.println("Empty directory.");
					} else {

						// Linear search in the array
						for (int i = 0; i < flist.length; i++) {
							String filename = flist[i];
							if (filename.equalsIgnoreCase(fileName.trim())) {
								System.out.println(filename + " is founded in given directory  " + directoryPath);
								flag = 1;
							}
						}
					}

					if (flag == 0) {
						System.out.println("File Not Found");
					}
					break;
				case 14:
					// you need to write a logic to return to main menu
					System.out.println("Your are in Main Menu");
					System.err.println("Choose your option");
					System.out.println("option 1 - for  Display the Current File Name");
					System.out.println("option 2 - for Display the user interface");
					System.out.println("Optoin 3 - for Exit");
					option = sc.nextInt();
					fileOperations(sc, option);
					break;
				default:
					System.err.println("enter the valid input");
				}
			} while (true);

		case 3:
			System.out.println("You are in Case 3...Application Is Closed");
			System.exit(0);
			break;
		default:
			System.err.println("ivalid input...");

		}
	
		
		
		
	}

}
