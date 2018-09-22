package com.jBilling.spring.biz;

import lombok.Data;

@Data
public class PasswordHasher {
	private String hashedPassword;
	private String salt;
	public String hashPassword(String password) {
		
		this.hashedPassword = password;
		this.salt = "IamSalt";
		return this.hashedPassword;
	}
	
}
