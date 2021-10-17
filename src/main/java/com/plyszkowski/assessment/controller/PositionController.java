package com.plyszkowski.assessment.controller;

import com.plyszkowski.assessment.model.Address;
import com.plyszkowski.assessment.model.Position;
import com.plyszkowski.assessment.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/positions")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("newPosition", new Position());
        return "add-position";
    }

    @PostMapping
    public String create(@ModelAttribute Position position) {
        positionService.create(position);
        return "positions-list";
    }

    @GetMapping("/list")
    public String showPositions(Model model) {
        model.addAttribute("positionsList", positionService.findAll());
        return "positions-list";
    }
}
