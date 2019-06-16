package org.emsi.jobapplications.dao.offers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.offers.OfferCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferCityDAO extends JpaRepository<OfferCity, Integer> 
{
	ArrayList<String> findAllByCity(String city);
}
