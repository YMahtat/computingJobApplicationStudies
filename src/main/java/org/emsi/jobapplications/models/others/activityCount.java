package org.emsi.jobapplications.models.others;

import org.emsi.jobapplications.models.offers.OfferActivitySector;

public class activityCount {
		
	
	private Long count;
	private OfferActivitySector actSector;
	public activityCount(OfferActivitySector actSector,Long count) {
		super();
		this.count = count;
		this.actSector = actSector;
	}
	public activityCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public OfferActivitySector getActSector() {
		return actSector;
	}
	public void setActSector(OfferActivitySector actSector) {
		this.actSector = actSector;
	}
	@Override
	public String toString() {
		return "activityCount [count=" + count + ", actSector=" + actSector + "]";
	}
	
	
	
}
