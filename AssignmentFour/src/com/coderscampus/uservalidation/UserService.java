package com.coderscampus.uservalidation;

import java.util.Scanner;

public class UserService {

	// function to validate user's inputs and outputs the right information to the
	// console
	public User[] validateUser(User[] users, Scanner scanner) {

		Boolean isFound = false;

		int guessCounter = 0;
		User currentUser = null;
		User updateUser = null;

		// loop through until you run out of guesses or login was successfull
		while (guessCounter < 5 && isFound == false) {
			// ask user some information
			System.out.println("Enter your email:");
			String userEmailInput = scanner.nextLine().toLowerCase();
			System.out.println("Enter your password:");
			String userPasswordInput = scanner.nextLine();

			for (User eachUser : users) {

				if (userEmailInput.equals(eachUser.getUsername()) && userPasswordInput.equals(eachUser.getPassword())) {
					System.out.println("Welcome: " + eachUser.getName());
					currentUser = eachUser;
					isFound = true;
				}
			}

			if (!isFound) {
				guessCounter++;
				if (guessCounter < 5) {
					System.out
							.println("Invalid login, please try again (" + guessCounter + "/5" + " attemps remaining");
				} else {
					System.out.println("Too many failed login attemps, you are now locked out");
				}
			}
		}

		if (currentUser != null) {
			int chosenOption = 0;
			while (chosenOption != 4) {
				System.out.println("----------");
				System.out.println("Please choose from the following options:");
				if (currentUser.getRole().equals("super_user")) {
					System.out.println("(0) Log in as another user ");
				}
				System.out.println("(1) Update username");
				System.out.println("(2) Update password");
				System.out.println("(3) Update name");
				System.out.println("(4) Exit");
				// convert user option String into Integer
				chosenOption = Integer.parseInt(scanner.nextLine());
				if (chosenOption == 0 && currentUser.getRole().equals("super_user")) {
					System.out.println("Which user would you like to login as? (Type in a valid username)");
					String updateUsername = scanner.nextLine();
					for (User eachUser : users) {

						if (updateUsername.equals(eachUser.getUsername())) {
							System.out.println("Welcome: " + eachUser.getName());
							updateUser = eachUser;
						}
					}
					if (updateUser == null) {
						System.out.println("Invalid username, please try again");
					} else {
						// update the current logged in user
						currentUser = updateUser;
					}
				} else if (chosenOption == 1) {
					System.out.println("Please type in your new username: ");
					String username = scanner.nextLine();
					currentUser.setUsername(username);
				} else if (chosenOption == 2) {
					System.out.println("Please type in your new password: ");
					String password = scanner.nextLine();
					currentUser.setPassword(password);
				} else if (chosenOption == 3) {
					System.out.println("Please type in your new name: ");
					String name = scanner.nextLine();
					currentUser.setName(name);
				} else if (chosenOption != 4){
					System.out.println("That was NOT one of the choices, please try again");
				}
			}
		}
		return users;
	}
}