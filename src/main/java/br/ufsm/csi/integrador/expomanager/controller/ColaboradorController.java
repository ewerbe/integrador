package br.ufsm.csi.integrador.expomanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ColaboradorController {

    @GetMapping({"/novo-colaborador.action", "/novo-colaborador"})
    public String getNovoColaborador(Model model) {
        model.addAttribute("isGerente", true);
        return "novo-colaborador";
    }
}
