package org.emsi.jobapplications.dao.offers;

import java.util.ArrayList;



import org.emsi.jobapplications.models.offers.Offer;
import org.emsi.jobapplications.models.others.Cities;
import org.emsi.jobapplications.models.others.GroupByResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OfferDAO extends JpaRepository<Offer, Integer> 
{
	@Query("SELECT new org.emsi.jobapplications.models.others.Cities(descJob) FROM Offer")
	ArrayList<Cities> findAllDescJob();
	
	@Query("SELECT count(o) FROM Offer o WHERE o.levelStudy = :level")
	int countGroupByLevelStudy(@Param("level") String level);
	
	@Query("SELECT count(o) FROM Offer o WHERE o.levelXp = :level")
	int countGroupByLevelXP(@Param("level") String level);
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(o.levelStudy, count(o)) FROM Offer o GROUP BY o.levelStudy")
	ArrayList<GroupByResult> countGroupByAllLevelStudy();
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(o.levelXp, count(o)) FROM Offer o GROUP BY o.levelXp")
	ArrayList<GroupByResult> countGroupByAllLevelXP();
	
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(tab.activity, count(o)) from Offer o INNER JOIN o.offerActivitySectors tab GROUP BY tab.activity")
	ArrayList<GroupByResult> countGroupByAllSector();
	
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(tab.contrat, count(o)) from Offer o INNER JOIN o.offerContrats tab GROUP BY tab.contrat")
	ArrayList<GroupByResult> countGroupByAllContract();
	
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(tab.city, count(o)) from Offer o INNER JOIN o.offerCities tab GROUP BY tab.city")
	ArrayList<GroupByResult> countGroupByAllCity();
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(tab.job, count(o)) from Offer o INNER JOIN o.offerJobs tab GROUP BY tab.job")
	ArrayList<GroupByResult> countGroupByAllJob();
	
	@Query(nativeQuery = true, value = "SELECT * from Offer o ORDER BY o.offer_date desc LIMIT :nbr")
	ArrayList<Offer> findLastOffers(@Param("nbr") Long nbr);
	
}
