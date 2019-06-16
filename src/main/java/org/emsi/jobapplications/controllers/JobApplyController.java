package org.emsi.jobapplications.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JobApplyController 
{
	@Autowired
	AppController mainController;
	
	
	
	@RequestMapping(value = "/perspective" , method = {RequestMethod.GET, RequestMethod.POST} )
	public String perspective(Model model) 
	{
		return mainController.templateLayout(model, "perspective");
	}
	
	@RequestMapping(value = "/howto" , method = {RequestMethod.GET, RequestMethod.POST} )
	public String howto(Model model) 
	{
		return mainController.templateLayout(model, "howto");
	}


}
