package org.emsi.jobapplications.dao.offers;

import java.util.List;

import org.emsi.jobapplications.models.offers.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseDAO extends JpaRepository<Enterprise, Integer> 
{
	
	List<Enterprise> findAllByName(String Name);

}
