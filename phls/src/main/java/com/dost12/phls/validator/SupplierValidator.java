package com.dost12.phls.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dost12.phls.phlsbackend.dto.Supplier;

@Component
public class SupplierValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Supplier.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Supplier file = (Supplier) target;
		if(file.getFile()!=null){
			if (file.getFile().getSize() == 0 && !file.getFile().getOriginalFilename().equals("")) {			
				errors.rejectValue("file", null, "Please select an file to upload!");
			}
		}
	}

}
