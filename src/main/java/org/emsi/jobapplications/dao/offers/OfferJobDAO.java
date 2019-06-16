package org.emsi.jobapplications.dao.offers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.offers.OfferJob;
import org.emsi.jobapplications.models.others.GroupByResult;
import org.emsi.jobapplications.models.others.OfferJobCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OfferJobDAO extends JpaRepository<OfferJob, Integer> 
{
	
	
	@Query("SELECT new org.emsi.jobapplications.models.others.OfferJobCount(o.job, count(o)) from OfferJob o GROUP BY o.job")
	ArrayList<OfferJobCount> countOfferJob();

}
