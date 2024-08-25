package hellojpa.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class Location {

    private String addr;
    private String street;
    private String zipcode;

    public Location(){}

    public Location(String addr, String street, String zipcode) {
        this.addr = addr;
        this.street = street;
        this.zipcode = zipcode;
    }
}
