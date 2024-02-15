package hellojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"hellojpa.entity"})
@SpringBootApplication
public class HelloJpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloJpaApplication.class, args);
	}
}