package org.emsi.jobapplications.models.others;

public class Cities {
	String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Cities(String city) {
		super();
		this.city = city;
	}

	public Cities() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cities [city=" + city + "]";
	}
	
	
	
	
}
