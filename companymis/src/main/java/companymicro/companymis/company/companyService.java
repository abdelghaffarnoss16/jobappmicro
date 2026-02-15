package companymicro.companymis.company;

import java.util.List;

import companymicro.companymis.company.dto.jobMessage;
import companymicro.companymis.company.dto.reviewMessage;


public interface companyService {
List<company> getAllCompanies();
boolean updateCompany(company companyUpdated, Long id );
void createCompany(company company);
company findcompany(Long id);
boolean deletejcompany(Long id);
 void updateCompany(reviewMessage reviewMessage);
void updateCompany2(jobMessage jobMessage);
}
