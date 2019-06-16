package org.emsi.jobapplications.controllers;

import org.emsi.jobapplications.dao.jobseekers.JobseekerDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseDAO;
import org.emsi.jobapplications.dao.offers.OfferDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BusinessAnalysisController 
{
	@Autowired
	AppController mainController;
	
	
	@Autowired
	OfferDAO cntxOffer;
	@Autowired
	EnterpriseDAO cntxEntreprise;
	@Autowired
	JobseekerDAO cntxJob;
	
	
	
	@RequestMapping(value = "/reporting", method = {RequestMethod.GET, RequestMethod.POST} )
	public String templateReporting(Model model, String reportTitle, String reportName) 
	{
		model.addAttribute("ReportURL","http://ybm-himocrypto:8098/Reports/report/RS/" + reportName + "?rs:Embed=true");
		model.addAttribute("reportTitle", reportTitle);
		return mainController.templateLayout(model, "templateReporting");
	}
	
	@RequestMapping(value = "/powerbi", method = {RequestMethod.GET, RequestMethod.POST} )
	public String templatepowerbi(Model model, String reportTitle, String ReportURL) 
	{
		model.addAttribute("ReportURL", ReportURL);
		model.addAttribute("reportTitle", reportTitle);
		return mainController.templateLayout(model, "powerbi");
	}

	@RequestMapping(value = "/powerbi_cloud", method = {RequestMethod.GET, RequestMethod.POST} )
	public String powerbi_cloud(Model model, String reportTitle, String reportName) 
	{
		String URL = "https://app.powerbi.com/view?r=eyJrIjoiMDUyYmY3MDQtNDM5MC00ZTk4LTkyMTEtMDE1Nzc5YzQ3MTMyIiwidCI6ImY5M2Q1ZjQwLTg4YzAtNDY1MC1iOGYyLWNjNGVjM2VmNmExMCIsImMiOjh9";
		return templatepowerbi(model, "MS PowerBI from WEB MS PowerBI CLOUD (in internet) SERVICE DEPLOY - DistbutionByXP&Cities", URL);
	}

	@RequestMapping(value = "/powerbi_local", method = {RequestMethod.GET, RequestMethod.POST} )
	public String powerbi_local(Model model, String reportTitle, String reportName) 
	{
		String URL = "http://ybm-himocrypto:8096/Reports/powerbi/RS/Report_ByXP_ByCities?rs:Embed=true";
		return templatepowerbi(model, "MS PowerBI from LOCAL REPORTING SERVER DEPLOY - DistbutionByXP&Cities", URL);
	}
	
	@RequestMapping(value = "/bi", method = {RequestMethod.GET, RequestMethod.POST} )
	public String bi(Model model) 
	{
		return mainController.templateLayout(model, "bi");
	}
	
	@RequestMapping(value = "/ssrsuni", method = {RequestMethod.GET, RequestMethod.POST} )
	public String ssrsuni(Model model) 
	{
		return mainController.templateLayout(model, "ssrsuni");
	}
	
	@RequestMapping(value = "/ssrsmulti", method = {RequestMethod.GET, RequestMethod.POST} )
	public String ssrsmulti(Model model) 
	{
		return mainController.templateLayout(model, "ssrsmulti");
	}
	
	
	
	
	@RequestMapping(value = "/report1", method = {RequestMethod.GET, RequestMethod.POST} )
	public String raport1(Model model) 
	{
		return templateReporting(model, "STATISTIQUES SUR LES NIVEAUX D'ETUDE" ,"distributionOffresEtudeDemandesEtude");
	}
	
	@RequestMapping(value = "/report2", method = {RequestMethod.GET, RequestMethod.POST} )
	public String raport2(Model model) 
	{
		return templateReporting(model, "STATISTIQUES SUR LES VILLES" ,"distributionOffresDemandesVille");
	}
	
	
	@RequestMapping(value = "/report3", method = {RequestMethod.GET, RequestMethod.POST} )
	public String raport3(Model model) 
	{
		return templateReporting(model, "STATISTIQUES SUR LES TYPES DE CONTRAT" ,"distributionOffresDemandesContratOffert");
	}
	
	
	@RequestMapping(value = "/report4", method = {RequestMethod.GET, RequestMethod.POST} )
	public String raport4(Model model) 
	{
		return templateReporting(model, "STATISTIQUES SUR LES NIVEAUX D'EXPERIENCE" ,"distributionOffresExperienceDemandesExperience");
	}
	
	
	@RequestMapping(value = "/report5", method = {RequestMethod.GET, RequestMethod.POST} )
	public String raport5(Model model) 
	{
		return templateReporting(model, "STATISTIQUES SUR LES NIVEAUX D'EXPERIENCE PAR NIVEAUX D'ETUDE" ,"CroissanceExperienceEtude");
	}
	
	
	@RequestMapping(value = "/report6", method = {RequestMethod.GET, RequestMethod.POST} )
	public String raport6(Model model) 
	{
		return templateReporting(model, "STATISTIQUES SUR LES NIVEAUX D'EXPERIENCE PAR NIVEAUX D'ETUDE PAR CONTRAT" ,"CroissanceExperienceEtudeContratOffres");
	}
	
	
	@RequestMapping(value = "/report7", method = {RequestMethod.GET, RequestMethod.POST} )
	public String raport7(Model model) 
	{
		return templateReporting(model, "STATISTIQUES SUR LES NIVEAUX D'EXPERIENCE PAR NIVEAUX D'ETUDE PAR SECTEUR" ,"CroissanceExperienceEtudeSecteurs");
	}
	
	
	@RequestMapping(value = "/report8", method = {RequestMethod.GET, RequestMethod.POST} )
	public String raport8(Model model) 
	{
		return templateReporting(model, "STATISTIQUES SUR LES SECTEUR PAR LANGUE PAR NIVEAU DE LANGUE" ,"CroissanceLangueSecteur");
	}
	
	
	@RequestMapping(value = "/report9", method = {RequestMethod.GET, RequestMethod.POST} )
	public String raport9(Model model) 
	{
		return templateReporting(model, "STATISTIQUES SUR LES SECTEURS SELON LES OFFRES ET DEMANDES" ,"distributionOffresDemandesSecteur");
	}
	
	
	@RequestMapping(value = "/report10", method = {RequestMethod.GET, RequestMethod.POST} )
	public String raport10(Model model) 
	{
		return templateReporting(model, "STATISTIQUES SUR LES NIVEAUX D'EXPERIENCE PAR NIVEAUX D'ETUDE SELON LES VILLES LES PLUS DOMINATES" ,"experienceEtudeVilles");
	}

}
