package org.emsi.jobapplications.algo.replications.offers;

import org.emsi.jobapplications.models.offers.Enterprise;
import org.emsi.jobapplications.models.offers.EnterpriseActivitySector;
import org.emsi.jobapplications.models.offers.EnterpriseCity;
import org.emsi.jobapplications.models.offers.EnterpriseCountry;
import org.emsi.jobapplications.models.offers.EnterpriseWebsite;

import java.io.IOException;
import java.util.List;

import org.emsi.jobapplications.algo.replications.dom.DOMLoad;
import org.emsi.jobapplications.algo.replications.dom.DOMType;
import org.emsi.jobapplications.algo.replications.dom.SpecialDocument;
import org.emsi.jobapplications.dao.offers.EnterpriseActivitySectorDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseCityDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseCountryDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseDAO;
import org.emsi.jobapplications.dao.offers.EnterpriseWebsiteDAO;
import org.emsi.jobapplications.dao.others.ContextDAO;

public class EnterpriseLoad 
{
	static EnterpriseDAO ctxEnterprise = ContextDAO.ctx.getBean(EnterpriseDAO.class);
	
	static EnterpriseActivitySectorDAO ctxActivity = ContextDAO.ctx.getBean(EnterpriseActivitySectorDAO.class);
	
	static EnterpriseCityDAO ctxCity = ContextDAO.ctx.getBean(EnterpriseCityDAO.class);
	
	static EnterpriseCountryDAO ctxCountry = ContextDAO.ctx.getBean(EnterpriseCountryDAO.class);
	
	static EnterpriseWebsiteDAO ctxWebSite = ContextDAO.ctx.getBean(EnterpriseWebsiteDAO.class);
	
	public static Enterprise extract(String entrepriseURL) throws IOException
	{	
		
		
		// Chargement du DOM(HTML) de la page entreprise à extraire :
		SpecialDocument dom = DOMLoad.getPage(DOMType.enterprise, entrepriseURL);
		
		// Chercher dans la base de données si l'entreprise existe
		List<Enterprise> listCompany = (List<Enterprise>) ctxEnterprise.findAllByName(dom.selectTextFromHTML("h1.title"));
		if(listCompany != null && listCompany.size() > 0)
		{
			// Si oui retourner l'objet déjà stocké
			return listCompany.get(0);
		}
		
		// Sinon extrait l'objet du site
		
		// Instanciation du nouveau objet récéptacle de l'entreprise à extraire :
		Enterprise company = new Enterprise();

		
		// Capture du Nom de l'entreprise :
		company.setName(dom.selectTextFromHTML("h1.title"));
		
		// Capture de la description de l'entreprise :
		company.setDescription(dom.selectTextFromHTML("div.company-profile-description :not(.company-profile-label)"));
		
		// SAVE RECEPTACLE :
		ctxEnterprise.save(company);
		
		// Capture des Pays où se trouve de l'entreprise :
		for (String pays : dom.selectElementsFromSimpleHTML("div.field-name-field-recruteur-pays div.field-item"))
		{
			ctxCountry.save(new EnterpriseCountry(company, pays));
		}
		
		// Capture des villes où se trouve l'entreprise :
		for (String city: dom.selectElementsFromSimpleHTML("div.field-name-field-recruteur-ville div.field-item"))
		{
			ctxCity.save(new EnterpriseCity(company, city));
		}
		
		// Capture des siteweb de l'entreprise :
		for (String siteweb : dom.selectElementsFromSimpleHTML("div.field-name-field-entreprise-site div.field-item"))
		{
			if(!siteweb.equals("")) ctxWebSite.save(new EnterpriseWebsite(company, siteweb));
		}
		
		// Capture des Secteurs d'activités de l'entreprise :
		for (String secteur : dom.selectElementsFromHTML("div.field-name-field-entreprise-secteur div.field-item"))
		{
			ctxActivity.save(new EnterpriseActivitySector(company, secteur));
		}
		
		// RESAVE RECEPTACLE :
		ctxEnterprise.save(company);

		
		return company;
	}

}



