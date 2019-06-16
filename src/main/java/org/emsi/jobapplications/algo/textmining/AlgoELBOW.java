package org.emsi.jobapplications.algo.textmining;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.emsi.jobapplications.dao.offers.OfferDAO;
import org.emsi.jobapplications.dao.others.ContextDAO;
import org.emsi.jobapplications.models.offers.Offer;

public class AlgoELBOW 
{
	static OfferDAO ctxOffer = ContextDAO.ctx.getBean(OfferDAO.class);
	
	public static void executeMatrixOffer(ServletContext context) throws IOException, InterruptedException
	{
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		ArrayList<Offer> list = (ArrayList<Offer>) ctxOffer.findAll();
		ArrayList<String> descriptions = new ArrayList<String>();
		list.forEach(e -> {descriptions.add(e.getDescJob());});
		CleanedMatrix matrix = new CleanedMatrix(descriptions);
		Process p = Runtime.getRuntime().exec("Rscript CodeR_ELBOW.r", null, new File(s + "\\target\\classes\\static\\algoScripts\\"));
		int codeRetour = p.waitFor();
		System.out.println("Return Rscript : " + codeRetour);
	}

}
