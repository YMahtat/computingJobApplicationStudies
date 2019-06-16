package org.emsi.jobapplications.dao.jobseekers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.jobseekers.Jobseeker;
import org.emsi.jobapplications.models.offers.Offer;
import org.emsi.jobapplications.models.others.GroupByResult;
import org.emsi.jobapplications.models.others.JobSeekerLevelCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobseekerDAO extends JpaRepository<Jobseeker, Integer> 
{
	@Query("SELECT count(js) FROM Jobseeker js WHERE js.levelStudy = :level")
	int countGroupByLevelStudy(@Param("level") String level);
	
	@Query("SELECT count(js) FROM Jobseeker js WHERE js.globaleLevel = :level")
	int countGroupByLevelXP(@Param("level") String level);
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(js.levelStudy, count(js)) FROM Jobseeker js GROUP BY js.levelStudy")
	ArrayList<GroupByResult> countGroupByAllLevelStudy();
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(js.globaleLevel, count(js)) FROM Jobseeker js GROUP BY js.globaleLevel")
	ArrayList<GroupByResult> countGroupByAllLevelXP();
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(tab.activity, count(js)) from Jobseeker js INNER JOIN js.jobseekerXpActivities tab GROUP BY tab.activity")
	ArrayList<GroupByResult> countGroupByAllSector();
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(tab.contrat, count(js)) from Jobseeker js INNER JOIN js.jobseekerContrats tab GROUP BY tab.contrat")
	ArrayList<GroupByResult> countGroupByAllContract();
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(tab.city, count(js)) from Jobseeker js INNER JOIN js.jobseekerCities tab GROUP BY tab.city")
	ArrayList<GroupByResult> countGroupByAllCity();
	
	@Query("SELECT new org.emsi.jobapplications.models.others.GroupByResult(tab.job, count(js)) from Jobseeker js INNER JOIN js.jobseekerJobs tab GROUP BY tab.job")
	ArrayList<GroupByResult> countGroupByAllJob();
	
	@Query(nativeQuery = true, value = "SELECT * from jobseeker js ORDER BY js.offer_date desc LIMIT :nbr")
	ArrayList<Offer> findLastJobssekers(@Param("nbr") Long nbr);
	
	@Query("SELECT new org.emsi.jobapplications.models.others.JobSeekerLevelCount(js, count(js)) FROM Jobseeker js group by level_Study ")
	ArrayList<JobSeekerLevelCount> findJobseekerGroupByLevelStudy();
	
	@Query("SELECT js.levelStudy FROM Jobseeker js group by js.levelStudy ")
	ArrayList<String> findAllGroupByLevelStudy();
	


}
