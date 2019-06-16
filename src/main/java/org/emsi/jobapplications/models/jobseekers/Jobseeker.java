package org.emsi.jobapplications.models.jobseekers;


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
@Table(name = "jobseeker", catalog = "jobstudy_jobseekers")
public class Jobseeker implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String levelStudy;
	private String globaleLevel;
	private String disponibilty;
	private String skills;
	private String cityHome;
	private Set<JobseekerContrat> jobseekerContrats = new HashSet<JobseekerContrat>(0);
	private Set<JobseekerJob> jobseekerJobs = new HashSet<JobseekerJob>(0);
	private Set<JobseekerCity> jobseekerCities = new HashSet<JobseekerCity>(0);
	private Set<Knowledge> knowledges = new HashSet<Knowledge>(0);
	private Set<JobseekerLangage> jobseekerLangages = new HashSet<JobseekerLangage>(0);
	private Set<JobseekerXpActivity> jobseekerXpActivities = new HashSet<JobseekerXpActivity>(0);

	public Jobseeker() {
	}

	public Jobseeker(String levelStudy, String globaleLevel, String disponibilty, String skills, String cityHome,
			Set<JobseekerContrat> jobseekerContrats, Set<JobseekerJob> jobseekerJobs,
			Set<JobseekerCity> jobseekerCities, Set<Knowledge> knowledges, Set<JobseekerLangage> jobseekerLangages,
			Set<JobseekerXpActivity> jobseekerXpActivities) {
		this.levelStudy = levelStudy;
		this.globaleLevel = globaleLevel;
		this.disponibilty = disponibilty;
		this.skills = skills;
		this.cityHome = cityHome;
		this.jobseekerContrats = jobseekerContrats;
		this.jobseekerJobs = jobseekerJobs;
		this.jobseekerCities = jobseekerCities;
		this.knowledges = knowledges;
		this.jobseekerLangages = jobseekerLangages;
		this.jobseekerXpActivities = jobseekerXpActivities;
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

	@Column(name = "level_Study")
	public String getLevelStudy() {
		return this.levelStudy;
	}

	public void setLevelStudy(String levelStudy) {
		this.levelStudy = levelStudy;
	}

	@Column(name = "globale_Level")
	public String getGlobaleLevel() {
		return this.globaleLevel;
	}

	public void setGlobaleLevel(String globaleLevel) {
		this.globaleLevel = globaleLevel;
	}

	@Column(name = "disponibilty")
	public String getDisponibilty() {
		return this.disponibilty;
	}

	public void setDisponibilty(String disponibilty) {
		this.disponibilty = disponibilty;
	}

	@Column(name = "skills")
	public String getSkills() {
		return this.skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Column(name = "city_Home")
	public String getCityHome() {
		return this.cityHome;
	}

	public void setCityHome(String cityHome) {
		this.cityHome = cityHome;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobseeker")
	public Set<JobseekerContrat> getJobseekerContrats() {
		return this.jobseekerContrats;
	}

	public void setJobseekerContrats(Set<JobseekerContrat> jobseekerContrats) {
		this.jobseekerContrats = jobseekerContrats;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobseeker")
	public Set<JobseekerJob> getJobseekerJobs() {
		return this.jobseekerJobs;
	}

	public void setJobseekerJobs(Set<JobseekerJob> jobseekerJobs) {
		this.jobseekerJobs = jobseekerJobs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobseeker")
	public Set<JobseekerCity> getJobseekerCities() {
		return this.jobseekerCities;
	}

	public void setJobseekerCities(Set<JobseekerCity> jobseekerCities) {
		this.jobseekerCities = jobseekerCities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobseeker")
	public Set<Knowledge> getKnowledges() {
		return this.knowledges;
	}

	public void setKnowledges(Set<Knowledge> knowledges) {
		this.knowledges = knowledges;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobseeker")
	public Set<JobseekerLangage> getJobseekerLangages() {
		return this.jobseekerLangages;
	}

	public void setJobseekerLangages(Set<JobseekerLangage> jobseekerLangages) {
		this.jobseekerLangages = jobseekerLangages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobseeker")
	public Set<JobseekerXpActivity> getJobseekerXpActivities() {
		return this.jobseekerXpActivities;
	}

	public void setJobseekerXpActivities(Set<JobseekerXpActivity> jobseekerXpActivities) {
		this.jobseekerXpActivities = jobseekerXpActivities;
	}

}
