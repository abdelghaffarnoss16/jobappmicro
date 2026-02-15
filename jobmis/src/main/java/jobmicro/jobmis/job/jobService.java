package jobmicro.jobmis.job;

import java.util.List;

import jobmicro.jobmis.job.dto.jobDTO;

public interface jobService {
List<jobDTO> findAll();
void createJob(Job job);
jobDTO findjob(Long id);
boolean deletejob(Long id);
boolean updateJob(Long id, Job updatedJob);
}