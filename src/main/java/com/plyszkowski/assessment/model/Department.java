package com.plyszkowski.assessment.model;

import com.plyszkowski.assessment.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department extends BaseEntity {

    @Column(nullable = false)
    private String name;


    @OneToOne
    @JoinColumn(name = "localization_id", foreignKey = @ForeignKey(name = "department_address_id_fk"))
    private Address localization;

    public Department() {
    }

    public Department(String name, Address localization) {
        this.name = name;
        this.localization = localization;
    }
}
