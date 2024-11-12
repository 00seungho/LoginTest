package aikopo.ac.kr.logintest.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Log4j2
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //패스워드 암호화하는 클래스
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        String userName = "user2";
        String password = "1234";

        UserDetails user = User.builder()
                .username(userName)
                .password(passwordEncoder().encode(password))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

}
