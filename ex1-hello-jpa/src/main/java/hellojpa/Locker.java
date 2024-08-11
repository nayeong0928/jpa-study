package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue
    @Column(name = "locker_id")
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
