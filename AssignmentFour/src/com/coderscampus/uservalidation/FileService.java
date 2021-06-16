package com.coderscampus.uservalidation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileService {

	public final static int MAX_USER_COUNT = 20;

	public User[] readFile() {

		BufferedReader fileReader = null;
		User[] users = new User[MAX_USER_COUNT];

		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			String line = "";

			// read the csv file and store all the info in users array
			int index = 0;
			while ((line = fileReader.readLine()) != null) {
				// split each row by "," and " " to get the correct data
				String[] props = line.split(", ");
				if (props[3].equals("super_user")) {
					users[index] = new SuperUser(props[0], props[1], props[2]);
				} else {
					users[index] = new NormalUser(props[0], props[1], props[2]);
				}

				index++;
			}
			return users;

		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Oops, there was an I/O Exception");
			e.printStackTrace();
			// close filereader
		} finally {
			try {
				if (fileReader != null)
					fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void writeFile(User[] users) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("data.txt"));
			Arrays.sort(users);

			for (User user : users) {
				writer.write(user.getUsername() + ", " + user.getPassword() + ", " + user.getName() + ", "
						+ user.getRole() + "\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Oops, there was an I/O Exception");
			e.printStackTrace();
			// close fileWriter
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}