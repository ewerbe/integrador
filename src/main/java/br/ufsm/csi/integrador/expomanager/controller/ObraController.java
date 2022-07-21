package br.ufsm.csi.integrador.expomanager.controller;

import br.ufsm.csi.integrador.expomanager.model.*;
import br.ufsm.csi.integrador.expomanager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ObraController {

    @Autowired
    ObraService obraService;
    @Autowired
    ArtistaService artistaService;
    @Autowired
    TecnicaService tecnicaService;
    @Autowired
    LinguagemService linguagemService;
    @Autowired
    PrateleiraService prateleiraService;

    @GetMapping({"/cadastro-obra.action", "/cadastro-obra"})
    public String getCadastroObra(Model model) {
        model.addAttribute("isGerente", true);
        return "cadastro-obra";
    }

    @RequestMapping(value = "/obras.action", method = RequestMethod.GET)
    public String getObras(Model model) {
        List<Obra> obras;
        obras = obraService.findAll();
        model.addAttribute("obras", obras);
        model.addAttribute("isGerente", true);
        return "obras";
    }

    @RequestMapping(value = "/obra/salvar-obra.action", method = RequestMethod.POST)
    public String salvarObra(Model model, HttpServletRequest request) throws IOException {
        String idObraString;
        Long idObra = null;
        String titulo;
        Artista artista;
        Long idArtista;
        byte[] imagem;
        Linguagem linguagem;
        Long idLinguagem;
        Tecnica tecnica;
        Long idTecnica;
        Prateleira prateleira;
        Long idPrateleira;
        Float altura;
        Float largura;

        idObraString = request.getParameter("idObra");
        if(idObraString!=null) {
            idObra = Long.valueOf(idObraString);
        }
        titulo = request.getParameter("tituloObra");
        idArtista = Long.parseLong(request.getParameter("idArtistaToObra"));
        idLinguagem = Long.parseLong(request.getParameter("idLinguagemToObra"));
        idTecnica = Long.parseLong(request.getParameter("idTecnicaToObra"));
        idPrateleira = Long.parseLong(request.getParameter("idPrateleiraToObra"));

        artista = getArtistaToObra(idArtista);
        imagem = request.getInputStream().readAllBytes();
        linguagem = getLinguagemToObra(idLinguagem);
        tecnica = getTecnicaToObra(idTecnica);
        prateleira = getPrateleiraToObra(idPrateleira);
        altura = Float.parseFloat(request.getParameter("alturaObra"));
        largura = Float.parseFloat(request.getParameter("larguraObra"));

        Obra obra = new Obra();
        obra.setId(idObra);
        obra.setTitulo(titulo);
        obra.setArtista(artista);
        obra.setImagem(imagem);
        obra.setLinguagem(linguagem);
        obra.setTecnica(tecnica);
        obra.setPrateleira(prateleira);
        obra.setAltura(altura);
        obra.setLargura(largura);

        obraService.save(obra);

        model.addAttribute("obra", obra);
        return "redirect:/obras.action";
    }

    @RequestMapping(value = "/obra/editar-obra.action", method = RequestMethod.POST)
    public String salvarObra(Model model, HttpServletRequest request,
                                @RequestParam(value = "id") Long idObra) {
        Obra obra = obraService.find(idObra);
        //ArrayList<String> paises = getPaises();
        //model.addAttribute("paises", paises);
        model.addAttribute("obra", obra);
        model.addAttribute("isGerente", true);
        return "cadastro-obra";
    }

    @RequestMapping(value = "/obra/excluir-obra.action", method = RequestMethod.POST)
    public String excluirObra(HttpServletRequest request) {
        Long idObra = Long.parseLong(request.getParameter("idObra"));
        obraService.delete(idObra);
        return "redirect:/obras.action";
    }

    //////////////////////////////////////métodos privados de ObraController

    private Artista getArtistaToObra(Long idArtista) {
        Artista artista = artistaService.find(idArtista);
        return artista;
    }

    private Tecnica getTecnicaToObra(Long idTecnica) {
        Tecnica tecnica = tecnicaService.find(idTecnica);
        return tecnica;
    }

    private Linguagem getLinguagemToObra(Long idLinguagem) {
        Linguagem linguagem = linguagemService.find(idLinguagem);
        return linguagem;
    }

    private Prateleira getPrateleiraToObra(Long idPrateleira) {
        Prateleira prateleira = prateleiraService.find(idPrateleira);
        return prateleira;
    }
}
