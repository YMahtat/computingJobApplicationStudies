package org.emsi.jobapplications.models.others;

import javax.persistence.Column;

public class GroupByResult 
{
	
	private String key;
	private Long count;
	
	
	public GroupByResult(String key, Long count) 
	{
		super();
		this.key = key;
		this.count = count;
	}


	public GroupByResult() 
	{
		super();
	}

	public String getKey() {
		return key;
	}

	
	public void setKey(String key) {
		this.key = key;
	}

	public Long getCount() {
		return count;
	}


	public void setCount(Long count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return key + "  ->   count=" + count;
	}
	
	
	
	
	
	
	
	
	

}
