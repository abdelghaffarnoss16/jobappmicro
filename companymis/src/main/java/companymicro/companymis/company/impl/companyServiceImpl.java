package companymicro.companymis.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import companymicro.companymis.company.clients.Reviewclient;
import companymicro.companymis.company.company;
import companymicro.companymis.company.companyRepository;
import companymicro.companymis.company.companyService;
import companymicro.companymis.company.dto.jobMessage;
import companymicro.companymis.company.dto.reviewMessage;


@Service
public  class companyServiceImpl implements companyService{
private companyRepository cr;
private Reviewclient rc;
    public companyServiceImpl(companyRepository cr,Reviewclient rc) {
        this.cr = cr;
        this.rc=rc;
    }
    @Override
    public List<company> getAllCompanies() {
        return cr.findAll();
    }

    

    @Override
    public boolean updateCompany(company UpdatedCompany, Long id ) {
        // TODO Auto-generated method stub
        Optional<company> ComO  = cr.findById(id);

                if (ComO.isPresent()){
                company co = ComO.get();
                   co.setName(UpdatedCompany.getName());
                   co.setDescription(UpdatedCompany.getDescription());
                   co.setJobsId(UpdatedCompany.getJobsId());
                   cr.save(co);
                   return true;
                    
              }
        return false;
    }
  
    @Override
    public void createCompany(company company) {
        cr.save(company);
    }
     @Override
    public company findcompany(Long id) {
    return cr.findById(id).orElse(null);

        }
     @Override
     public boolean deletejcompany(Long id) {
        // TODO Auto-generated method stub
      try {
          
        cr.deleteById(id); 
        return true; 
      } catch (Exception e) {       
         return false;


      }
    }
     @Override
     public void updateCompany(reviewMessage reviewMessage) {
        // TODO Auto-generated method stub
        
                company company=findcompany(reviewMessage.getCompanyId());
                double averagerating =rc.getaverageRating(reviewMessage.getCompanyId());
                company.setRating(averagerating);
                cr.save(company);
    }
     @Override
     public void updateCompany2(jobMessage jobMessage) {
        // TODO Auto-generated method stub
            company com=findcompany(jobMessage.getCompanyId());
            Long JobId=jobMessage.getId();
            com.getJobsId().add(JobId);
            cr.save(com);
    }
    

}
