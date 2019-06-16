package org.emsi.jobapplications.dao.jobseekers;

import java.util.ArrayList;

import org.emsi.jobapplications.models.jobseekers.JobseekerCity;
import org.emsi.jobapplications.models.others.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobseekerCityDAO extends JpaRepository<JobseekerCity, Integer> 
{
	@Query("SELECT new org.emsi.jobapplications.models.others.Cities(city) FROM JobseekerCity js group by city order by city")
	ArrayList<Cities> findAllCities();
	ArrayList<JobseekerCity> findAllByCity(String city);
	
}
