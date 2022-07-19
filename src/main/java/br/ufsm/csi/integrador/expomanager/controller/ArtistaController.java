package br.ufsm.csi.integrador.expomanager.controller;

import br.ufsm.csi.integrador.expomanager.model.Artista;
import br.ufsm.csi.integrador.expomanager.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping({"/cadastro-artista.action", "/cadastro-artista"})
    public String getCadastroArtista(Model model) {
        ArrayList<String> paises = getPaises();
        model.addAttribute("paises", paises);
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
        String idArtistaString = null;
        idArtistaString = request.getParameter("idArtista");
        String anoMorteArtistaString = null;
        request.getParameter("anoMorteArtista");
        Long idArtista = null;
        if(idArtistaString!=null) {
            idArtista = Long.valueOf(idArtistaString);
        }
        String nome = request.getParameter("nomeArtista");
        String paisOrigem = request.getParameter("paisOrigemArtista");
        Long anoNascimento = Long.valueOf( (request.getParameter("anoNascimentoArtista")) );
        Long anoMorte = null;
        if(anoMorteArtistaString != null){
            anoMorte = Long.valueOf( anoMorteArtistaString );
        }

        Artista artista = new Artista();
        artista.setId(idArtista);
        artista.setNome(nome);
        artista.setPaisOrigem(paisOrigem);
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
        ArrayList<String> paises = getPaises();
        model.addAttribute("paises", paises);
        model.addAttribute("artista", artista);
        model.addAttribute("isGerente", true);
        return "cadastro-artista";
    }

    @RequestMapping(value = "/artista/excluir-artista.action", method = RequestMethod.POST)
    public String excluirColaborador(HttpServletRequest request) {
        Long idArtista = Long.parseLong(request.getParameter("idArtista"));
        artistaService.delete(idArtista);
        return "redirect:/artistas.action";
    }



