package reviewsmicro.reviewsmis.reviews.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfiguration {
    @Bean
    public Queue companyRattingQueue(){
        return new Queue("CompanyRatingQueue");
    }
    @Bean
    public Queue DeletecompanyQueu(){
        return new Queue("DeleteCompanyQueu");
    }
    @Bean
    public MessageConverter jMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public  RabbitTemplate rabbittemplate(final ConnectionFactory cf){
        RabbitTemplate rt=new RabbitTemplate(cf);
        rt.setMessageConverter(jMessageConverter());
        return rt;


    }
   
}
