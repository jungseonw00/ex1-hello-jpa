package hellojpa.study.practice.extend;

import static jakarta.persistence.InheritanceType.SINGLE_TABLE;

import hellojpa.study.practice.Category;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn
@Entity
public class Item {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Long id;

	private String name;
	private String price;
	private String stockQuantity;

	@ManyToMany(mappedBy = "item")
	private List<Category> categories = new ArrayList<>();
}
