package jobmicro.jobmis.job.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jobmicro.jobmis.job.external.review;

@FeignClient(name ="REVIEW-SERVICE",url="${review-service.url")
public interface ReviewClient {
@GetMapping("/reviews")
List<review> getReviews(@RequestParam("companyId") Long Company);
}
