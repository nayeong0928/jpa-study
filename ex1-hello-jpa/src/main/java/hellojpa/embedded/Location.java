package hellojpa.embedded;

import javax.persistence.Embeddable;
import java.util.Objects;

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

    public String getAddr() {
        return addr;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Location){
            if(addr.equals(((Location) obj).getAddr())
                    && street.equals(((Location)obj).getStreet())
                    && zipcode.equals(((Location)obj).getZipcode())
            ){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addr, street, zipcode);
    }
}
