package org.emsi.jobapplications.dao.jobseekers;

import org.emsi.jobapplications.models.jobseekers.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeDAO extends JpaRepository<Knowledge, Integer> 
{

}
