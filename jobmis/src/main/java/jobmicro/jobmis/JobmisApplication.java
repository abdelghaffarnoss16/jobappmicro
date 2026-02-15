package jobmicro.jobmis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class JobmisApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobmisApplication.class, args);
	}

}
