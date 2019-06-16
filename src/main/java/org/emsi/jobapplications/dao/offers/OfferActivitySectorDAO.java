package org.emsi.jobapplications.dao.offers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.offers.OfferActivitySector;
import org.emsi.jobapplications.models.offers.OfferContrat;
import org.emsi.jobapplications.models.others.activityCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OfferActivitySectorDAO extends JpaRepository<OfferActivitySector, Integer> 
{

	@Query("SELECT new org.emsi.jobapplications.models.others.activityCount(o, count(o)) FROM OfferActivitySector o group by activity order by count(o) desc ")
	ArrayList<activityCount> findAllOfferActivitySorted();
	
}
