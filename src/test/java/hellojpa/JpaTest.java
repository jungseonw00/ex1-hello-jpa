package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

public class JpaTest {

	@Test
	void JpaTest() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// 팀 저장
		Team team = new Team();
		team.setName("teamA");
		em.persist(team);

		// 회원 저장
		Member member = new Member();
		member.setName("member1");
		member.setTeam(team);
//		member.setTeamId(team.getId());
		em.persist(member);

		tx.commit();
		emf.close();
	}
}
