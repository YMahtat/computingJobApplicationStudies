package org.emsi.jobapplications.models.offers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enterprise_country", catalog = "jobstudy_offers")
public class EnterpriseCountry implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Enterprise enterprise;
	private String country;

	public EnterpriseCountry() {
	}

	public EnterpriseCountry(Enterprise enterprise, String country) {
		this.enterprise = enterprise;
		this.country = country;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "enterprise_id", nullable = false)
	public Enterprise getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@Column(name = "country", nullable = false)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
