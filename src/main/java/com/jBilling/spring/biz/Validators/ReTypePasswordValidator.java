package com.jBilling.spring.biz.Validators;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.jBilling.spring.model.User;
public class ReTypePasswordValidator implements ConstraintValidator<ReTypePassword,User>{
	
	private String password;
	private String retypePassword;
	@Override
	public void initialize(ReTypePassword arg0) {
		this.password = arg0.field();
		this.retypePassword = arg0.fieldMatch();
	}

	@Override
	public boolean isValid(User user, ConstraintValidatorContext context) {
		if(user==null) {
			return false;
		}
		String password = user.getPassword();
		String reTypePassword = user.getReTypePassword();
		if(password!=null && reTypePassword!=null) {
			if(password.equals(reTypePassword)) {
				return true;
			}
		}
		return false;
	}
	
}
