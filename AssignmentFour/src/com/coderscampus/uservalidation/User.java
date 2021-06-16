package com.coderscampus.uservalidation;

public class User implements Comparable<User>{

	// private instance variables
		private String username;
		private String password;
		private String name;
		protected String role;

		// getters and setters for the above instance variables
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		public String getRole() {
			return role;
		}
		
		@Override
		public int compareTo(User that) {
			int c = that.getRole().compareTo(this.getRole());
			if (c == 0) {
				c = this.getUsername().compareTo(that.getUsername());
			}
			return c;
		}
}