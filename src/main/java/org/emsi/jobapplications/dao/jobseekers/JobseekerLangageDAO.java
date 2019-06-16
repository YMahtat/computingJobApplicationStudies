package org.emsi.jobapplications.dao.jobseekers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.jobseekers.JobseekerLangage;
import org.emsi.jobapplications.models.others.JobseekerLangageCount;
import org.emsi.jobapplications.models.others.langueOfferCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobseekerLangageDAO extends JpaRepository<JobseekerLangage, Integer> 
{
	@Query("SELECT new org.emsi.jobapplications.models.others.JobseekerLangageCount(jsl, count(jsl)) FROM JobseekerLangage jsl group by langage order by count(jsl) desc")
	ArrayList<JobseekerLangageCount> findAllJobseekerLangage();
}
