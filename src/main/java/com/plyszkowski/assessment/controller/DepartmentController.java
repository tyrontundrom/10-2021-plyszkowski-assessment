package com.plyszkowski.assessment.controller;

import com.plyszkowski.assessment.model.Address;
import com.plyszkowski.assessment.model.Department;
import com.plyszkowski.assessment.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("newDepartment", new Department());
        return "add-department";
    }

    @PostMapping
    public String create(@ModelAttribute Department department) {
        departmentService.create(department);
        return "departments-list";
    }

    @GetMapping("/list")
    public String showDepartments(Model model) {
        model.addAttribute("departmentsList", departmentService.findAll());
        return "departments-list";
    }
}
