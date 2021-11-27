package com.plyszkowski.assessment.controller;

import com.plyszkowski.assessment.model.Address;
import com.plyszkowski.assessment.model.Department;
import com.plyszkowski.assessment.repository.AddressRepository;
import com.plyszkowski.assessment.service.AddressService;
import com.plyszkowski.assessment.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final AddressService addressService;


    public DepartmentController(DepartmentService departmentService, AddressService addressService) {
        this.departmentService = departmentService;
        this.addressService = addressService;
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("newDepartment", new Department());
        model.addAttribute("adressDepartm", addressService);
        return "add-department";
    }

    @PostMapping
    public String create(@ModelAttribute Department department) {
        departmentService.create(department);
        return "redirect:/departments/list";
    }

    @GetMapping("/list")
    public String showDepartments(Model model) {
        model.addAttribute("departmentsList", departmentService.findAll());
        return "departments-list";
    }

    @GetMapping("/remove/{id}")
    public String delete(@PathVariable Long id) {
        departmentService.delete(id);
        return "redirect:/departments/list";
    }

    @GetMapping("/edit/{id}")
    public String editDepartment(@PathVariable(name = "id") Department department, Model model) {
        model.addAttribute("editDepartment", department);
        model.addAttribute("addressDepartment", addressService);
        return "edit-department";
    }

    @PostMapping("/edit/{id}")
    public String editDepartment(@ModelAttribute Department department) {
        departmentService.editDepartment(department);
        return "redirect:/departments/list";
    }
}
