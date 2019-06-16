package org.emsi.jobapplications.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.emsi.jobapplications.algo.bigdata.UploadToHDFS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BigDataController 
{
	@Autowired
	AppController mainController;
	
	@RequestMapping(value = "/bigdata" , method = {RequestMethod.GET, RequestMethod.POST} )
	public String bigdata(Model model) 
	{
		return mainController.templateLayout(model, "bigdata");
	}
	
	
	@RequestMapping(value = "/loadbigdataprocess" , method = {RequestMethod.GET, RequestMethod.POST} )
	public String loadbigdataprocess(Model model)
	{
		try
		{
			UploadToHDFS.run();
			return "loadbigdataprocess";
		}
		catch (Exception e) 
		{
			return "errorbigdata";
		}
		
	}
		
	
	
	

}
