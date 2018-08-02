package com.watchers.business.contact.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.watchers.business.contact.model.BoardVo;
import com.watchers.business.main.web.MainController;

@Controller
@RequestMapping("/")
public class ContactController {
	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "Contact.watchers", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView goContact(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/contact_list");
		
		mav.addObject("ContactList", new ArrayList<BoardVo>());
		
		return mav;
	}
	
}
