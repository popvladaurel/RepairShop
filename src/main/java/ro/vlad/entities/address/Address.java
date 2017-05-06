package ro.vlad.entities.address;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column (name = "address_id", columnDefinition = "serial") private Long addressId;
    @Column (name = "address") private String address;

    public void setAddressId(Long addressId) {this.addressId = addressId;}
    public void setAddress(String address) {this.address = address;}

    public Long getAddressId() {return addressId;}
    public String getAddress() {return address;}
}