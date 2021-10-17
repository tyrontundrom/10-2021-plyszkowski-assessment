package com.plyszkowski.assessment.controller;

import com.plyszkowski.assessment.model.Address;
import com.plyszkowski.assessment.model.Employee;
import com.plyszkowski.assessment.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("newAddress", new Address());
        return "add-address";
    }

    @PostMapping
    public String create(@ModelAttribute Address address) {
        addressService.create(address);
        return "addresses-list";
    }

    @GetMapping("/list")
    public String showAddresse(Model model) {
        model.addAttribute("addressesList", addressService.findAll());
        return "addresses-list";
    }
}
