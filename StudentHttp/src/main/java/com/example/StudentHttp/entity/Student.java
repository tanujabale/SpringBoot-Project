package com.example.StudentHttp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
	public class Student {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Name is mandatory")
	    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contain only letters and spaces")
	    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	    private String name;

	    @NotBlank(message = "Gender is mandatory")
	    private String gender;

	    @NotNull(message = "Date of birth is mandatory")
	    @PastOrPresent(message = "Date of birth must be in the past or today")
	    private LocalDate dateOfBirth;

	 

		@NotBlank(message = "Email is mandatory")
	    @Email(message = "Email should be valid")
	    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email should be in a valid format")
	    private String email;

	    @NotBlank(message = "Phone number is mandatory")
	    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Phone number must be 10 digits and start with 6, 7, 8, or 9")
	    private String phoneNumber;

	    @NotBlank(message = "Username is mandatory")
	    @Size(min = 5, max = 15, message = "Username should be between 5 and 15 characters")
	    private String username;

	    @NotBlank(message = "Password is mandatory")
	    @Size(min = 6, message = "Password should have at least 6 characters")
	    private String password;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
		   public LocalDate getDateOfBirth() {
				return dateOfBirth;
			}

			public void setDateOfBirth(LocalDate dateOfBirth) {
				this.dateOfBirth = dateOfBirth;
			}
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

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

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", email=" + email
					+ ", phoneNumber=" + phoneNumber + ", username=" + username + ", password=" + password + "]";
		}

		public Student(Long id, String name, String gender, LocalDate dateOfBirth, String email, String phoneNumber,
				String username, String password) {
			super();
			this.id = id;
			this.name = name;
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.username = username;
			this.password = password;
		}

		public Student() {
			super();
		}

	   
	}


