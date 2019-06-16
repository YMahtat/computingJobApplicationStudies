package org.emsi.jobapplications.models.others;

import org.emsi.jobapplications.models.jobseekers.Jobseeker;

public class JobSeekerLevelCount {
		Jobseeker js;
		Long count;
		
		
		
		public Jobseeker getJs() {
			return js;
		}
		public void setJs(Jobseeker js) {
			this.js = js;
		}
		public Long getCount() {
			return count;
		}
		public void setCount(Long count) {
			this.count = count;
		}
		public JobSeekerLevelCount(Jobseeker js, Long count) {
			super();
			this.js = js;
			this.count = count;
		}
		public JobSeekerLevelCount() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "JobSeekerLevelCount [js=" + js + ", count=" + count + "]";
		}
		
		
}
