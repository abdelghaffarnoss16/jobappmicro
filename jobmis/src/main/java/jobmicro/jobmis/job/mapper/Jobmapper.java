package jobmicro.jobmis.job.mapper;

import java.util.List;

import jobmicro.jobmis.job.Job;
import jobmicro.jobmis.job.dto.jobDTO;
import jobmicro.jobmis.job.external.company;
import jobmicro.jobmis.job.external.review;

public class Jobmapper {
public static jobDTO mapToJobWithCompanyDTO( Job job,company company,List<review> reviews){
   jobDTO jbw=new jobDTO();
   jbw.setId(job.getId());
   jbw.setTitle(job.getTitle());
   jbw.setDescription(job.getDescription());
    jbw.setLocation(job.getLocation());
    jbw.setMaxsalary(job.getMaxsalary());
    jbw.setMinsalary(job.getMinsalary());
    jbw.setCompany(company);
    jbw.setReview(reviews);
return jbw;
}
}
