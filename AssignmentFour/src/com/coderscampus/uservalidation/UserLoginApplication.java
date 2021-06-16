package com.coderscampus.uservalidation;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		// instantiate the userService & scanner variables
		UserService userService = new UserService();
		Scanner scanner = new Scanner(System.in);
		FileService fileService = new FileService();

		User[] users = fileService.readFile();

		// call the validateUser function passing in the users array
		User[] userUpdate = userService.validateUser(users, scanner);
		
		fileService.writeFile(userUpdate);

		// close the scanner if its not 'null'
		if (scanner != null)
			scanner.close();
	}
}