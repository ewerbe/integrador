package br.ufsm.csi.integrador.expomanager.controller;

import br.ufsm.csi.integrador.expomanager.model.Usuario;
import br.ufsm.csi.integrador.expomanager.repository.UsuarioRepository;
import br.ufsm.csi.integrador.expomanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;


@Controller
public class ColaboradorController {


    @Autowired
    private UsuarioService usuarioService;

    @GetMapping({"/cadastro-colaborador.action", "/cadastro-colaborador"})
    public String getCadastroColaborador(Model model) {
        model.addAttribute("isGerente", true);
        return "cadastro-colaborador";
    }

    @RequestMapping(value = "/colaboradores.action", method = RequestMethod.GET)
    public String getColaboradores(Model model) {
        List<Usuario> colaboradores;
        colaboradores = usuarioService.findAll();
        model.addAttribute("colaboradores", colaboradores);
        model.addAttribute("isGerente", true);
        return "colaboradores";
    }

//    @GetMapping(value = {"/salvarColaborador.action", "/salvarColaborador"})
//    public String saveColaborador(Model model, HttpServletRequest request) {
//        String nome = request.getParameter("nomeColaborador");
//        String email = request.getParameter("emailColaborador");
//        String senha = request.getParameter("senhaColaborador");
//
//        Usuario colaborador = new Usuario(nome, email, senha, false, true);
//        //TODO: buscar do back;
//        List<Usuario> colaboradores = new LinkedList<>();
//        colaboradores.add(colaborador);
//
//        model.addAttribute("isGerente", true);
//        model.addAttribute("colaboradores", colaboradores);
//        return "colaboradores";
//    }

    @RequestMapping(value = "/salvarColaborador.action", method = RequestMethod.POST)
    public String salvarColaborador(Model model, HttpServletRequest request) {
        String nome = request.getParameter("nomeColaborador");
        String email = request.getParameter("emailColaborador");
        String senha = request.getParameter("senhaColaborador");

        Usuario colaborador = new Usuario();
        colaborador.setNome(nome);
        colaborador.setEmail(email);
        colaborador.setSenha(senha);
        colaborador.setAtivo(true);
        colaborador.setGerente(false);

        usuarioService.save(colaborador);

        model.addAttribute("colaborador", colaborador);
        return "redirect:/colaboradores.action";
    }
}
