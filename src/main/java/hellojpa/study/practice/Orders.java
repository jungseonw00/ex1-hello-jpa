package hellojpa.study.practice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	// DB에도 OneToOne을 적용하려면 unique 속성을 추가해 줘야함.
	@OneToOne
	@JoinColumn(name = "delivery_id", unique = true)
	private Delivery delivery;

	@OneToMany(mappedBy = "orders")
	private List<OrderItem> orderItem = new ArrayList<>();

	private LocalDateTime orderDate;
}
