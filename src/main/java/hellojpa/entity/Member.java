package hellojpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "members")
@Data
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "username")
    private String name;

    private int age;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}