//

    ///////////////////////////////

    private ArrayList<String> getPaises() {
        ArrayList<String> paises = new ArrayList<>();
        paises.add("�frica do Sul");
        paises.add("Alb�nia");
        paises.add("Alemanha");
        paises.add("Andorra");
        paises.add("Angola");
        paises.add("Anguilla");
        paises.add("Antigua");
        paises.add("Ar�bia Saudita");
        paises.add("Argentina");
        paises.add("Arm�nia");
        paises.add("Aruba");
        paises.add("Austr�lia");
        paises.add("�ustria");
        paises.add("Azerbaij�o");
        paises.add("Bahamas");
        paises.add("Bahrein");
        paises.add("Bangladesh");
        paises.add("Barbados");
        paises.add("B�lgica");
        paises.add("Benin");
        paises.add("Bermudas");
        paises.add("Botsuana");
        paises.add("Brasil");
        paises.add("Brunei");
        paises.add("Bulg�ria");
        paises.add("Burkina Fasso");
        paises.add("But�o");
        paises.add("Cabo Verde");
        paises.add("Camar�es");
        paises.add("Camboja");
        paises.add("Canad�");
        paises.add("Cazaquist�o");
        paises.add("Chade");
        paises.add("Chile");
        paises.add("China");
        paises.add("Cidade do Vaticano");
        paises.add("Col�mbia");
        paises.add("Congo");
        paises.add("Cor�ia do Norte");
        paises.add("Cor�ia do Sul");
        paises.add("Costa do Marfim");
        paises.add("Costa Rica");
        paises.add("Cro�cia");
        paises.add("Dinamarca");
        paises.add("Djibuti");
        paises.add("Dominica");
        paises.add("EUA");
        paises.add("Egito");
        paises.add("El Salvador");
        paises.add("Emirados �rabes");
        paises.add("Equador");
        paises.add("Eritr�ia");
        paises.add("Esc�cia");
        paises.add("Eslov�quia");
        paises.add("Eslov�nia");
        paises.add("Espanha");
        paises.add("Est�nia");
        paises.add("Eti�pia");
        paises.add("Fiji");
        paises.add("Filipinas");
        paises.add("Finl�ndia");
        paises.add("Fran�a");
        paises.add("Gab�o");
        paises.add("G�mbia");
        paises.add("Gana");
        paises.add("Ge�rgia");
        paises.add("Gibraltar");
        paises.add("Granada");
        paises.add("Gr�cia");
        paises.add("Guadalupe");
        paises.add("Guam");
        paises.add("Guatemala");
        paises.add("Guiana");
        paises.add("Guiana Francesa");
        paises.add("Guin�-bissau");
        paises.add("Haiti");
        paises.add("Holanda");
        paises.add("Honduras");
        paises.add("Hong Kong");
        paises.add("Hungria");
        paises.add("I�men");
        paises.add("Ilhas Cayman");
        paises.add("Ilhas Cook");
        paises.add("Ilhas Cura�ao");
        paises.add("Ilhas Marshall");
        paises.add("Ilhas Turks & Caicos");
        paises.add("Ilhas Virgens (brit.)");
        paises.add("Ilhas Virgens(amer.)");
        paises.add("Ilhas Wallis e Futuna");
        paises.add("�ndia");
        paises.add("Indon�sia");
        paises.add("Inglaterra");
        paises.add("Irlanda");
        paises.add("Isl�ndia");
        paises.add("Israel");
        paises.add("It�lia");
        paises.add("Jamaica");
        paises.add("Jap�o");
        paises.add("Jord�nia");
        paises.add("Kuwait");
        paises.add("Latvia");
        paises.add("L�bano");
        paises.add("Liechtenstein");
        paises.add("Litu�nia");
        paises.add("Luxemburgo");
        paises.add("Macau");
        paises.add("Maced�nia");
        paises.add("Madagascar");
        paises.add("Mal�sia");
        paises.add("Malaui");
        paises.add("Mali");
        paises.add("Malta");
        paises.add("Marrocos");
        paises.add("Martinica");
        paises.add("Maurit�nia");
        paises.add("Mauritius");
        paises.add("M�xico");
        paises.add("Moldova");
        paises.add("M�naco");
        paises.add("Montserrat");
        paises.add("Nepal");
        paises.add("Nicar�gua");
        paises.add("Niger");
        paises.add("Nig�ria");
        paises.add("Noruega");
        paises.add("Nova Caled�nia");
        paises.add("Nova Zel�ndia");
        paises.add("Om�");
        paises.add("Palau");
        paises.add("Panam�");
        paises.add("Papua-nova Guin�");
        paises.add("Paquist�o");
        paises.add("Peru");
        paises.add("Polin�sia Francesa");
        paises.add("Pol�nia");
        paises.add("Porto Rico");
        paises.add("Portugal");
        paises.add("Qatar");
        paises.add("Qu�nia");
        paises.add("Rep. Dominicana");
        paises.add("Rep. Tcheca");
        paises.add("Reunion");
        paises.add("Rom�nia");
        paises.add("Ruanda");
        paises.add("R�ssia");
        paises.add("Saipan");
        paises.add("Samoa Americana");
        paises.add("Senegal");
        paises.add("Serra Leone");
        paises.add("Seychelles");
        paises.add("Singapura");
        paises.add("S�ria");
        paises.add("Sri Lanka");
        paises.add("St. Kitts & Nevis");
        paises.add("St. L�cia");
        paises.add("St. Vincent");
        paises.add("Sud�o");
        paises.add("Su�cia");
        paises.add("Sui�a");
        paises.add("Suriname");
        paises.add("Tail�ndia");
        paises.add("Taiwan");
        paises.add("Tanz�nia");
        paises.add("Togo");
        paises.add("Trinidad & Tobago");
        paises.add("Tun�sia");
        paises.add("Turquia");
        paises.add("Ucr�nia");
        paises.add("Uganda");
        paises.add("Uruguai");
        paises.add("Venezuela");
        paises.add("Vietn�");
        paises.add("Zaire");
        paises.add("Z�mbia");
        paises.add("Zimb�bue");
        return paises;
    }

}
