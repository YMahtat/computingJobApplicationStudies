package org.emsi.jobapplications.models.jobseekers;


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
@Table(name = "knowledge", catalog = "jobstudy_jobseekers")
public class Knowledge implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Jobseeker jobseeker;
	private String title;
	private String establishment;
	private String description;
	private Integer startingYear;
	private Integer startingMonth;
	private Integer endingYear;
	private Integer endingMonth;

	public Knowledge() {
	}

	public Knowledge(Jobseeker jobseeker, String title) {
		this.jobseeker = jobseeker;
		this.title = title;
	}

	public Knowledge(Jobseeker jobseeker, String title, String establishment, String description, Integer startingYear,
			Integer startingMonth, Integer endingYear, Integer endingMonth) {
		this.jobseeker = jobseeker;
		this.title = title;
		this.establishment = establishment;
		this.description = description;
		this.startingYear = startingYear;
		this.startingMonth = startingMonth;
		this.endingYear = endingYear;
		this.endingMonth = endingMonth;
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
	@JoinColumn(name = "Jobseeker_id", nullable = false)
	public Jobseeker getJobseeker() {
		return this.jobseeker;
	}

	public void setJobseeker(Jobseeker jobseeker) {
		this.jobseeker = jobseeker;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "establishment")
	public String getEstablishment() {
		return this.establishment;
	}

	public void setEstablishment(String establishment) {
		this.establishment = establishment;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "StartingYear")
	public Integer getStartingYear() {
		return this.startingYear;
	}

	public void setStartingYear(Integer startingYear) {
		this.startingYear = startingYear;
	}

	@Column(name = "StartingMonth")
	public Integer getStartingMonth() {
		return this.startingMonth;
	}

	public void setStartingMonth(Integer startingMonth) {
		this.startingMonth = startingMonth;
	}

	@Column(name = "EndingYear")
	public Integer getEndingYear() {
		return this.endingYear;
	}

	public void setEndingYear(Integer endingYear) {
		this.endingYear = endingYear;
	}

	@Column(name = "EndingMonth")
	public Integer getEndingMonth() {
		return this.endingMonth;
	}

	public void setEndingMonth(Integer endingMonth) {
		this.endingMonth = endingMonth;
	}

}
