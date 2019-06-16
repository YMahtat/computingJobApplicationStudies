package org.emsi.jobapplications.controllers;

import java.util.ArrayList;
import java.util.List;

import org.emsi.jobapplications.dao.jobseekers.JobseekerDAO;
import org.emsi.jobapplications.dao.offers.OfferDAO;
import org.emsi.jobapplications.models.others.Distribution;
import org.emsi.jobapplications.models.others.GroupByResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportingController {

	@Autowired
	AppController mainController;

	@Autowired
	OfferDAO cntxOffer;
	@Autowired
	JobseekerDAO cntxJobSk;

	@RequestMapping(value = "/ourreporting", method = { RequestMethod.GET, RequestMethod.POST })
	public String ourreporting(Model model) 
	{
		return mainController.templateLayout(model, "ourreporting");
	}

	@RequestMapping(value = "/distcity", method = { RequestMethod.GET, RequestMethod.POST })
	public String distcity(Model model) 
	{
		return mainController.templateLayout(model, "distcity");
	}

	
	@RequestMapping(value = "/distsector", method = { RequestMethod.GET, RequestMethod.POST })
	public String distsector(Model model) 
	{
		return mainController.templateLayout(model, "distsector");
	}

}
