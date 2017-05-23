package com.spring;

import javax.servlet.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("n1") int a ,@RequestParam ("n2")int b,HttpServletRequest request,HttpServletResponse response){
		//int a=Integer.parseInt(request.getParameter("n1"));
		//int b=Integer.parseInt(request.getParameter("n2"));
		Service s=new Service();
		int c=s.add(a,b);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result", c);
		return mv;
		}

	}