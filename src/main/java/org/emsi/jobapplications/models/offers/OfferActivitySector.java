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
@Table(name = "offer_activity_sector", catalog = "jobstudy_offers")
public class OfferActivitySector implements java.io.Serializable 
{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Offer offer;
	private String activity;

	public OfferActivitySector() {
	}

	public OfferActivitySector(Offer offer, String activity) {
		this.offer = offer;
		this.activity = activity;
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

	@Column(name = "activity", nullable = false)
	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}
