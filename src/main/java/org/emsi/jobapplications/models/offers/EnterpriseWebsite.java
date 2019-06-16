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
@Table(name = "enterprise_website", catalog = "jobstudy_offers")
public class EnterpriseWebsite implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Enterprise enterprise;
	private String website;

	public EnterpriseWebsite() {
	}

	public EnterpriseWebsite(Enterprise enterprise, String website) {
		this.enterprise = enterprise;
		this.website = website;
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

	@Column(name = "website", nullable = false)
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
