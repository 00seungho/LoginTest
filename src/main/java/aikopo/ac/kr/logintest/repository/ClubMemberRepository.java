package aikopo.ac.kr.logintest.repository;

import aikopo.ac.kr.logintest.entity.ClubMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClubMemberRepository extends JpaRepository<ClubMember, String> {

    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from ClubMember m where m.email = :email and m.fromSocial = :social")
    Optional<ClubMember> findByEmail(String email, boolean social);
}