package org.emsi.jobapplications.controllers;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.emsi.jobapplications.algo.textmining.AlgoELBOW;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.emsi.jobapplications.dao.jobseekers.JobseekerDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerLangageDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerXpActivityDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseActivitySectorDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseCityDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseDAO;
import org.emsi.jobapplications.dao.offers.LangageRequirementDAO;
import org.emsi.jobapplications.dao.offers.OfferActivitySectorDAO;
import org.emsi.jobapplications.dao.offers.OfferDAO;
import org.emsi.jobapplications.dao.offers.OfferJobDAO;
import org.emsi.jobapplications.models.others.Cities;
import org.emsi.jobapplications.models.others.OfferJobCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.emsi.jobapplications.algo.textmining.*;

@Controller
public class TextMiningController 
{

	@Autowired
	AppController mainController;
	
	@Autowired
	ServletContext context;
	
	
	@Autowired
	OfferDAO cntxOffer;
	@Autowired
	EnterpriseDAO cntxEntreprise;
	@Autowired
	JobseekerDAO cntxJobSk;
	@Autowired
	EnterpriseActivitySectorDAO cntxActivity;
	@Autowired
	OfferActivitySectorDAO cntxOfferActivity;
	@Autowired
	LangageRequirementDAO cntxLangage;
	@Autowired
	OfferJobDAO cntxOfferJob;
	@Autowired
	JobseekerDAO cntxJobeeker;
	@Autowired
	JobseekerXpActivityDAO cntJsXp;
	@Autowired
	JobseekerLangageDAO cntxJsLang;
	@Autowired
	EnterpriseCityDAO cntxCity;

	static Text_Mining TM;
	
	
	@RequestMapping(value = "/elbow", method = {RequestMethod.GET, RequestMethod.POST} )
	public String elbow(Model model) 
	{
		return mainController.templateLayout(model, "elbow");
	}
	
	@RequestMapping(value = "/loadAlgoElbow", method = {RequestMethod.GET, RequestMethod.POST} )
	public String loadAlgoElbow(Model model) throws InterruptedException, IOException 
	{
		//Thread.sleep(30*1000);
		AlgoELBOW.executeMatrixOffer(context);
		return "/loadAlgoElbow";
	}
	
	@RequestMapping(value = "/formkmeans", method = {RequestMethod.GET, RequestMethod.POST} )
	public String formkmeans(Model model) throws InterruptedException, IOException 
	{
		return mainController.templateLayout(model, "formkmeans");
	}


	@RequestMapping(value = "/kmeans", method = {RequestMethod.GET, RequestMethod.POST}, params = {"elbownbr", "bag"}  )
	public String kmeans(@RequestParam(value = "elbownbr") String elbownbr, @RequestParam(value = "bag", defaultValue="1") String bag, Model model) 
	{
		ArrayList<ArrayList<Distance_per_word>> dpws = new ArrayList<>();
		System.out.println("ELBOW : " + elbownbr);
		int nbrClusters = Integer.parseInt(elbownbr);
		int bagNum = Integer.parseInt(bag);
		
		
		if(TM == null)
		{
			ArrayList<String> DesJob= new ArrayList();
			
			for(Cities St : cntxOffer.findAllDescJob()) {
				DesJob.add(St.getCity());
			}
			TM = new Text_Mining(DesJob);
			TM.Call_Kmeans_algorithm(nbrClusters);
		}
			
		
		ArrayList<Distance_per_word> dpw=TM.Distance_per_word_per_cluster(bagNum-1);
		Collections.sort(dpw);
		ArrayList<Distance_per_word> dwp100=new ArrayList<Distance_per_word>(); 
		int i=0;
		while(i<=100) {
			dwp100.add(dpw.get(i));
			i++;
		}
		
		
		model.addAttribute("tab",dwp100);
		return mainController.templateLayout(model, "kmeans2");
	}
	
	public List<OfferJobCount> Trans(){
		//String listJs[]=new String[cntxOfferJob.countOfferJob().size()] ;
		List<OfferJobCount> listJs=new ArrayList<OfferJobCount>();
		//int i=0;
		for(OfferJobCount  oj: cntxOfferJob.countOfferJob()) {
			//listJs[i++]=oj.toString();
			listJs.add(oj);
		}
		System.out.println(listJs);
		return listJs;//"["+String.join(",", listJs)+"]";
		
	}

}
