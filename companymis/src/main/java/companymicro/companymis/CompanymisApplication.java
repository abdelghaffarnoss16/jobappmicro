package companymicro.companymis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class CompanymisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanymisApplication.class, args);
	}

}
