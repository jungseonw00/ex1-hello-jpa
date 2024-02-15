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
@ToString(exclude = {"member"})
@Getter
public class Orders {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_id")
	private Long id;
	private String name;
	private int quantity;

	@OneToMany(mappedBy = "orders")
	private List<Member> member = new ArrayList<>();

	@Builder
	public Orders(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
}
