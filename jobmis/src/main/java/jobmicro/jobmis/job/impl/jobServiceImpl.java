package jobmicro.jobmis.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jobmicro.jobmis.job.Job;
import jobmicro.jobmis.job.clients.CompanyClient;
import jobmicro.jobmis.job.clients.ReviewClient;
import jobmicro.jobmis.job.dto.jobDTO;
import jobmicro.jobmis.job.external.company;
import jobmicro.jobmis.job.external.review;
import jobmicro.jobmis.job.jobRepository;
import jobmicro.jobmis.job.jobService;
import jobmicro.jobmis.job.mapper.Jobmapper;

@Service
public class jobServiceImpl implements jobService {
    private jobRepository jr;
    private CompanyClient CompanyClient;
    private ReviewClient reviewclient;

    @Autowired

    public jobServiceImpl(jobRepository jr, CompanyClient CompanyClient, ReviewClient reviewclient) {
        this.jr = jr;
        this.CompanyClient = CompanyClient;
        this.reviewclient = reviewclient;
    }

    @Override
    @CircuitBreaker(name = "companyBreaker", fallbackMethod = "companyFallback")
    public List<jobDTO> findAll() {
        List<Job> jobs = jr.findAll();
        return jobs.stream().map(this::converteJobToDTO).collect(Collectors.toList());
    }

    public List<String> companyFallback(Exception e) {
        List<String> l = new ArrayList<>();
        l.add("ITS NOT WORKING FOR THE FUCKING MOMENT");
        return l;
    }

    jobDTO converteJobToDTO(Job job) {
        company com = CompanyClient.getCompany(job.getCompanyId());
        List<review> reviews = reviewclient.getReviews(job.getCompanyId());
        return Jobmapper.mapToJobWithCompanyDTO(job, com, reviews);

    }

    @Override
    public void createJob(Job job) {

        jr.save(job);

    }

    @Override
    @CircuitBreaker(name = "companyBreaker", fallbackMethod = "companyFallback")
    public jobDTO findjob(Long id) {
        Job job = jr.findById(id).orElse(null);
        return converteJobToDTO(job);
    }

    @Override
    public boolean deletejob(Long id) {

        try {
            jr.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobO = jr.findById(id);

        if (jobO.isPresent()) {
            Job jo = jobO.get();
            jo.setTitle(updatedJob.getTitle());
            jo.setDescription(updatedJob.getDescription());
            jo.setLocation(updatedJob.getLocation());
            jo.setMinsalary(updatedJob.getMinsalary());
            jo.setMaxsalary(updatedJob.getMaxsalary());
            jr.save(jo);
            return true;

        }
        return false;
    }

  
}
