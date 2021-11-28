package com.plyszkowski.assessment.controller;

import com.plyszkowski.assessment.model.Address;
import com.plyszkowski.assessment.model.Employee;
import com.plyszkowski.assessment.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/addresses/list";
    }

    @GetMapping("/list")
    public String showAddresse(Model model) {
        model.addAttribute("addressesList", addressService.findAll());
        return "addresses-list";
    }

    @GetMapping("/remove/{id}")
    public String deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
        return "redirect:/addresses/list";
    }

    @GetMapping("/edit/{id}")
    public String editAddress(@PathVariable(name = "id") Address address, Model model) {
        model.addAttribute("editAddress", address);
        return "edit-address";
    }

    @PostMapping("/edit/{id}")
    public String editAddress(@ModelAttribute Address address) {
        addressService.editAddress(address);
        return "redirect:/addresses/list";
    }
}
