package companymicro.companymis.company.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import companymicro.companymis.company.external.Job;

@FeignClient("JOB-SERVICE")
public interface Jobclient {
    @GetMapping("/jobs/company/{companyId}")
      List<Job> getjobsbycompanyid(@PathVariable("companyId") Long companyId);



}
