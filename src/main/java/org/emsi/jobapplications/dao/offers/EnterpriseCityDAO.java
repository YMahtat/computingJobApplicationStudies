package org.emsi.jobapplications.dao.offers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.offers.EnterpriseCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseCityDAO extends JpaRepository<EnterpriseCity, Integer> 
{
	ArrayList<String> findAllByCity(String city);
}
