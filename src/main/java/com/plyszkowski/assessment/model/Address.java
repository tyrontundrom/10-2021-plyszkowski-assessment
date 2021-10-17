package com.plyszkowski.assessment.model;

import com.plyszkowski.assessment.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address extends BaseEntity {

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String houseNumber;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String city;

    @OneToOne(mappedBy = "localization")
    private Department department;

    @OneToOne(mappedBy = "address")
    private Employee employee;

    public Address() {
    }

    public Address(String street, String houseNumber, String postalCode, String city, Department department, Employee employee) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.department = department;
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
