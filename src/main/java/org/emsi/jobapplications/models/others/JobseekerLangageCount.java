package org.emsi.jobapplications.models.others;

import org.emsi.jobapplications.models.jobseekers.JobseekerLangage;
import org.emsi.jobapplications.models.jobseekers.JobseekerXpActivity;

public class JobseekerLangageCount {
		
	
		JobseekerLangage jsl;
		Long count;
		
		public JobseekerLangage getJsl() {
			return jsl;
		}
		public void setJsl(JobseekerLangage jsl) {
			this.jsl = jsl;
		}
		public Long getCount() {
			return count;
		}
		public void setCount(Long count) {
			this.count = count;
		}
		public JobseekerLangageCount(JobseekerLangage jsl, Long count) {
			super();
			this.jsl = jsl;
			this.count = count;
		}
		public JobseekerLangageCount() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "JobseekerLangageCount [jsl=" + jsl + ", count=" + count + "]";
		}
		
		
		
}
