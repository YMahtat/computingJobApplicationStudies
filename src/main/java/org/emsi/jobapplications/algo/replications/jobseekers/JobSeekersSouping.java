package org.emsi.jobapplications.algo.replications.jobseekers;

import java.io.IOException;

import org.jsoup.nodes.Element;

import org.emsi.jobapplications.algo.replications.dom.DOMLoad;
import org.emsi.jobapplications.algo.replications.dom.DOMType;
import org.emsi.jobapplications.algo.replications.dom.SpecialDocument;

public class JobSeekersSouping 
{
	
	public static boolean LoadJobSeekersPage(int pageNumber) throws IOException
	{
		SpecialDocument dom = DOMLoad.getPage(DOMType.jobSeekersPage, pageNumber);
		boolean isExtracting = true;
		for (Element elem : dom.getDocument().select("div.job-title > h5 > a")) 
		{
			String JobSeekerURL = elem.attr("href");
			System.out.println(JobSeekerURL);
			isExtracting =  (JobSeekerLoad.extract(JobSeekerURL) != null);
			
		}
		
		return isExtracting;
	}
	
	public static void extractJobSeekers() throws IOException
	{
		int pageNum = 0;
		System.out.println("Page Number : " + (pageNum+1) );
		SpecialDocument dom = DOMLoad.getPage(DOMType.jobSeekersPage, pageNum);
		while(dom != null)
		{
			if( ! LoadJobSeekersPage(pageNum) )
			{
				break;
			}
			pageNum++;
			System.out.println("Page Number : " + (pageNum+1) );
			dom = DOMLoad.getPage(DOMType.jobSeekersPage, pageNum);
		}
	}

}
