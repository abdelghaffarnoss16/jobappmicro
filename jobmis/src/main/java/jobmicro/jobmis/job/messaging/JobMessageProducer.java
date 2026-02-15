package jobmicro.jobmis.job.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import jobmicro.jobmis.job.Job;
import jobmicro.jobmis.job.dto.jobMessage;



@Service
public class JobMessageProducer {
    private final RabbitTemplate RabbitTemplate;

    public JobMessageProducer(RabbitTemplate RabbitTemplate) {
        this.RabbitTemplate = RabbitTemplate;
    }
     public void sendMessage(Job job){
        jobMessage jobMessage=new jobMessage();
        jobMessage.setId(job.getId());
        jobMessage.setTitle(job.getTitle());
        jobMessage.setCompanyId(job.getCompanyId());

RabbitTemplate.convertAndSend("CompanyJobsQueue",jobMessage);





    }
}
