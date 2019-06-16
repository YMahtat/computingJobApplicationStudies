package org.emsi.jobapplications.models.others;

import org.emsi.jobapplications.models.offers.LangageRequirement;

public class langueOfferCount {

	LangageRequirement langage;
	Long count;
	public langueOfferCount(LangageRequirement langage, Long count) {
		super();
		this.langage = langage;
		this.count = count;
	}
	public langueOfferCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LangageRequirement getLangage() {
		return langage;
	}
	public void setLangage(LangageRequirement langage) {
		this.langage = langage;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
