package com.plyszkowski.assessment.service;

import com.plyszkowski.assessment.common.BaseEntity;
import com.plyszkowski.assessment.model.Department;
import com.plyszkowski.assessment.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department getById(Long id) {
        return departmentRepository.getById(id);
    }

    public void delete(Department department) {
        departmentRepository.delete(department);
    }
}
