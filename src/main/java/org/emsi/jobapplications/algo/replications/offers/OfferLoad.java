package org.emsi.jobapplications.algo.replications.offers;



import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.jsoup.nodes.Element;

import org.emsi.jobapplications.algo.replications.dom.DOMLoad;
import org.emsi.jobapplications.algo.replications.dom.DOMType;
import org.emsi.jobapplications.algo.replications.dom.SpecialDocument;

import org.emsi.jobapplications.dao.offers.LangageRequirementDAO;
import org.emsi.jobapplications.dao.offers.OfferActivitySectorDAO;
import org.emsi.jobapplications.dao.offers.OfferCityDAO;
import org.emsi.jobapplications.dao.offers.OfferContratDAO;
import org.emsi.jobapplications.dao.offers.OfferDAO;
import org.emsi.jobapplications.dao.offers.OfferJobDAO;
import org.emsi.jobapplications.dao.others.ContextDAO;
import org.emsi.jobapplications.models.offers.Enterprise;
import org.emsi.jobapplications.models.offers.LangageRequirement;
import org.emsi.jobapplications.models.offers.Offer;
import org.emsi.jobapplications.models.offers.OfferActivitySector;
import org.emsi.jobapplications.models.offers.OfferCity;
import org.emsi.jobapplications.models.offers.OfferContrat;
import org.emsi.jobapplications.models.offers.OfferJob;

public class OfferLoad 
{
	
	static OfferDAO ctxOffer = ContextDAO.ctx.getBean(OfferDAO.class);
	
	static LangageRequirementDAO ctxLanage = ContextDAO.ctx.getBean(LangageRequirementDAO.class);
	
	static OfferActivitySectorDAO ctxActivity = ContextDAO.ctx.getBean(OfferActivitySectorDAO.class);
	
	static OfferCityDAO ctxCity = ContextDAO.ctx.getBean(OfferCityDAO.class);
	
	static OfferContratDAO ctxContrat = ContextDAO.ctx.getBean(OfferContratDAO.class);
	
	static OfferJobDAO ctxJob = ContextDAO.ctx.getBean(OfferJobDAO.class);
	
	
	
	public static Offer extract(String offerURL) throws IOException, ParseException
	{
		// Instanciation du nouveau objet récéptacle de l'offre à extraire :
		Offer annonce = new Offer();
		
		// Chargement du DOM(HTML) de la page offre à extraire :
		SpecialDocument dom = DOMLoad.getPage(DOMType.offer, offerURL);
		
		
		// Capture du titre de l'offre :
		annonce.setTitle(dom.selectTextFromHTML("h1.title"));
		
		// Capture de la date de l'offre :
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		annonce.setOfferDate(sdf.parse(dom.selectTextFromHTML("div.job-ad-publication-date").replaceAll("Publiée le ", "")));
		
		// Capture de l'entreprise de l'offre :
		String entrepriseURL = dom.selectRelativeLinkFromHref("div.company-title > a");
		Enterprise e = EnterpriseOffersSouping.entreprisesMap.get(entrepriseURL);
		if(e != null)
		{
			annonce.setEnterprise(e);
		}
		else
		{
			e = EnterpriseLoad.extract(entrepriseURL);
			annonce.setEnterprise(e);
			EnterpriseOffersSouping.entreprisesMap.put(entrepriseURL, e);
		}
		
		
		// Capture de la description du JOB de l'offre :
		annonce.setDescJob(dom.selectElementFromHTML("div.jobs-ad-details > div > div.content.clearfix > div:not(.job-ad-separator)", "Poste proposé : "));
		
		// Capture de la description du Profile de l'offre :
		annonce.setDescProfil(dom.selectElementFromHTML("div.jobs-ad-details > div > div.content.clearfix > div:not(.job-ad-separator)", "Profil recherché pour le poste : "));
		
		// Capture Niveau d'Experience de l'offre :
		annonce.setLevelXp(dom.selectTextFromHTML("div.field-name-field-offre-niveau-experience"));
		
		// Capture des niveau d'etudes de l'offre : 
		annonce.setLevelStudy(dom.selectTextFromHTML("div.field-name-field-offre-niveau-etude"));
		
		// SAVE RECEPTACLE :
		ctxOffer.save(annonce);
		
		// Capture des villes de l'offre :
		for (String c : dom.selectElementsFromHTMLParsed("div.field-name-field-offre-region > div.field-items > div.field-item")) 
		{
			ctxCity.save(new OfferCity(annonce, c));
		}
		
		
		// Capture des contrats de l'offre :
		for (String c : dom.selectElementsFromHTML("div.field-name-field-offre-contrat-type  > div.field-items > div.field-item")) 
		{
			ctxContrat.save(new OfferContrat(annonce, c));
		}
		
		
		// Capture des métiers de l'offre :
		for (String j : dom.selectElementsFromHTMLParsed("div.field-name-field-offre-metiers > div.field-items > div.field-item")) 
		{
			ctxJob.save(new OfferJob(annonce, j));
		}
		
		// Capture des secteurs d'Activités de l'offre :
		for (String sector : dom.selectElementsFromHTMLParsed("div.field-name-field-offre-secteur > div.field-items > div.field-item")) 
		{
			ctxActivity.save(new OfferActivitySector(annonce, sector));
		}
		
		
		// Capture des secteurs d'Activités de l'offre :
		for (Element elem : dom.getDocument().select("div.field-name-field-offre-niveau-langue > div.field-items > div.field-item")) 
		{

			LangageRequirement lr = new LangageRequirement(
															annonce, 
															elem.select("span.lineage-item-level-0").html(),
															elem.select("span.lineage-item-level-1").html()
														  );
			ctxLanage.save(lr);
			

		}
		
		// SAVE RECEPTACLE :
		ctxOffer.save(annonce);
		
		return annonce;
	}

}
