package org.emsi.jobapplications.models.others;

public class Distribution 
{
	private String Key;
	private Long countOffers;
	private Long countJobSeekers;
	
	public Distribution(String key, Long countOffers, Long countJobSeekers) 
	{
		super();
		Key = key;
		this.countOffers = countOffers;
		this.countJobSeekers = countJobSeekers;
	}

	public Distribution() 
	{
		super();
	}

	public String getKey() 
	{
		return Key;
	}

	public void setKey(String key) 
	{
		Key = key;
	}

	public Long getCountOffers() 
	{
		return countOffers;
	}

	public void setCountOffers(Long countOffers) 
	{
		this.countOffers = countOffers;
	}

	public Long getCountJobSeekers() 
	{
		return countJobSeekers;
	}

	public void setCountJobSeekers(Long countJobSeekers) 
	{
		this.countJobSeekers = countJobSeekers;
	}
	
	
	
	
	
	

}
