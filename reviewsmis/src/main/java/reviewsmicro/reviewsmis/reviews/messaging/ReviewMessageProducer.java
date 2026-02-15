package reviewsmicro.reviewsmis.reviews.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import reviewsmicro.reviewsmis.dto.reviewMessage;
import reviewsmicro.reviewsmis.reviews.Reviews;

@Service
public class ReviewMessageProducer {
    private final RabbitTemplate RabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate RabbitTemplate) {
        this.RabbitTemplate = RabbitTemplate;
    }
     public void sendMessage(Reviews review){
        reviewMessage reviewmessage=new reviewMessage();
        reviewmessage.setId(review.getId());
        reviewmessage.setTitle(review.getTitle());
        reviewmessage.setDescription(review.getDescription());
        reviewmessage.setCompanyId(review.getCompanyId());
        reviewmessage.setRatings(review.getRatings());

RabbitTemplate.convertAndSend("CompanyRatingQueue",reviewmessage);





    }
}
