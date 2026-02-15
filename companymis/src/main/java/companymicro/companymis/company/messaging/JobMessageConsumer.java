package companymicro.companymis.company.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import companymicro.companymis.company.companyService;
import companymicro.companymis.company.dto.jobMessage;

public class JobMessageConsumer {
private final companyService cs;

    public JobMessageConsumer(companyService cs) {
        this.cs = cs;
    }
    @RabbitListener(queues="CompanyJobsQueue")
    public void consumeMessage(jobMessage jobMessage){
        cs.updateCompany2(jobMessage);


    }
}
