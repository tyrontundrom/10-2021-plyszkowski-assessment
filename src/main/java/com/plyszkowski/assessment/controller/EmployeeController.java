package com.plyszkowski.assessment.controller;

import com.plyszkowski.assessment.model.Employee;
import com.plyszkowski.assessment.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("newEmployee", new Employee());
        return "add-employee";
    }

    @PostMapping
    public String create(@ModelAttribute Employee employee) {
        employeeService.create(employee);
        return "employees-list";
    }

    @GetMapping("/list")
    public String showEmployees(Model model) {
        model.addAttribute("employeesList", employeeService.findAll());
        return "employees-list";
    }

    @DeleteMapping
    public void delete(Employee employee) {
        employeeService.delete(employee);
    }
}
