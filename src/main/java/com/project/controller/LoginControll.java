package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDetails;

@Controller
public class LoginControll {
	@Autowired
	SessionFactory sf;

	@RequestMapping("signin")
	public ModelAndView signin(ModelAndView mv,HttpSession hs) {

		mv.setViewName("login");
		hs.setAttribute("attempt", 0);
		return mv;

	}

	@PostMapping("login")
	public ModelAndView login(@RequestParam("username") String uname, @RequestParam("password") String pass,
			ModelAndView mv,HttpSession hs) {

		boolean b=false;
		Session ss = sf.openSession();
		Query q = ss.createQuery("select uname,pass from LoginDetails where uname='" + uname + "' and pass='" + pass + "'");
		List<Object[]> l = q.list();
		for (Object obj1[] : l) {
			for (Object obj : obj1) {
				b=true;
			}
		}
		boolean c=false;
		Query q1 = ss.createQuery("select uname from LoginDetails where uname='" + uname + "'");
		List<String> l3 = q1.list();
		for (String obj1 : l3) {
			c=true;

		}
		Query q2 = ss.createQuery("select pass from LoginDetails where uname='" + uname + "'");
		List<String> l1 = q2.list();
		String cpass=null;
		for (String obj : l1) {
			cpass=obj;
		}
		//System.out.println(cpass);

		if (uname.isBlank() && pass.isBlank() || uname.isBlank() || pass.isBlank()) {

			mv.addObject("msg", "fields cannot be empty");

			mv.setViewName("login");

		}

		else if(b) {
			System.out.println("login success");
		}

		else if(c&&pass!=cpass) {
			Integer at=(Integer)hs.getAttribute("attempt")+1;
			mv.addObject("msg", "password wrong");
			mv.setViewName("login");
			hs.setAttribute("attempt", at);
			if(at<3) {
				System.out.println("password wrong, attempted = "+at);
			}
			else if(at==3) {
				System.out.println("u have attemted more than 3 times,now please try after 24hrs");
			}

		}
		else  {
			System.out.println("Invalid UserName and Password");
		}



		return mv;

	}
}

