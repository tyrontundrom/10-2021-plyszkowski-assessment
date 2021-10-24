package com.plyszkowski.assessment.controller;

import com.plyszkowski.assessment.model.Employee;
import com.plyszkowski.assessment.service.AddressService;
import com.plyszkowski.assessment.service.DepartmentService;
import com.plyszkowski.assessment.service.EmployeeService;
import com.plyszkowski.assessment.service.PositionService;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Index;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AddressService addressService;
    private final DepartmentService departmentService;
    private final PositionService positionService;

    public EmployeeController(EmployeeService employeeService, AddressService addressService, DepartmentService departmentService, PositionService positionService) {
        this.employeeService = employeeService;
        this.addressService = addressService;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("newEmployee", new Employee());
        model.addAttribute("addressEmployee", addressService);
        model.addAttribute("departmentEmployee", departmentService);
        model.addAttribute("positionEmployee", positionService);
        return "add-employee";
    }

    @PostMapping
    public String create(@ModelAttribute Employee employee) {
        employeeService.create(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/list")
    public String showEmployees(Model model) {
        model.addAttribute("employeesList", employeeService.findAll());
        return "employees-list";
    }

    @GetMapping("/{id}")
    public String showOneEmployee(Model model, Employee employee) {
        model.addAttribute("oneEmployee", employeeService.findById(employee.getId()));
        return "employee-id";
    }

    @GetMapping("remove/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
        return "redirect:/employees/list";
    }
}
