package br.ufsm.csi.integrador.expomanager.controller;

import br.ufsm.csi.integrador.expomanager.model.Artista;
import br.ufsm.csi.integrador.expomanager.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping({"/cadastro-artista.action", "/cadastro-artista"})
    public String getCadastroArtista(Model model) {
        model.addAttribute("isGerente", true);
        return "cadastro-artista";
    }

    @RequestMapping(value = "/artistas.action", method = RequestMethod.GET)
    public String getArtistas(Model model) {
        List<Artista> artistas;
        artistas = artistaService.findAll();
        model.addAttribute("artistas", artistas);
        model.addAttribute("isGerente", true);
        return "artistas";
    }

    @RequestMapping(value = "/artista/salvar-artista.action", method = RequestMethod.POST)
    public String salvarArtista(Model model, HttpServletRequest request) {
        String idArtistaString = request.getParameter("idArtista");
        Long idArtista = null;
        if(!idArtistaString.isEmpty()) {
            idArtista = Long.valueOf(idArtistaString);
        }
        String nome = request.getParameter("nomeArtista");
        String nacionalidade = request.getParameter("nacionalidadeArtista");
        Long anoNascimento = Long.valueOf( (request.getParameter("anoNascimento")) );
        Long anoMorte = Long.valueOf( (request.getParameter("anoMorteArtista")) );

        Artista artista = new Artista();
        artista.setId(idArtista);
        artista.setNome(nome);
        artista.setNacionalidade(nacionalidade);
        artista.setAnoNascimento(anoNascimento);
        artista.setAnoMorte(anoMorte);

        artistaService.save(artista);

        model.addAttribute("artista", artista);
        return "redirect:/artistas.action";
    }

    @RequestMapping(value = "/artista/editar-artista.action", method = RequestMethod.POST)
    public String salvarArtista(Model model, HttpServletRequest request,
                                    @RequestParam(value = "id") Long idArtista) {
        Artista artista = artistaService.find(idArtista);
        model.addAttribute("artista", artista);
        return "cadastro-artista";
    }

    @RequestMapping(value = "/artista/excluir-artista.action", method = RequestMethod.POST)
    public String excluirColaborador(@RequestParam(value = "id")Long idArtista) {
        artistaService.delete(idArtista);
        return "redirect:/artistas.action";
    }


}
