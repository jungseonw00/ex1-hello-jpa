package hellojpa.study.practice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;

	private String name;

	private String city;

	private String street;

	private String zipCode;

	@OneToMany(mappedBy = "member")
	private List<Orders> orders = new ArrayList<>();
}
