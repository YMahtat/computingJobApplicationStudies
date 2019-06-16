package org.emsi.jobapplications.models.others;

import org.emsi.jobapplications.models.jobseekers.JobseekerXpActivity;

public class JobseekerActivitySectorCount {
	JobseekerXpActivity Js;
	Long count;
	public JobseekerXpActivity getJs() {
		return Js;
	}
	public void setJs(JobseekerXpActivity js) {
		Js = js;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public JobseekerActivitySectorCount(JobseekerXpActivity js, Long count) {
		super();
		Js = js;
		this.count = count;
	}
	public JobseekerActivitySectorCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JobseekerActivitySectorCount [Js=" + Js + ", count=" + count + "]";
	}
	
}
