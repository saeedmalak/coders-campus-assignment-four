package com.coderscampus.uservalidation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
	
	public final static int MAX_USER_COUNT = 5;
	
	public User[] readFile() {
		
		BufferedReader fileReader = null;
		User[] users = new User[MAX_USER_COUNT];
		
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			
			String line = "";
			
			//read the csv file and store all the info in users array
			int index = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] props = line.split(",");
				users[index] = new User(props[0], props[1], props[2]);
				index++;
			}
			return users;
		
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Oops, there was an I/O Exception");
			e.printStackTrace();
			// close filereader and scanner
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}