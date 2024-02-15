package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Orders;
import hellojpa.entity.Team;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
public class HelloJpaApplicationTest {

	@Autowired
	private EntityManager em;

	@Test
	void createJpql() {
		List<Member> entities = em.createQuery("select m from Member m", Member.class).getResultList();

		for (Member entity : entities) {
			log.info("entity => {}", entity);
			log.info("entity.getTeam => {}", entity.getTeam());
		}
	}

	private Long createMember() {
		Team team = Team.builder()
			.name("teamA")
			.build();

		Orders order = Orders.builder()
			.name("Macbook pro")
			.quantity(10)
			.build();

		Member member = Member.builder()
			.age(27)
			.name("seonwoo_jung")
			.build();

		member.createOrder(order);
		member.changeTeam(team);

		em.persist(member);
		log.info("member => {}", member);
		return member.getId();
	}
}