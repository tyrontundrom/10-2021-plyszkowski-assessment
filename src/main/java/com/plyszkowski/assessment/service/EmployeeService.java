package com.plyszkowski.assessment.service;

import com.plyszkowski.assessment.model.Employee;
import com.plyszkowski.assessment.repository.EmployeesRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeesRepository employeesRepository;

    public EmployeeService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public Employee create(Employee employee) {
        return employeesRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeesRepository.findAll();
    }

    public Optional<Employee> findOneEmploye(Example<Employee> employeeExample) {
        return employeesRepository.findOne(employeeExample);
    }

    public Employee findById(Long id) {
        return employeesRepository.getById(id);
    }

    public void delete(Long id) {
        employeesRepository.deleteById(id);
    }




}
