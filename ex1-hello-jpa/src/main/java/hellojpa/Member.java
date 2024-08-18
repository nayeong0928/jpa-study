package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member{

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name="MEMBER_PRODUCT")
    private List<Product> products=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
