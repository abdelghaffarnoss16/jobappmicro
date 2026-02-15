package jobmicro.jobmis.job.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jobmicro.jobmis.job.external.company;

@FeignClient(name="COMPANY-SERVICE",url="${company-service.url")
public interface CompanyClient {
    @GetMapping("/companies/{id}")
    company getCompany(@PathVariable("id") Long id);

}
