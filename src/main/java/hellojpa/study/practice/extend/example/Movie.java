package hellojpa.study.practice.extend.example;

import jakarta.persistence.Entity;

@Entity
public class Movie extends Item {
	private String director;
	private String actor;
}
