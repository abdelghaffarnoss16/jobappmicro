package jobmicro.jobmis.job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jobmicro.jobmis.job.dto.jobDTO;
import jobmicro.jobmis.job.messaging.JobMessageProducer;
@RestController
@RequestMapping("/jobs")
public class jobController {
private jobService js;
private jobRepository jr;
private JobMessageProducer jmp;

    public jobController(jobService js,jobRepository jr,JobMessageProducer jmp) {
        this.js = js;
        this.jr=jr;
        this.jmp=jmp;
    }
    @GetMapping("/all")
    public List<jobDTO> FindAll(){
        return js.findAll();
    }

    @PostMapping("/add")
    public String createJobs(@RequestBody Job job){
        js.createJob(job);
        jmp.sendMessage(job);
        return " job added successfully";
    }
@GetMapping("/all/{id}")
    public ResponseEntity<jobDTO> getJobByid(@PathVariable Long id){
       jobDTO j = js.findjob(id);
       if(j != null){
        return new ResponseEntity<>(j, HttpStatus.OK);
       }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/all/{id}")
    public ResponseEntity<String> DeleteJobByid(@PathVariable Long id){
        boolean deleted =js.deletejob(id);
        if(deleted)
            return new ResponseEntity<>("job deleted",HttpStatus.OK);
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   
}
@PutMapping("/all/{id}")
public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
boolean updated = js.updateJob(id,updatedJob);
if (updated){
return new ResponseEntity<>("job updated",HttpStatus.OK);}
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}


}