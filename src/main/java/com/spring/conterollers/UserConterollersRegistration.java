package com.spring.conterollers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.pojos.RegistrationPojo;

import validations.user.EmailValidation;
import validations.user.MobileValidation;

@Controller
public class UserConterollersRegistration {

	// get data from jsp....and save the information to database

	@RequestMapping(value = "/Registration", method = RequestMethod.POST) // RequestMethod.POST is used to hide the
																			// details that displayed on url bar such as
					//RegistrationPojo is pojo class name														// registration details and other details
	public String saveUserRegistration(RegistrationPojo register, Model message) {  // //This  way is required when names in pojo class and jsp page are same
		// above code to get data from jsp page to our own class/javaclass
		
		/*public String saveUserRegistration(@RequestParam("name") String name, @RequestParam("email") String email,
				@RequestParam("password") String password, @RequestParam("mobile") String mobile,
				@RequestParam("city") String city) {    //This  way is required when names in pojo class and jsp page are different
			// above code to get data from jsp page to our own class/javaclass
*/
		
		
		// above code is print/see entered details in registration page

		/*RegistrationPojo registrationPojo = new RegistrationPojo(); // getting pojo class values into java for calling
																	// from java
		System.out.println("pojoClass loaded");
		registrationPojo.setName(name);
		registrationPojo.setEmail(email);
		registrationPojo.setPassword(password);
		registrationPojo.setMobile(mobile);
		registrationPojo.setCity(city);
		*/
		
		UserConterollersRegistration service = new UserConterollersRegistration();
		String result = service.saveUserRegistration(register, message);
		
		return result;
		
	}

}
