package hellojpa.entity;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = PROTECTED)
@ToString(exclude = {"members"})
@Getter
public class Team {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "team_id")
	private Long id;

	private String name;

	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();

	@Builder
	public Team(String name) {
		this.name = name;
	}
}
