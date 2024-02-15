package hellojpa.study.practice.extend.example;

import jakarta.persistence.Entity;

@Entity
public class Album extends Item {
	private String artist;
}
