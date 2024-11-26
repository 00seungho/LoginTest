package aikopo.ac.kr.logintest.security.service;

import aikopo.ac.kr.logintest.entity.ClubMember;
import aikopo.ac.kr.logintest.repository.ClubMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import aikopo.ac.kr.logintest.security.dto.ClubAuthMemberDTO;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class ClubUserDetailsService implements UserDetailsService {
        private final ClubMemberRepository clubMemberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("※ ClubUserDetailsService"+username);
        Optional<ClubMember> result =clubMemberRepository.findByEmail(username,false);

        if (result.isEmpty()){
            throw new UsernameNotFoundException(username);
        }

        ClubMember clubMember = result.get();
        log.info(clubMember);

        ClubAuthMemberDTO clubAuthMemberDTO = new ClubAuthMemberDTO(
                clubMember.getEmail(),
                clubMember.getPassword(),
                clubMember.isFromSocial(),
                clubMember.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                        .collect(Collectors.toSet()));
        clubAuthMemberDTO.setName(clubMember.getName());

        return clubAuthMemberDTO;
    }
}
