package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Orders;
import hellojpa.entity.Team;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("JPQL로 LIST SELECT를 진행한다.")
	void createJpql() {
		List<Member> entities = em
			.createQuery("select m from Member m", Member.class)
			.getResultList();

		for (Member entity : entities) {
			log.info("entity => {}", entity);
			log.info("entity.getTeam => {}", entity.getTeam());
		}
	}

	@Test
	@DisplayName("JPQL로 UPDATE를 진행한다.")
	void updateJpql() {
	    // given
		Long memberId = 6L;
		int result = em.createQuery("update Member m set m.age = 10 where m.id = :memberId")
			.setParameter("memberId", memberId)
			.executeUpdate();
	}

	@Test
	@DisplayName("JPQL로 DELETE를 진행한다.")
	void deleteJpql() {
		Long memberId = 6L;
		int result = em.createQuery("delete from Member m where m.id = :memberId")
			.setParameter("memberId", memberId).executeUpdate();
		log.info("result => {}", result);
	}

	@Test
	@DisplayName("JPQL로 SELECT를 진행한다.")
	void findOrder() {
	    // given
		Long memberId = createMember();
		Member findMember = em.createQuery("select m from Member m where m.id = :memberId", Member.class)
			.setParameter("memberId", memberId)
			.getSingleResult();

		// when
		Orders orders = findMember.getOrders();
		log.info("orders => {}", orders);
	}

	@Test
	@DisplayName("JPQL로 FETCH JOIN을 진행한다.")
	void fetchJoin() {
		// given

		Long memberId = createMember();
		List<Member> results = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();

		log.info("results => {}", results);
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