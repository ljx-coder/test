package com.microservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FreemarkerController {
	@RequestMapping("fm")
	public ModelAndView fm(ModelAndView mv) {
		mv.addObject("name", "老王");
		mv.setViewName("index");
		return mv;
	}

}
