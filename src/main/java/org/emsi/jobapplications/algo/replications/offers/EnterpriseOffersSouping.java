package org.emsi.jobapplications.algo.replications.offers;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import org.jsoup.nodes.Element;

import org.emsi.jobapplications.algo.replications.dom.DOMLoad;
import org.emsi.jobapplications.algo.replications.dom.DOMType;
import org.emsi.jobapplications.algo.replications.dom.SpecialDocument;
import org.emsi.jobapplications.models.offers.Enterprise;

public class EnterpriseOffersSouping 
{
	public static HashMap<String, Enterprise> entreprisesMap = new HashMap<String, Enterprise>();
	
	public static void LoadOffersPage(int pageNumber) throws IOException, ParseException
	{
		SpecialDocument dom = DOMLoad.getPage(DOMType.offersPage, pageNumber);
		for (Element elem : dom.getDocument().select("div.job-title > h5 > a")) 
		{
			String offerURL = elem.attr("href");
			System.out.println(offerURL);
			OfferLoad.extract(offerURL);
		}
	}
	
	public static void extractOffers() throws IOException, ParseException
	{
		int pageNum = 0;
		System.out.println("Page Number : " + (pageNum+1) );
		SpecialDocument dom = DOMLoad.getPage(DOMType.offersPage, pageNum);
		while(dom != null)
		{
			LoadOffersPage(pageNum);
			pageNum++;
			System.out.println("Page Number : " + (pageNum+1) );
			dom = DOMLoad.getPage(DOMType.offersPage, pageNum);
		}
	}

}
