package aikopo.ac.kr.logintest.security;

import aikopo.ac.kr.logintest.entity.ClubMember;
import aikopo.ac.kr.logintest.entity.ClubMemberRole;
import aikopo.ac.kr.logintest.repository.ClubMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ClubMemberTests {
    @Autowired
    private ClubMemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies(){
//        user1-user80: USER
//        user81-user90: USER, MANAGER
//        user91-user100: USER, MANAGER, ADMIN

        IntStream.rangeClosed(1, 100).forEach(i ->{
            ClubMember clubMember = ClubMember.builder()
                    .email("user"+i+"@kopo.ac.kr")
                    .name("사용자"+i)
                    .password(passwordEncoder.encode("1234"))
                    .fromSocial(false)
                    .build();

            clubMember.addMemberRole(ClubMemberRole.USER);

            if(i > 80){
                clubMember.addMemberRole(ClubMemberRole.MANAGER);
            }

            if(i > 90){
                clubMember.addMemberRole(ClubMemberRole.ADMIN);
            }

            repository.save(clubMember);
        });

    }

    @Test
    public void testRead(){
        Optional<ClubMember> result = repository.findByEmail("user99@kopo.ac.kr", false);
        ClubMember clubMember = result.get();
        System.out.println("★★★" + clubMember);
    }


}