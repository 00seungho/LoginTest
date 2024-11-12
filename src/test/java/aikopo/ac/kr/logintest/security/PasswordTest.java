package aikopo.ac.kr.logintest.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncode(){
        String password = "1234";

        String enPassword = passwordEncoder.encode(password);

        System.out.println("♥ 암호화된 패스워드: " + enPassword);

        boolean matchResult = passwordEncoder.matches(password, enPassword);

        System.out.println("★ 패스워드 일치 여부: " + matchResult);
    }
}


