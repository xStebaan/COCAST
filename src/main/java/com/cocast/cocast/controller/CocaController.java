package com.cocast.cocast.controller;

import com.cocast.cocast.model.CocaRecord;
import com.cocast.cocast.service.CocaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CocaController {

    private final CocaService service;

    public CocaController(CocaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(@RequestParam(required = false) String municipality, Model model) {
        model.addAttribute("places", service.search(municipality));
        model.addAttribute("municipality", municipality == null ? "" : municipality);
        return "index";
    }
}
