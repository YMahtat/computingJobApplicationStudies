package org.emsi.jobapplications.controllers;

import java.util.ArrayList;
import java.util.List;

import org.emsi.jobapplications.algo.algoCollections.Collector;
import org.emsi.jobapplications.dao.jobseekers.JobseekerCityDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerContratDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerLangageDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerXpActivityDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseCityDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseDAO;
import org.emsi.jobapplications.dao.offers.LangageRequirementDAO;
import org.emsi.jobapplications.dao.offers.OfferActivitySectorDAO;
import org.emsi.jobapplications.dao.offers.OfferCityDAO;
import org.emsi.jobapplications.dao.offers.OfferContratDAO;
import org.emsi.jobapplications.dao.offers.OfferDAO;
import org.emsi.jobapplications.dao.offers.OfferJobDAO;
import org.emsi.jobapplications.models.offers.Offer;
import org.emsi.jobapplications.models.others.Cities;
import org.emsi.jobapplications.models.others.JobSeekerLevelCount;
import org.emsi.jobapplications.models.others.JobseekerActivitySectorCount;
import org.emsi.jobapplications.models.others.OfferJobCount;
import org.emsi.jobapplications.models.others.activityCount;
import org.emsi.jobapplications.models.others.langueOfferCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExtractionController {

	@Autowired
	AppController mainController;
	@Autowired
	OfferDAO cntxOffer;
	@Autowired
	EnterpriseDAO cntxEntreprise;
	@Autowired
	JobseekerDAO cntxJob;
	@Autowired
	OfferContratDAO cntxContrat;
	@Autowired
	OfferActivitySectorDAO cntxOfferActivity;
	@Autowired
	LangageRequirementDAO cntxLangage;
	@Autowired
	JobseekerContratDAO cntxJobseekerContrat;
	@Autowired
	JobseekerDAO cntxJobeeker;
	@Autowired
	JobseekerXpActivityDAO cntJsXp;
	@Autowired
	JobseekerLangageDAO cntxjsl;
	@Autowired
	OfferJobDAO cntxOfferJob;
	@Autowired
	JobseekerCityDAO cntxJsCity;
	@Autowired
	EnterpriseCityDAO cntxEntrCity;
	@Autowired
	OfferCityDAO cntxOfferCity;

	@RequestMapping(value = "/extraction", method = { RequestMethod.GET, RequestMethod.POST })
	public String extraction(Model model) {
		return mainController.templateLayout(model, "extraction");
	}

	@RequestMapping(value = "/offersview", method = { RequestMethod.GET, RequestMethod.POST })
	public String offersview(Model model) {
		ArrayList<Integer> NbrContrat = new ArrayList<Integer>();
		ArrayList<String> list = new ArrayList<String>(Collector.SelectDistinctContrat(cntxContrat.findAll()));

		for (String S : list) {

			NbrContrat.add(cntxContrat.findAllByContrat(S).size());
		}
		// *******************************************
		List<Offer> ListOffer = cntxOffer.findLastOffers(new Long(4));
		// ********************************************

		List<activityCount> Activities = cntxOfferActivity.findAllOfferActivitySorted();
		List<String> listActivityName = new ArrayList<String>();
		List<Long> listActivityCount = new ArrayList<Long>();
		int numAct = 0;
		while (numAct <= 10) {
			listActivityName.add(Activities.get(numAct).getActSector().getActivity());
			listActivityCount.add(Activities.get(numAct).getCount());
			numAct++;
		}
		// **********************************************
		List<String> listLangageReq = new ArrayList<String>();
		List<Long> listLangageReqCount = new ArrayList<Long>();
		for (langueOfferCount Loff : cntxLangage.findAllOfferLangageRequirement()) {
			listLangageReq.add(Loff.getLangage().getLangage());
			listLangageReqCount.add(Loff.getCount());
		}

		cntxContrat.findAll();

		model.addAttribute("listLangageReq", listLangageReq);
		model.addAttribute("listLangageReqCount", listLangageReqCount);

		model.addAttribute("listactivityname", listActivityName);
		model.addAttribute("listactivitycount", listActivityCount);

		model.addAttribute("listoffer", ListOffer);

		model.addAttribute("Contrat", list);
		model.addAttribute("nbrContrta", NbrContrat);

		model.addAttribute("listJs", Trans());

		return mainController.templateLayout(model, "offersview");
	}
	
	
	
	

	@RequestMapping(value = "/jobseekersview", method = { RequestMethod.GET, RequestMethod.POST })
	public String jobseekersview(Model model) {
		// ***************************************************************
		ArrayList<Integer> NbrContrat = new ArrayList<Integer>();
		ArrayList<String> list = new ArrayList<String>(
				Collector.SelectDistinctJobseekerContrat(cntxJobseekerContrat.findAll()));
		for (String S : list) {

			NbrContrat.add(cntxJobseekerContrat.findAllByContrat(S).size());
		}
		model.addAttribute("nbrContrta", NbrContrat);
		model.addAttribute("Contrat", list);
		// ***************************************************************
		ArrayList<String> Level = new ArrayList<String>();
		ArrayList<Long> NbrLevel = new ArrayList<Long>();
		for (JobSeekerLevelCount JsLc : cntxJobeeker.findJobseekerGroupByLevelStudy()) {

			Level.add(JsLc.getJs().getLevelStudy());
			NbrLevel.add(JsLc.getCount());
		}
		model.addAttribute("Level", Level);
		model.addAttribute("NbrLevel", NbrLevel);
		// ****************************************************************
		List<JobseekerActivitySectorCount> Activities = cntJsXp.findAllOfferXpActivitySorted();
		List<String> listActivityName = new ArrayList<String>();
		List<Long> listActivityCount = new ArrayList<Long>();
		int numAct = 0;
		while (numAct <= 10) {
			listActivityName.add(Activities.get(numAct).getJs().getActivity());
			listActivityCount.add(Activities.get(numAct).getCount());
			numAct++;
		}
		model.addAttribute("listactivityname", listActivityName);
		model.addAttribute("listactivitycount", listActivityCount);
		// ****************************************************************
		List<String> listLangage = new ArrayList<String>();
		List<Long> listLangageCount = new ArrayList<Long>();
		numAct = 0;
		while (numAct <= 8) {
			listLangage.add(cntxjsl.findAllJobseekerLangage().get(numAct).getJsl().getLangage());
			listLangageCount.add(cntxjsl.findAllJobseekerLangage().get(numAct).getCount());
			numAct++;
		}
		model.addAttribute("listLangage", listLangage);
		model.addAttribute("listLangageCount", listLangageCount);
		// *****************************************************************

		return mainController.templateLayout(model, "jobseekersview");
	}
	
	@RequestMapping(value = "/Enterpriseview", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterpeisesview(Model model) {
		ArrayList<String> lab=new ArrayList<String>();
		ArrayList<Integer> nbrEntr =new ArrayList<Integer>();
		ArrayList<Integer> nbrJs =new ArrayList<Integer>();
		ArrayList<Integer> nbrOffer =new ArrayList<Integer>();
			for(Cities C : cntxJsCity.findAllCities()) {
				lab.add(C.getCity());
				nbrEntr.add(cntxEntrCity.findAllByCity(C.getCity()).size());
				nbrJs.add(cntxOfferCity.findAllByCity(C.getCity()).size());
				nbrOffer.add(cntxJsCity.findAllByCity(C.getCity()).size());
			}
			
			model.addAttribute("lab", lab);
			model.addAttribute("nbrEntr", nbrEntr);
			model.addAttribute("nbrJs", nbrJs);
			model.addAttribute("nbrOffer", nbrOffer);
			
		return mainController.templateLayout(model, "enterpriseview");
	}
	

	public List<OfferJobCount> Trans() {
		// String listJs[]=new String[cntxOfferJob.countOfferJob().size()] ;
		List<OfferJobCount> listJs = new ArrayList<OfferJobCount>();
		// int i=0;
		for (OfferJobCount oj : cntxOfferJob.countOfferJob()) {
			// listJs[i++]=oj.toString();
			listJs.add(oj);
		}
		System.out.println(listJs);
		return listJs;// "["+String.join(",", listJs)+"]";
	}

}
