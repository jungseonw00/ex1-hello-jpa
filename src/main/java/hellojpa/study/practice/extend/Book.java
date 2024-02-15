package hellojpa.study.practice.extend;

import jakarta.persistence.Entity;

@Entity
public class Book extends Item {
	private String author;
	private String isbn;
}
