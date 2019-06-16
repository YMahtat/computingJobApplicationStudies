package org.emsi.jobapplications.models.offers;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "enterprise", catalog = "jobstudy_offers")
public class Enterprise implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String description;
	private Set<EnterpriseCity> enterpriseCities = new HashSet<EnterpriseCity>(0);
	private Set<EnterpriseActivitySector> enterpriseActivitySectors = new HashSet<EnterpriseActivitySector>(0);
	private Set<EnterpriseWebsite> enterpriseWebsites = new HashSet<EnterpriseWebsite>(0);
	private Set<EnterpriseCountry> enterpriseCountries = new HashSet<EnterpriseCountry>(0);
	private Set<Offer> offers = new HashSet<Offer>(0);

	public Enterprise() {
	}

	public Enterprise(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Enterprise(String name, String description, Set<EnterpriseCity> enterpriseCities,
			Set<EnterpriseActivitySector> enterpriseActivitySectors, Set<EnterpriseWebsite> enterpriseWebsites,
			Set<EnterpriseCountry> enterpriseCountries, Set<Offer> offers) {
		this.name = name;
		this.description = description;
		this.enterpriseCities = enterpriseCities;
		this.enterpriseActivitySectors = enterpriseActivitySectors;
		this.enterpriseWebsites = enterpriseWebsites;
		this.enterpriseCountries = enterpriseCountries;
		this.offers = offers;
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise")
	public Set<EnterpriseCity> getEnterpriseCities() {
		return this.enterpriseCities;
	}

	public void setEnterpriseCities(Set<EnterpriseCity> enterpriseCities) {
		this.enterpriseCities = enterpriseCities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise")
	public Set<EnterpriseActivitySector> getEnterpriseActivitySectors() {
		return this.enterpriseActivitySectors;
	}

	public void setEnterpriseActivitySectors(Set<EnterpriseActivitySector> enterpriseActivitySectors) {
		this.enterpriseActivitySectors = enterpriseActivitySectors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise")
	public Set<EnterpriseWebsite> getEnterpriseWebsites() {
		return this.enterpriseWebsites;
	}

	public void setEnterpriseWebsites(Set<EnterpriseWebsite> enterpriseWebsites) {
		this.enterpriseWebsites = enterpriseWebsites;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise")
	public Set<EnterpriseCountry> getEnterpriseCountries() {
		return this.enterpriseCountries;
	}

	public void setEnterpriseCountries(Set<EnterpriseCountry> enterpriseCountries) {
		this.enterpriseCountries = enterpriseCountries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise")
	public Set<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

}
