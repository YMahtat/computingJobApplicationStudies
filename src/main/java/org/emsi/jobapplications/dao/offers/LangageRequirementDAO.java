package org.emsi.jobapplications.dao.offers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.offers.LangageRequirement;
import org.emsi.jobapplications.models.others.langueOfferCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LangageRequirementDAO extends JpaRepository<LangageRequirement, Integer> 
{
		
	@Query("SELECT new org.emsi.jobapplications.models.others.langueOfferCount(l, count(l)) FROM LangageRequirement l group by langage order by count(l) desc ")
	ArrayList<langueOfferCount> findAllOfferLangageRequirement();
}
