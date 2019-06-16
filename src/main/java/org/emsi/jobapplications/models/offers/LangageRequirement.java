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
@Table(name = "langage_requirement", catalog = "jobstudy_offers")
public class LangageRequirement implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Offer offer;
	private String langage;
	private String requirement;

	public LangageRequirement() {
	}

	public LangageRequirement(Offer offer, String langage, String requirement) {
		this.offer = offer;
		this.langage = langage;
		this.requirement = requirement;
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
	@JoinColumn(name = "offer_id", nullable = false)
	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@Column(name = "langage", nullable = false)
	public String getLangage() {
		return this.langage;
	}

	public void setLangage(String langage) {
		this.langage = langage;
	}

	@Column(name = "requirement", nullable = false)
	public String getRequirement() {
		return this.requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

}
