package com.mycompany.myapp.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {
	private static final Logger logger = LoggerFactory.getLogger(LoginValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Login.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Login login = (Login) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberId", "required","필수 항목입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberPassword", "required", "필수 항목입니다.");
	
		int passwordLength = login.getMemberPassword().length();
		if(passwordLength<4) {
			errors.rejectValue("memberPassword", "minlength", new Object[] {4, passwordLength}, "최소 4자리 이상 입력");
		}
	}

}
