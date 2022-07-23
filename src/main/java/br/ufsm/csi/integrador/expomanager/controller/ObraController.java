package br.ufsm.csi.integrador.expomanager.controller;

import br.ufsm.csi.integrador.expomanager.model.*;
import br.ufsm.csi.integrador.expomanager.service.*;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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
        List<Artista> artistasToObra;
        List<Linguagem> linguagensToObra;
        List<Tecnica> tecnicasToObra;
        List<Prateleira> prateleirasToObra;

        artistasToObra = artistaService.findAll();
        linguagensToObra = linguagemService.findAll();
        tecnicasToObra = tecnicaService.findAll();
        prateleirasToObra = prateleiraService.findAll();

        model.addAttribute("artistasToObra", artistasToObra);
        model.addAttribute("linguagensToObra", linguagensToObra);
        model.addAttribute("tecnicasToObra", tecnicasToObra);
        model.addAttribute("prateleirasToObra", prateleirasToObra);
        model.addAttribute("isGerente", true);
        return "cadastro-obra";
    }

    @RequestMapping(value = "/obras.action", method = RequestMethod.GET)
    public String getObras(Model model) throws UnsupportedEncodingException {
        List<Obra> obras;
        obras = getObrasToView();

        model.addAttribute("obras", obras);
        model.addAttribute("isGerente", true);
        return "obras";
    }

    @RequestMapping(value = "/obra/salvar-obra.action", method = RequestMethod.POST)
    public String salvarObra(Model model, HttpServletRequest request,
                             @RequestParam( value = "img", required = false) MultipartFile img) throws IOException, ServletException {
        String idObraString;
        Long idObra = null;
        String titulo;
        Artista artista;
        Long idArtista;
       // Part imagemPart;
        byte[] imagem;
        //InputStream inputStreamImagemToObra;
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

        if(img.getSize() == 0) {
            imagem = obraService.find(idObra).getImagem();
        }else {
            imagem = multipartFileToByte(img);
        }

        titulo = request.getParameter("tituloObra");
        idArtista = Long.parseLong(request.getParameter("artistaToObra"));
        idLinguagem = Long.parseLong(request.getParameter("linguagemToObra"));
        idTecnica = Long.parseLong(request.getParameter("tecnicaToObra"));
        idPrateleira = Long.parseLong(request.getParameter("prateleiraToObra"));

        artista = getArtistaToObra(idArtista);
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

        //model.addAttribute("obra", obra); não precisa inserir no model
        return "redirect:/artistas.action";
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


    private String byteToBase64(byte[] bt) throws UnsupportedEncodingException {
        return new String(Base64.encode(bt), "UTF-8");
    }

    private List<Obra> getObrasToView() throws UnsupportedEncodingException {
        List<Obra> obras = obraService.findAll();
        for(Obra obra : obras) {
            obra.setImagemString(byteToBase64(obra.getImagem()));
        }
        return obras;
    }

    private byte[] multipartFileToByte(MultipartFile img) throws IOException {
        byte[] bytesImg = img.getBytes();
        return bytesImg;
    }

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
