package com.project.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.dao.UserDetails;

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
		Query q = ss.createQuery("select uname,password from UserDetails where uname='" + uname + "' and password='" + pass + "'");
		List<Object[]> l = q.list();
		for (Object obj1[] : l) {
			for (Object obj : obj1) {
				hs.setAttribute("uname", uname);
				b=true;
			}
		}
		boolean c=false;
		Query q1 = ss.createQuery("select uname from UserDetails where uname='" + uname + "'");
		List<String> l3 = q1.list();
		for (String obj1 : l3) {
			c=true;
		}
		Query q2 = ss.createQuery("select password from UserDetails where uname='" + uname + "'");
		List<String> l1 = q2.list();
		String cpass=null;
		for (String obj : l1) {
			cpass=obj;
		}
		if (uname.isBlank() && pass.isBlank() || uname.isBlank() || pass.isBlank()) {
			mv.addObject("msg", "fields cannot be empty");
			mv.setViewName("login");
		}
		else if(b) {
			
			Session s3=sf.openSession();
			UserDetails ud=s3.load(UserDetails.class, (String) hs.getAttribute("uname"));
			mv.addObject("name",ud.getName() );
			mv.setViewName("home");
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
	@RequestMapping("signup")
	public ModelAndView signup(ModelAndView mv) {
		mv.setViewName("signup");
		return mv;
	}
	@PostMapping("save")
	public ModelAndView save(UserDetails ud,ModelAndView mv) {
		//System.out.println(ad);
		Session ss=sf.openSession();
		Transaction tt=ss.beginTransaction();
		ss.save(ud);
		tt.commit();
		mv.setViewName("save");
		return mv;
	}
	@RequestMapping("balance")
	public ModelAndView checkBalance(ModelAndView mv,HttpSession hs) {
		String uname=(String) hs.getAttribute("uname");
		Session ss=sf.openSession();
		UserDetails ud=ss.load(UserDetails.class, uname);
		mv.setViewName("checkbalance");
		mv.addObject("balance", ud.getBalance());
		return mv;
	}
	@RequestMapping("next")
	public ModelAndView withdrawal(@RequestParam("amount")Integer amount,ModelAndView mv,HttpSession hs) {
		hs.setAttribute("amount", amount);
		Session ss=sf.openSession();
		UserDetails ud=ss.load(UserDetails.class,(String) hs.getAttribute("uname") );
		if(amount>ud.getBalance()) {
			System.out.println("insufficient balance");
		}
		else if(amount<=ud.getBalance()) {
			mv.setViewName("pin");
		}
		return mv;
	}
	@RequestMapping("withdrawal")
	public ModelAndView withdraw(ModelAndView mv,HttpSession hs) {
		mv.setViewName("withdrawal");
		return mv;
	}
	@PostMapping("withdraw")
	public ModelAndView withdrawAmount(ModelAndView mv,HttpSession hs,@RequestParam("pin") int pin) {
		Session ss=sf.openSession();
		UserDetails ud=ss.load(UserDetails.class,(String) hs.getAttribute("uname") );
		if(pin==ud.getPin()) {
			double remain=ud.getBalance()-(int)hs.getAttribute("amount");
			ud.setBalance(remain);
			Transaction tt=ss.beginTransaction();
			ss.saveOrUpdate(ud);
			tt.commit();
			mv.setViewName("success");
		}
		else {
			mv.addObject("msg", "Incorrect PIN,try again");
			mv.setViewName("pin");
		}
		return mv;
	}
	@RequestMapping("pinchange")
	public ModelAndView pinChange(ModelAndView mv,HttpSession hs) {
		mv.setViewName("pinchange");
		return mv;
	}
	@PostMapping("change")
	public ModelAndView change(@RequestParam(required = false,value = "oldpin") Integer opin ,@RequestParam(required = false,value ="newpin") Integer npin,@RequestParam(required = false,value ="cpin") Integer cpin,ModelAndView mv,HttpSession hs) {
		String uname=(String) hs.getAttribute("uname");
		Session ss=sf.openSession();
		UserDetails ud=ss.load(UserDetails.class, uname);
		if(opin==null&&npin==null&&cpin==null) {
			mv.addObject("msg", "Fields cannot be empty!");
			mv.setViewName("pinchange");
		}
		else if(opin.equals(ud.getPin())&&(ud.getPin())!=npin&&npin.equals(cpin) ){
			Session s=sf.openSession();
			Transaction tt=s.beginTransaction();
			UserDetails us=s.load(UserDetails.class, (String)hs.getAttribute("uname"));
			us.setPin(npin);
			s.update(us);
			tt.commit();
			mv.addObject("msg", "PIN Changed Successfully");
			mv.setViewName("pinchange");
		}
		else if(opin!=ud.getPin()&&opin!=npin&&npin.equals(cpin)) {
			mv.addObject("msg", "Incorrect Old PIN");
			mv.setViewName("pinchange");
		}
		else if(opin.equals(ud.getPin())&&opin.equals(npin)&&npin.equals(cpin)) {
			mv.addObject("msg", "This PIN you used already.");
			mv.setViewName("pinchange");	
		}
		else if(opin.equals(ud.getPin())&&opin!=npin&&npin!=cpin) {
			mv.addObject("msg", "New PIN and Confirm PIN not matched.");
			mv.setViewName("pinchange");
		}
		else {
			mv.addObject("msg", "Something went wrong,try again.");
			mv.setViewName("pinchange");
		}
		return mv;
	}
	@RequestMapping("deposit")
	public ModelAndView depo(ModelAndView mv,HttpSession hs) {
		mv.setViewName("deposit");
		return mv;
	}
	@PostMapping("depositprocess")
	public ModelAndView depoprocess(@RequestParam("account") String account,@RequestParam("caccount") String caccount,@RequestParam("amount") Integer amount,ModelAndView mv,HttpSession hs) {
		String uname=(String) hs.getAttribute("uname");
		Session ss=sf.openSession();
		UserDetails ud=ss.load(UserDetails.class, uname);
		if(account.equals(ud.getAccount())&&account.equals(caccount)) {
			ud.setBalance(ud.getBalance()+amount);
			Transaction tt=ss.beginTransaction();
			ss.update(ud);
			tt.commit();
			mv.addObject("msg", "Deposited Successfully");
		}
		else if(account!=(ud.getAccount())||account!=(caccount)) {
			mv.addObject("msg", "Inavlid Account Number");
		}
		else {
			
			mv.addObject("msg", "Something went wrong");
		}
		mv.setViewName("deposit");
		return mv;
	}
	
}

