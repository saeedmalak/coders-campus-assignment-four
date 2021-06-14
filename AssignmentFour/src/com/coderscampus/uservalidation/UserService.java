package com.coderscampus.uservalidation;

import java.util.Scanner;

public class UserService {

	// function to validate user's inputs and outputs the right information to the console
	public void validateUser(User[] users, Scanner scanner) {
		
		Boolean isFound = false;
		
		int guessCounter = 0;
		
		// loop through until you run out of guesses or login was successfull
		while (guessCounter < 5 && isFound == false) {
			// ask user some information
			System.out.println("Enter your email:");
			String userEmailInput = scanner.nextLine().toLowerCase();
			System.out.println("Enter your password:");
			String userPasswordInput = scanner.nextLine().toLowerCase();
			
			for (User eachUser: users) {
				
				if (userEmailInput.equals(eachUser.getUsername()) && userPasswordInput.equals(eachUser.getPassword())) {
					System.out.println("Welcome: " + eachUser.getName());
					isFound = true;
				}
			}
			
			if (!isFound) {
				guessCounter++;
				if (guessCounter < 5) {
					System.out.println("Invalid login, please try again (" + guessCounter + "/5" + " attemps remaining");
				}
				else {
					System.out.println("Too many failed login attemps, you are now locked out");
				}
			}
			
			
			
		}
	}
}