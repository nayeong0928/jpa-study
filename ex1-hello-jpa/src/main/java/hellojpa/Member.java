package hellojpa;

import hellojpa.embedded.Location;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name="MEMBER_PRODUCT")
    private List<Product> products=new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @ElementCollection
    @CollectionTable(name = "LOCATIONS")
    private List<Location> locations=new ArrayList<>();

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

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
