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
@Table(name = "jobseeker_langage", catalog = "jobstudy_jobseekers")
public class JobseekerLangage implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Jobseeker jobseeker;
	private String langage;

	public JobseekerLangage() {
	}

	public JobseekerLangage(Jobseeker jobseeker, String langage) {
		this.jobseeker = jobseeker;
		this.langage = langage;
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

	@Column(name = "langage", nullable = false)
	public String getLangage() {
		return this.langage;
	}

	public void setLangage(String langage) {
		this.langage = langage;
	}

}
