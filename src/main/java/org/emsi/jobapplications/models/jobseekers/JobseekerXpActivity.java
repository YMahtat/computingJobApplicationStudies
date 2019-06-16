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
@Table(name = "jobseeker_xp_activity", catalog = "jobstudy_jobseekers")
public class JobseekerXpActivity implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Jobseeker jobseeker;
	private String activity;

	public JobseekerXpActivity() {
	}

	public JobseekerXpActivity(Jobseeker jobseeker, String activity) {
		this.jobseeker = jobseeker;
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
	@JoinColumn(name = "Jobseeker_id", nullable = false)
	public Jobseeker getJobseeker() {
		return this.jobseeker;
	}

	public void setJobseeker(Jobseeker jobseeker) {
		this.jobseeker = jobseeker;
	}

	@Column(name = "activity", nullable = false)
	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}
