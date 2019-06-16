package org.emsi.jobapplications.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController 
{

	@Autowired
	AppController mainController;
	
	@RequestMapping(value = "/project" , method = {RequestMethod.GET, RequestMethod.POST} )
	public String project(Model model) 
	{
		return mainController.templateLayout(model, "project");
	}
	
	@RequestMapping(value = "/team" , method = {RequestMethod.GET, RequestMethod.POST} )
	public String team(Model model) 
	{
		return mainController.templateLayout(model, "team");
	}

	
	

}
