package org.emsi.jobapplications.controllers;

import java.util.ArrayList;
import java.util.List;

import org.emsi.jobapplications.algo.algoCollections.Collector;
import org.emsi.jobapplications.dao.jobseekers.JobseekerDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseActivitySectorDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseDAO;
import org.emsi.jobapplications.dao.offers.OfferDAO;
import org.emsi.jobapplications.models.others.Distribution;
import org.emsi.jobapplications.models.others.GroupByResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController 
{
	@Autowired
	OfferDAO cntxOffer;
	@Autowired
	EnterpriseDAO cntxEntreprise;
	@Autowired
	JobseekerDAO cntxJobSk;
	@Autowired
	EnterpriseActivitySectorDAO cntxActivity;
	
	
	@RequestMapping(value = "/result", method = {RequestMethod.GET, RequestMethod.POST} )
	public String templateLayout(Model model, String pageName) 
	{
		ArrayList<Integer> list= new ArrayList<Integer>();
		list.add((int)cntxOffer.count());
		list.add((int)cntxEntreprise.count());
		list.add((int)cntxJobSk.count());
		list.add(Collector.SelectDistinctActivity(cntxActivity.findAll()).size());
		model.addAttribute("nbr",list);
		model.addAttribute("nbrEntrs",(int)cntxEntreprise.count());
		model.addAttribute("PAGE", pageName);
		return "defaultLayout";
	}
	
	@RequestMapping(value = {"/home", "/index", "/"} , method = {RequestMethod.GET, RequestMethod.POST} )
	public String index(Model model) 
	{
		return templateLayout(model, "index");
	}
	
	@RequestMapping(value = {"/test"} , method = {RequestMethod.GET, RequestMethod.POST} )
	public String test(Model model) 
	{
		model.addAttribute("tab",  cntxJobSk.countGroupByAllSector());
		return templateLayout(model, "test");
	}
	
	@RequestMapping(value = {"/test2"} , method = {RequestMethod.GET, RequestMethod.POST} )
	public String test2(Model model) 
	{
		List<GroupByResult> O = cntxOffer.countGroupByAllJob();
		List<GroupByResult> J = cntxJobSk.countGroupByAllJob();
		ArrayList<Distribution> list = new ArrayList<>();
		O.forEach(
					o -> { 
							J.forEach( 
										j -> { 
												if(o.getKey().replaceAll(" ", "").equals(j.getKey().replaceAll(" ", "")))
												{
													list.add(new Distribution(o.getKey(), o.getCount(), j.getCount()));
												}
													
											 }
									  ); 
						  }
				 );
		model.addAttribute("tab",  list);
		return templateLayout(model, "test2");
	}


}
