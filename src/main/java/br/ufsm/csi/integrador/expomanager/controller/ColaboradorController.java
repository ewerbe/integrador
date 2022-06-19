package br.ufsm.csi.integrador.expomanager.controller;

import br.ufsm.csi.integrador.expomanager.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ColaboradorController {

    @GetMapping({"/cadastro-colaborador.action", "/cadastro-colaborador"})
    public String getCadastroColaborador(Model model) {
        model.addAttribute("isGerente", true);
        return "cadastro-colaborador";
    }

    @GetMapping({"/colaboradores.action", "/colaboradores"})
    public String getColaboradores(Model model) {
        model.addAttribute("isGerente", true);
        return "colaboradores";
    }

    @GetMapping(value = {"/salvarColaborador.action", "/salvarColaborador"})
    public String saveColaborador(Model model, HttpServletRequest request) {
        String nome = request.getParameter("nomeColaborador");
        String email = request.getParameter("emailColaborador");
        String senha = request.getParameter("senhaColaborador");

        Usuario colaborador = new Usuario(nome, email, senha, false, true);
        //TODO: buscar do back;
        List<Usuario> colaboradores = new LinkedList<>();
        colaboradores.add(colaborador);

        model.addAttribute("isGerente", true);
        model.addAttribute("colaboradores", colaboradores);
        return "colaboradores";
    }
}
