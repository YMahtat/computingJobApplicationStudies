package org.emsi.jobapplications.dao.jobseekers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.jobseekers.JobseekerContrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobseekerContratDAO extends JpaRepository<JobseekerContrat, Integer> 
{
	ArrayList<JobseekerContrat> findAllByContrat(String Contrat);
}
