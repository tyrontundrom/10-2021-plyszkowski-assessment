package com.plyszkowski.assessment.controller;

import com.plyszkowski.assessment.model.Employee;
import com.plyszkowski.assessment.service.AddressService;
import com.plyszkowski.assessment.service.DepartmentService;
import com.plyszkowski.assessment.service.EmployeeService;
import com.plyszkowski.assessment.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    @GetMapping("/remove/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
        return "redirect:/employees/list";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable(name = "id") Employee employee,  Model model) {
        model.addAttribute("editEmployee", employee);
        model.addAttribute("addressEmployee", addressService);
        model.addAttribute("departmentEmployee", departmentService);
        model.addAttribute("positionEmployee", positionService);
        return "edit-employee";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@ModelAttribute Employee employee) {
        employeeService.editEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/export-csv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        String fileName = "employees.csv";
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName;
        response.setHeader(headerKey, headerValue);
        List<Employee> employeeList = employeeService.findAll();
        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"ID", "Imię", "Nazwisko", "Adres", "Email", "Telefon", "Data zatrudnienia",
                "Wynagrodzenie", "Dział", "Stanowisko"};
        String[] nameMapping = {"id", "firstName", "lastName", "address", "email", "phone", "employmentDate",
                "salary", "department", "position"};
        csvBeanWriter.writeHeader(csvHeader);
        for (Employee emp : employeeList) {
            csvBeanWriter.write(emp, nameMapping);
        }
        csvBeanWriter.close();
    }
}
