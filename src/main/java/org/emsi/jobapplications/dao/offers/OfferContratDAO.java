package org.emsi.jobapplications.dao.offers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.offers.OfferContrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferContratDAO extends JpaRepository<OfferContrat, Integer> 
{
	ArrayList<OfferContrat> findAllByContrat(String Contrat);
	

}
