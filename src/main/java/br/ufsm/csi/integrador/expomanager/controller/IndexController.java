package br.ufsm.csi.integrador.expomanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/home"})
    public String getIndex(Model model) {
        model.addAttribute("isGerente", true);
        return "home";
    }
}
