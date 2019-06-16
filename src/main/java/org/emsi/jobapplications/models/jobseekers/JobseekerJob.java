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
@Table(name = "jobseeker_job", catalog = "jobstudy_jobseekers")
public class JobseekerJob implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Jobseeker jobseeker;
	private String job;

	public JobseekerJob() {
	}

	public JobseekerJob(Jobseeker jobseeker, String job) {
		this.jobseeker = jobseeker;
		this.job = job;
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

	@Column(name = "job", nullable = false)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
