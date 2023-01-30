package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    // updatable = false인 필드는 데이터가 변경되지 않음.
    @Column(name = "name", nullable = false)
    private String username;

    private Integer age;

    // enum 타입 매핑
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 날짜 타입 매핑
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // 날짜 타입 매핑
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // BLOB, CLOB 매핑
    @Lob
    private String description;

    // DB 칼럼에는 저장하지 않을 때 사용
    @Transient
    private int temp;

    public Member() {
    }
}