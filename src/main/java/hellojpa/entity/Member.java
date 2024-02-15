package hellojpa.entity;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude = {"team", "orders"})
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(name = "username")
	private String name;

	private int age;

	@ManyToOne(fetch = LAZY, cascade = ALL)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	@ManyToOne(fetch = LAZY, cascade = ALL)
	@JoinColumn(name = "order_id")
	private Orders orders;

	@Builder
	public Member(Long id, String name, int age, Team team, Orders orders) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.team = team;
		this.orders = orders;
	}

	public void createOrder(Orders orders) {
		this.orders = orders;
	}

	public void changeTeam(Team team) {
		this.team = team;
	}
}