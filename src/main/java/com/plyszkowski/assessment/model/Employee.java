package com.plyszkowski.assessment.model;

import com.plyszkowski.assessment.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee extends BaseEntity {

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @OneToOne
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "employees_addresses_id_fk"))
    private Address address;

    @Column(length = 80)
    private String email;

    @Column
    private Integer phone;

    @Column(columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDate employmentDate;

    @Column
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "employees_department_id_fk"))
    private Department department;

    @OneToOne
    @JoinColumn(name = "position_id", foreignKey = @ForeignKey(name = "employees_position_id_fk"))
    private Position position;


    public Employee() {
    }

    public Employee(String firstName, String lastName, Address address, String email, Integer phone,
                    LocalDate employmentDate, Double salary, Department department, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.employmentDate = employmentDate;
        this.salary = salary;
        this.department = department;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", employmentDate=" + employmentDate +
                ", salary=" + salary +
                ", department=" + department +
                ", position=" + position +
                '}';
    }
}
