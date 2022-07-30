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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
public class ExposicaoController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ObraService obraService;
    @Autowired
    ExposicaoService exposicaoService;
    @Autowired
    ArtistaService artistaService;
    @Autowired
    TecnicaService tecnicaService;
    @Autowired
    LinguagemService linguagemService;
    @Autowired
    PrateleiraService prateleiraService;

    @GetMapping({"/cadastro-exposicao.action", "/cadastro-exposicao"})
    public String getCadastroExposicao(Model model,
                                       @RequestParam(value = "id") Long idUsuario) throws UnsupportedEncodingException {

        Usuario usuario = usuarioService.find(idUsuario);
        List<Obra> obrasToExposicao = getObrasToExposicao();

        model.addAttribute("obrasToExposicao", obrasToExposicao);
        model.addAttribute("usuario", usuario);
        model.addAttribute("isGerente", true);
        return "cadastro-exposicao";
    }

    @RequestMapping(value = "/exposicoes.action", method = RequestMethod.GET)
    public String getExposicoes(Model model) throws UnsupportedEncodingException {
        List<Exposicao> exposicoes;
        exposicoes = getExposicoesToView();

        model.addAttribute("exposicoes", exposicoes);
        model.addAttribute("isGerente", true);
        return "exposicoes";
    }

    @RequestMapping(value = "/exposicao/salvar-exposicao.action", method = RequestMethod.POST)
    public String salvarExposicao(HttpServletRequest request,
                             @RequestParam( value = "imgBanner", required = false) MultipartFile imgBanner,
                             @RequestParam(value = "id") Long idUsuario)
            throws IOException {
        //id_exposicao, banner, descricao, ativa, dataInicio, dataFim, titulo, usuarioGerente, Set<Obra> obras, ativa, acervo;
        //TODO: parou aqui ........
        //TODO: ver como lidar com as datas a partir da view jsp do cadastro - tá meio xarope de resolver!!
        String idExposicaoString;
        Long idExposicao = null;
        String titulo;
        String descricao;
        List<Obra> obrasToExposicao;
        byte[] banner;
        Usuario usuario = usuarioService.find(idUsuario);
        Date dataInicio;
        Date dataFim;
        String dataInicioString;
        String dataFimString;
        Boolean ativa;
        Boolean acervo;

        idExposicaoString = request.getParameter("idExposicao");
        if(idExposicaoString!=null) {
            idExposicao = Long.valueOf(idExposicaoString);
        }

        if(imgBanner.getSize() == 0) {
            banner = exposicaoService.find(idExposicao).getBanner();
        }else {
            banner = multipartFileToByte(imgBanner);
        }

        titulo = request.getParameter("tituloExpo");

        dataInicioString = request.getParameter("dataInicio");
        dataFimString = request.getParameter("dataFim");

        Exposicao exposicao = new Exposicao();
        exposicao.setId(idExposicao);
        exposicao.setTitulo(titulo);
        exposicao.setUsuarioGerente(usuario);
        exposicao.setBanner(banner);
        //exposicao.setAcervo(acervo);
        //exposicao.setAtiva(ativa);
        //exposicao.setObras(obrasToExposicao);
        //exposicao.setDataInicio(dataInicio);
        //exposicao.setDataFim(dataFim);
        //exposicao.setDescricao(descricao);


        exposicaoService.save(exposicao);

        return "redirect:/exposicoes.action";
    }

    @RequestMapping(value = "/exposicao/editar-exposicao.action", method = RequestMethod.POST)
    public String editarExposicao(Model model, HttpServletRequest request,
                             @RequestParam(value = "id") Long idObra) throws UnsupportedEncodingException {
        //Obra obra = getObraToView(idObra);
        List<Artista> artistasToObra;
        List<Linguagem> linguagensToObra;
        List<Tecnica> tecnicasToObra;
        List<Prateleira> prateleirasToObra;

        artistasToObra = artistaService.findAll();
        linguagensToObra = linguagemService.findAll();
        tecnicasToObra = tecnicaService.findAll();
        prateleirasToObra = prateleiraService.findAll();

        //ArrayList<String> paises = getPaises();
        //model.addAttribute("paises", paises);
        //model.addAttribute("obra", obra);
        model.addAttribute("artistasToObra", artistasToObra);
        model.addAttribute("linguagensToObra", linguagensToObra);
        model.addAttribute("tecnicasToObra", tecnicasToObra);
        model.addAttribute("prateleirasToObra", prateleirasToObra);
        model.addAttribute("isGerente", true);
        return "cadastro-exposicao";
    }

    @RequestMapping(value = "/exposicao/excluir-exposicao.action", method = RequestMethod.POST)
    public String excluirExposicao(HttpServletRequest request) {
        Long idObra = Long.parseLong(request.getParameter("idObra"));
        obraService.delete(idObra);
        return "redirect:/exposicoes.action";
    }

    //////////////////////////////////////métodos privados de ExposicaoController


    private List<Obra> getObrasToExposicao() throws UnsupportedEncodingException {
        List<Obra> obrasToExposicao = obraService.findAll();
        for(Obra obra : obrasToExposicao) {
            obra.setImagemString(byteToBase64(obra.getImagem()));
        }
        return obrasToExposicao;
    }

    private String byteToBase64(byte[] bt) throws UnsupportedEncodingException {
        return new String(Base64.encode(bt), "UTF-8");
    }

    private Exposicao getExposicaoToView(Long idExposicao) throws UnsupportedEncodingException {
        Exposicao exposicao = exposicaoService.find(idExposicao);
        if(exposicao.getBanner() != null) {
            exposicao.setBannerString(byteToBase64(exposicao.getBanner()));
        }
        return exposicao;
    }

    private List<Exposicao> getExposicoesToView() throws UnsupportedEncodingException {
        List<Exposicao> exposicoes = exposicaoService.findAll();
        for(Exposicao exposicao : exposicoes) {
            if(exposicao.getBanner() != null) {
                exposicao.setBannerString(byteToBase64(exposicao.getBanner()));
            }
        }
        return exposicoes;
    }

    private byte[] multipartFileToByte(MultipartFile img) throws IOException {
        byte[] bytesBanner = img.getBytes();
        return bytesBanner;
    }

}

