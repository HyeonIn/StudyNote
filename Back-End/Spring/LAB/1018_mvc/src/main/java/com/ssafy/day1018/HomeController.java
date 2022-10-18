package com.ssafy.day1018;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //DispatcherServlet의 부하임
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/bye", method= RequestMethod.GET)
	public ModelAndView byebye(String name, int age) {
		System.out.println("~~~/1018_mvc/bye 라는 요청이 도착했네요");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbb");
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.addObject("msg","안녕 잘가");
		
		return mv;
	}
}
