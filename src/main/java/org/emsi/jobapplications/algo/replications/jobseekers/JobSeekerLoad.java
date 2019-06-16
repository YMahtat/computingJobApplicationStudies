package org.emsi.jobapplications.algo.replications.jobseekers;

import java.io.IOException;


import org.jsoup.nodes.Element;

import org.emsi.jobapplications.algo.replications.dom.DOMLoad;
import org.emsi.jobapplications.algo.replications.dom.DOMType;
import org.emsi.jobapplications.algo.replications.dom.SpecialDocument;
import org.emsi.jobapplications.dao.jobseekers.JobseekerCityDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerContratDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerJobDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerLangageDAO;
import org.emsi.jobapplications.dao.jobseekers.JobseekerXpActivityDAO;
import org.emsi.jobapplications.dao.jobseekers.KnowledgeDAO;
import org.emsi.jobapplications.dao.others.ContextDAO;
import org.emsi.jobapplications.models.jobseekers.Jobseeker;
import org.emsi.jobapplications.models.jobseekers.JobseekerCity;
import org.emsi.jobapplications.models.jobseekers.JobseekerContrat;
import org.emsi.jobapplications.models.jobseekers.JobseekerJob;
import org.emsi.jobapplications.models.jobseekers.JobseekerLangage;
import org.emsi.jobapplications.models.jobseekers.JobseekerXpActivity;
import org.emsi.jobapplications.models.jobseekers.Knowledge;



public class JobSeekerLoad 
{
	
	static JobseekerDAO ctxDemandeur = ContextDAO.ctx.getBean(JobseekerDAO.class);
	

	static JobseekerCityDAO ctxCity = ContextDAO.ctx.getBean(JobseekerCityDAO.class);
	
	static JobseekerContratDAO ctxContrat = ContextDAO.ctx.getBean(JobseekerContratDAO.class);
	
	static JobseekerJobDAO ctxJob = ContextDAO.ctx.getBean(JobseekerJobDAO.class);
	
	static JobseekerLangageDAO ctxLangage = ContextDAO.ctx.getBean(JobseekerLangageDAO.class);
	
	static JobseekerXpActivityDAO ctxActivity = ContextDAO.ctx.getBean(JobseekerXpActivityDAO.class);
	
	static KnowledgeDAO ctxKnowledge = ContextDAO.ctx.getBean(KnowledgeDAO.class);
	
	public static Jobseeker extract(String jobSeekerURL) throws IOException
	{
		// Instanciation du nouveau objet récéptacle du demandeur à extraire :
		Jobseeker demandeur =  new Jobseeker();
		
		// Chargement du DOM(HTML) de la page  du demandeur (CV) à extraire :
		SpecialDocument dom = DOMLoad.getPage(DOMType.jobSeeker, jobSeekerURL);
		
		// Capture du Niveau d'etude  du demandeur :
		demandeur.setLevelStudy(dom.selectElementFromHTMLParsed("div.candidate-education-info > div.field-items > div.field-item", "Niveau d'études :"));
		
		// Capture du Niveau Globale du demandeur :
		demandeur.setGlobaleLevel(dom.selectTextFromHTML("div.field-name-field-candidat-exp-level > div.field-items > div.field-item"));
		
		// Capture de la disponibilité du demandeur :
		demandeur.setDisponibilty(dom.selectTextFromHTML("div.field-name-field-profil-candidat-dispo > div.field-items > div.field-item"));
		
		// Capture des competances du demandeur :
		demandeur.setSkills(dom.selectTextFromHTML("div.field-name-field-profil-candidat-competence > div.field-items > div.field-item"));
		
		// Capture du Lieu de résidence du demandeur :
		demandeur.setCityHome(dom.selectElementFromHTMLParsed("div.field-item", "Lieu de résidence : "));
		
		
		// SAVE RECEPTACLE :
		ctxDemandeur.save(demandeur);
		
		
		// Capture de l'Expérience dans les secteurs d'activité du demandeur :
		for (String activity : dom.selectElementsFromHTMLFiltred("div.field-name-field-candidat-secteur > div.field-items > div.field-item > div.industries-item", "» ")) 
		{
			ctxActivity.save(new JobseekerXpActivity(demandeur, activity));
		}
		
		// Capture des Types de métiers recherchés par le demandeur :
		for (String job : dom.selectElementsFromHTMLFiltred("div.field-name-field-candidat-metier > div.field-items > div.field-item > div.jobs-item", "» ")) 
		{
			ctxJob.save(new JobseekerJob(demandeur, job));
		}
		
		// Capture des Types de contrats acceptés par le demandeur :
		for (String contrat : dom.selectElementsFromHTMLParsed("div.field-name-field-candidat-contrat-type > div.field-items > div.field-item")) 
		{
			ctxContrat.save(new JobseekerContrat(demandeur, contrat));
		}
		 
		// Capture de la Mobilité géographique du demandeur :
		for (String city : dom.selectElementsFromHTMLParsed("div.field-name-field-candidat-region > div.field-items > div.field-item")) 
		{
			ctxCity.save(new JobseekerCity(demandeur, city));
		}
		
		// Capture des Langues du demandeur :
		for (String langage : dom.selectSimpleElementsFromHTML("div.field-name-field-candidat-langue > div.field-items > div.field-item > span.lineage-item-level-0")) 
		{
			ctxLangage.save(new JobseekerLangage(demandeur, langage));
		}
		
		
		// Capture des knowledges du demandeur :
		for (Element elem : dom.getDocument().select("div.field-name-field-candidat-formation > div.field-items > div.field-item > div.emaxp-item")) 
		{
			Knowledge xp = new Knowledge();
			xp.setJobseeker(demandeur);
			xp.setTitle(elem.select("div.title").text());
			xp.setEstablishment(elem.select("div.establishment").text());
			try
			{
				xp.setDescription(elem.select("div.description").text());
				String Period = elem.select("div.period").text();
				String Deb = Period.split(" - ")[0];
				String Fin = Period.split(" - ")[1];
				xp.setStartingMonth(Integer.parseInt(Deb.split("\\.")[0]));
				xp.setStartingYear(Integer.parseInt(Deb.split("\\.")[1]));
				xp.setEndingMonth(Integer.parseInt(Fin.split("\\.")[0]));
				xp.setEndingYear(Integer.parseInt(Fin.split("\\.")[1]));
			}
			catch(Exception e)
			{
				// Noting
			}
			
			ctxKnowledge.save(xp);
		}
		
		
		// RESAVE RECEPTACLE :
		ctxDemandeur.save(demandeur);

		return demandeur;
	}

}
