package org.emsi.jobapplications.algo.algoCollections;

import java.util.HashSet;
import java.util.List;

import org.emsi.jobapplications.models.jobseekers.JobseekerContrat;
import org.emsi.jobapplications.models.offers.EnterpriseActivitySector;
import org.emsi.jobapplications.models.offers.OfferContrat;

public class Collector 
{
	
	public static HashSet<String> SelectDistinctActivity(List<EnterpriseActivitySector> Js)
	{
		HashSet<String> hs=new HashSet<String>();
		for(EnterpriseActivitySector J: Js) 
		{
			hs.add(J.getActivity());
		}
		return hs;
	}
	
	public static HashSet<String> SelectDistinctContrat(List<OfferContrat> Cnt)
	{
		HashSet<String> hs=new HashSet<String>();
		for(OfferContrat C: Cnt) 
		{
			hs.add(C.getContrat());
		}
		return hs;
	}
	
	public static HashSet<String> SelectDistinctJobseekerContrat(List<JobseekerContrat> Cnt)
	{
		HashSet<String> hs=new HashSet<String>();
		for(JobseekerContrat C: Cnt) 
		{
			hs.add(C.getContrat());
		}
		return hs;
	}

}
