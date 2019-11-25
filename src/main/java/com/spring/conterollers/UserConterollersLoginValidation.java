package com.spring.conterollers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.pojos.RegistrationPojo;

@Controller
public class UserConterollersLoginValidation {
	
	@RequestMapping(value="/login")//method = RequestMethod.POST
	public String LoginValidation(@RequestParam("email") String email, @RequestParam("password") String password, Model message) // follow line to get data from jsp
	{
		
		System.out.println("login validation begain");
		System.out.println("need to configure");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");//contains dbs configuration code/file
		System.out.println("need to configure");
		SessionFactory sf = config.buildSessionFactory();//sessionfactory
		Session session = sf.openSession();
		
		System.out.println("session started");
		Query userSelectQuery = session.createQuery(" from RegistrationPojo where email =? and password =?");
		System.out.println("selectquery started");
		userSelectQuery.setParameter(0, email);
		userSelectQuery.setParameter(1, password);
		List<RegistrationPojo> userlist = userSelectQuery.list();
		System.out.println("parsing list of users to print on console");
		
		if(userlist.isEmpty()) {
		message.addAttribute("message","Invalid username or password");
		return "Login";
		}
		for(RegistrationPojo regesterUsers : userlist) {
			System.out.println(regesterUsers.getName()+ "..." + regesterUsers.getEmail() +"...."+ regesterUsers.getPassword() +"..."+
		regesterUsers.getMobile() +"..."+ regesterUsers.getCity());
			
		}
		System.out.println("parsing is done");
		session.close();
		return "HomePage";
	}

}
