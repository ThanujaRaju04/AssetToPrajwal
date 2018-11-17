package com.cg.ams.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.cg.ams.exception.AMSException;
import com.cg.ams.service.AssetServiceImpl;
import com.cg.ams.service.IAssetService;


public class MainUI {
	public static void main(String[] args) throws AMSException {
		Scanner scanner = new Scanner(System.in);
		PropertyConfigurator.configure("resources/log4j.properties");
		IAssetService service = new AssetServiceImpl();
		int choice = 0;
		int loginAttempts = 0;

		while (choice != 2 && loginAttempts < 3) {


			System.out.println("Select your option");
			System.out.println("[1]. Login" + "\n"
					+ "[2]. Exit");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Enter digits only(1-2)");
			}
			switch (choice) {
						case 1:
				System.out.print("UserName? ");
				String userName = scanner.next();
				System.out.print("Password? ");
				String password = scanner.next();
				loginAttempts++;
				String userType = service.getuserType(userName, password);
				System.out.println(userType);
				if (userType.equalsIgnoreCase("Manager")) {
					ManagerConsole console = new ManagerConsole();
					console.start(userName);
				} else if (userType.equalsIgnoreCase("Admin")) {
					AdminConsole console = new AdminConsole();
					console.start(userName);
				}
				System.exit(0);
			case 2:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.exit(0);
				break;
			}

		}
		System.out.println("More than 3 attempts" + "\n" + "Exitting");
		scanner.close();
		System.exit(0);
	}


}
