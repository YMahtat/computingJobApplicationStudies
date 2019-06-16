package org.emsi.jobapplications.models.others;

public class OfferJobCount {

	String key;
	Long value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public OfferJobCount(String key, Long value) {
		super();
		this.key = key;
		this.value = value;
	}
	public OfferJobCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "{key=" + key + ", value=" + value + "";
	}
	
	
	
	
	
}
