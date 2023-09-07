package com.password.validation.softserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Pattern;

@SpringBootApplication
public class SoftserveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftserveApplication.class, args);
	}

	public static boolean validatePassword(int length, String password) {
		String passwordPattern
				= "^(?=.*[0-9])(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[!\\\"#$%&'()*+,-\\.\\/:;<=>?@\\[\\\\\\]^_`{|}~])(?!.*?[\\t\\s\\r]).{" + length + "}$";
		Pattern pattern = Pattern.compile(passwordPattern);

		return pattern.matcher(password).matches();
	}
}
