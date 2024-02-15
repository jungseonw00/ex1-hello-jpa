package hellojpa.study.practice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Delivery {

	@Id
	@GeneratedValue
	@Column(name = "delivery_id")
	private Long id;

	private String city;
	private String street;
	private String zipCode;
	private String status;

	@OneToOne(mappedBy = "delivery")
	private Orders orders;
}
