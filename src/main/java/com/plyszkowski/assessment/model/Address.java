package com.plyszkowski.assessment.model;

import com.plyszkowski.assessment.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address extends BaseEntity {

    @Column(nullable = false, length = 30)
    private String street;

    @Column(nullable = false, length = 10)
    private String houseNumber;

    @Column(nullable = false, length = 6)
    private String postalCode;

    @Column(nullable = false, length = 30)
    private String city;

//    @OneToMany(mappedBy = "localization")
//    private Department department;

    @OneToOne(mappedBy = "address")
    private Employee employee;

    public Address() {
    }

    public Address(String street, String houseNumber, String postalCode, String city, Employee employee) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;

        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
