package com.spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.spring.pojos.RegistrationPojo;

import validations.user.EmailValidation;
import validations.user.MobileValidation;

public class UserRegistrationService {
	public String saveUserRegistration(RegistrationPojo register, Model message) {
		
		System.out.println("hello krish");
		System.out.println(register.getName() + "....." + register.getEmail() + "....." + register.getPassword() + "....." + register.getMobile() + "....." + register.getCity());
		

		//validation email and mobile logic starts here
		
		boolean isval = MobileValidation.isValid(register.getMobile());
		System.out.println("mobile validation check" + "---" + isval);

		if (!isval) {
			System.out.println("invalid mobile");
			message.addAttribute("message", "invalid mobile number!");
			return "Registration";
		}

		boolean valMail = EmailValidation.isValid(register.getEmail());
		if (!valMail) {
			System.out.println("invalid email id!");
			message.addAttribute("message", "invalid email");
			return "Registration";
		}
		
		
		
		//validation logic end here
		System.out.println("need to configure");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");//contains dbs configuration code/file
		System.out.println("need to configure");
		SessionFactory sf = config.buildSessionFactory();//sessionfactory
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		

		session.save(register);
		tx.commit();//tx.commit is used to hit database / insert in database table(for read operations we didn't need commit)
		session.close();
		return "Login";
		
	}

}
