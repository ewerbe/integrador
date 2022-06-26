package br.ufsm.csi.integrador.expomanager.controller;

import br.ufsm.csi.integrador.expomanager.model.Usuario;
import br.ufsm.csi.integrador.expomanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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


    @RequestMapping(value = "/colaborador/salvar-colaborador.action", method = RequestMethod.POST)
    public String salvarColaborador(Model model, HttpServletRequest request) {
        String idColaboradorString = request.getParameter("idColaborador");
        Long idColaborador = null;
        if(idColaboradorString != null) {
            idColaborador = Long.valueOf(idColaboradorString);
        }
        String nome = request.getParameter("nomeColaborador");
        String email = request.getParameter("emailColaborador");
        String senha = request.getParameter("senhaColaborador");

        Usuario colaborador = new Usuario();
        colaborador.setId(idColaborador);
        colaborador.setNome(nome);
        colaborador.setEmail(email);
        colaborador.setSenha(senha);
        colaborador.setAtivo(true);
        colaborador.setGerente(false);

        usuarioService.save(colaborador);

        model.addAttribute("colaborador", colaborador);
        return "redirect:/colaboradores.action";
    }

    @RequestMapping(value = "/colaborador/editar-colaborador.action", method = RequestMethod.POST)
    public String salvarColaborador(Model model, HttpServletRequest request,
                                    @RequestParam(value = "id") Long idColaborador) {
        Usuario colaborador = usuarioService.find(idColaborador);
        model.addAttribute("colaborador", colaborador);
        return "cadastro-colaborador";
    }

    @RequestMapping(value = "/colaborador/excluir-colaborador.action", method = RequestMethod.POST)
    public String excluirColaborador(@RequestParam(value = "id")Long idUsuario) {
        usuarioService.delete(idUsuario);
        return "redirect:/colaboradores.action";
    }


}
