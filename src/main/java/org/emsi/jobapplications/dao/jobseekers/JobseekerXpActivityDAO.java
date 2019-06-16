package org.emsi.jobapplications.dao.jobseekers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.jobseekers.JobseekerXpActivity;
import org.emsi.jobapplications.models.others.JobseekerActivitySectorCount;
import org.emsi.jobapplications.models.others.activityCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobseekerXpActivityDAO extends JpaRepository<JobseekerXpActivity, Integer> 
{
	
	@Query("SELECT new org.emsi.jobapplications.models.others.JobseekerActivitySectorCount(js, count(js)) FROM JobseekerXpActivity js group by activity order by count(js) desc ")
	ArrayList<JobseekerActivitySectorCount> findAllOfferXpActivitySorted();

}
