package aikopo.ac.kr.logintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LoginTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginTestApplication.class, args);
    }

}
