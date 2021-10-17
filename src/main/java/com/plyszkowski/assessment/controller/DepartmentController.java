package com.plyszkowski.assessment.controller;

import com.plyszkowski.assessment.model.Department;
import com.plyszkowski.assessment.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
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
}
