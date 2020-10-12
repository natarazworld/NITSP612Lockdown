package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component("empValidator")
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class); //useful to check whether expected command/model is recieved
		                                                                                 // to validator class or not
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate(-,-)");
		Employee emp=null;
		//type casting on command class obj
		emp=(Employee)target;
		//write form validation logic
		if(emp.getEname()==null ||  emp.getEname().isEmpty()) {   //required rule
			errors.rejectValue("ename","emp.ename.required");   //errors obj hods property name, error message collected proepries file
		}
		else if(emp.getEname().length()<5 || emp.getEname().length()>10) {   //length
			errors.rejectValue("ename","emp.ename.length");
		}
		
		if(emp.getJob()==null ||  emp.getJob().isEmpty()) {   //required rule
			errors.rejectValue("job","emp.job.required");
		}
		else if(emp.getJob().length()<5 || emp.getJob().length()>10) {   //length
			errors.rejectValue("job","emp.job.length");
		}
		
		if(emp.getSal()==null ) {   //required rule
			errors.rejectValue("sal","emp.sal.required");
		}
		else if(emp.getSal()<10000 || emp.getSal()>100000) {   //length
			errors.rejectValue("sal","emp.sal.range");
		}

	}//method
}//class
