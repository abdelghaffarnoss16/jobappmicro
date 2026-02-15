package companymicro.companymis.company.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import companymicro.companymis.company.companyService;
import companymicro.companymis.company.dto.reviewMessage;
@Service
public class ReviewMessageConsumer {
    private final companyService cs;

    public ReviewMessageConsumer(companyService cs) {
        this.cs = cs;
    }
    @RabbitListener(queues="CompanyRatingQueue")
    public void consumeMessage(reviewMessage reviewMessage){
        cs.updateCompany(reviewMessage);


    }
}
