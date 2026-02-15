package companymicro.companymis.company.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("REVIEW-SERVICE")
public interface  Reviewclient {
    @GetMapping("/reviews/averagerating")
    double getaverageRating(@RequestParam("companyId") Long CompanyId);

}
