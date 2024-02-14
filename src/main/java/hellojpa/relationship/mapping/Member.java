package hellojpa.relationship.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "member_id")
	private Long id;

	private String name;

	private String city;

	private String street;

	private String zipCode;

	@OneToMany(mappedBy = "member")
	private List<Orders> orders = new ArrayList<>();
}
