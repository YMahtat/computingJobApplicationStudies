package org.emsi.jobapplications.dao.jobseekers;

import org.emsi.jobapplications.models.jobseekers.JobseekerJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobseekerJobDAO extends JpaRepository<JobseekerJob, Integer> 
{

}
