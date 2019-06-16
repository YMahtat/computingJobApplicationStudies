package org.emsi.jobapplications.models.offers;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "offer", catalog = "jobstudy_offers")
public class Offer implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Enterprise enterprise;
	private String title;
	private Date offerDate;
	private String descJob;
	private String descProfil;
	private String levelXp;
	private String levelStudy;
	private Set<OfferActivitySector> offerActivitySectors = new HashSet<OfferActivitySector>(0);
	private Set<LangageRequirement> langageRequirements = new HashSet<LangageRequirement>(0);
	private Set<OfferCity> offerCities = new HashSet<OfferCity>(0);
	private Set<OfferJob> offerJobs = new HashSet<OfferJob>(0);
	private Set<OfferContrat> offerContrats = new HashSet<OfferContrat>(0);

	public Offer() {
	}

	public Offer(Enterprise enterprise, String title, Date offerDate, String descJob, String descProfil, String levelXp,
			String levelStudy) {
		this.enterprise = enterprise;
		this.title = title;
		this.offerDate = offerDate;
		this.descJob = descJob;
		this.descProfil = descProfil;
		this.levelXp = levelXp;
		this.levelStudy = levelStudy;
	}

	public Offer(Enterprise enterprise, String title, Date offerDate, String descJob, String descProfil, String levelXp,
			String levelStudy, Set<OfferActivitySector> offerActivitySectors,
			Set<LangageRequirement> langageRequirements, Set<OfferCity> offerCities, Set<OfferJob> offerJobs,
			Set<OfferContrat> offerContrats) {
		this.enterprise = enterprise;
		this.title = title;
		this.offerDate = offerDate;
		this.descJob = descJob;
		this.descProfil = descProfil;
		this.levelXp = levelXp;
		this.levelStudy = levelStudy;
		this.offerActivitySectors = offerActivitySectors;
		this.langageRequirements = langageRequirements;
		this.offerCities = offerCities;
		this.offerJobs = offerJobs;
		this.offerContrats = offerContrats;
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

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "offer_date", nullable = false)
	public Date getOfferDate() {
		return this.offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}

	@Column(name = "desc_Job", nullable = false)
	public String getDescJob() {
		return this.descJob;
	}

	public void setDescJob(String descJob) {
		this.descJob = descJob;
	}

	@Column(name = "desc_Profil", nullable = false)
	public String getDescProfil() {
		return this.descProfil;
	}

	public void setDescProfil(String descProfil) {
		this.descProfil = descProfil;
	}

	@Column(name = "level_XP", nullable = false)
	public String getLevelXp() {
		return this.levelXp;
	}

	public void setLevelXp(String levelXp) {
		this.levelXp = levelXp;
	}

	@Column(name = "level_Study", nullable = false)
	public String getLevelStudy() {
		return this.levelStudy;
	}

	public void setLevelStudy(String levelStudy) {
		this.levelStudy = levelStudy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
	public Set<OfferActivitySector> getOfferActivitySectors() {
		return this.offerActivitySectors;
	}

	public void setOfferActivitySectors(Set<OfferActivitySector> offerActivitySectors) {
		this.offerActivitySectors = offerActivitySectors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
	public Set<LangageRequirement> getLangageRequirements() {
		return this.langageRequirements;
	}

	public void setLangageRequirements(Set<LangageRequirement> langageRequirements) {
		this.langageRequirements = langageRequirements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
	public Set<OfferCity> getOfferCities() {
		return this.offerCities;
	}

	public void setOfferCities(Set<OfferCity> offerCities) {
		this.offerCities = offerCities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
	public Set<OfferJob> getOfferJobs() {
		return this.offerJobs;
	}

	public void setOfferJobs(Set<OfferJob> offerJobs) {
		this.offerJobs = offerJobs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
	public Set<OfferContrat> getOfferContrats() {
		return this.offerContrats;
	}

	public void setOfferContrats(Set<OfferContrat> offerContrats) {
		this.offerContrats = offerContrats;
	}

}
