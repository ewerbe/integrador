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
        paises.add("Africa do Sul");
        paises.add("Albania");
        paises.add("Alemanha");
        paises.add("Andorra");
        paises.add("Angola");
        paises.add("Anguilla");
        paises.add("Antigua");
        paises.add("Arabia Saudita");
        paises.add("Argentina");
        paises.add("Armenia");
        paises.add("Aruba");
        paises.add("Australia");
        paises.add("Austria");
        paises.add("Azerbaijao");
        paises.add("Bahamas");
        paises.add("Bahrein");
        paises.add("Bangladesh");
        paises.add("Barbados");
        paises.add("Belgica");
        paises.add("Benin");
        paises.add("Bermudas");
        paises.add("Botsuana");
        paises.add("Brasil");
        paises.add("Brunei");
        paises.add("Bulgaria");
        paises.add("Burkina Fasso");
        paises.add("Butao");
        paises.add("Cabo Verde");
        paises.add("Camaroes");
        paises.add("Camboja");
        paises.add("Canada");
        paises.add("Cazaquistao");
        paises.add("Chade");
        paises.add("Chile");
        paises.add("China");
        paises.add("Cidade do Vaticano");
        paises.add("Colombia");
        paises.add("Congo");
        paises.add("Coreia do Norte");
        paises.add("Coreia do Sul");
        paises.add("Costa do Marfim");
        paises.add("Costa Rica");
        paises.add("Croacia");
        paises.add("Dinamarca");
        paises.add("Djibuti");
        paises.add("Dominica");
        paises.add("EUA");
        paises.add("Egito");
        paises.add("El Salvador");
        paises.add("Emirados Arabes");
        paises.add("Equador");
        paises.add("Eritreia");
        paises.add("Escocia");
        paises.add("Eslovaquia");
        paises.add("Eslovenia");
        paises.add("Espanha");
        paises.add("Estonia");
        paises.add("Etiopia");
        paises.add("Fiji");
        paises.add("Filipinas");
        paises.add("Finlandia");
        paises.add("Franca");
        paises.add("Gabao");
        paises.add("Gambia");
        paises.add("Gana");
        paises.add("Georgia");
        paises.add("Gibraltar");
        paises.add("Granada");
        paises.add("Grecia");
        paises.add("Guadalupe");
        paises.add("Guam");
        paises.add("Guatemala");
        paises.add("Guiana");
        paises.add("Guiana Francesa");
        paises.add("Guine-bissau");
        paises.add("Haiti");
        paises.add("Holanda");
        paises.add("Honduras");
        paises.add("Hong Kong");
        paises.add("Hungria");
        paises.add("Iemen");
        paises.add("Ilhas Cayman");
        paises.add("Ilhas Cook");
        paises.add("Ilhas Curacao");
        paises.add("Ilhas Marshall");
        paises.add("Ilhas Turks & Caicos");
        paises.add("Ilhas Virgens (brit.)");
        paises.add("Ilhas Virgens(amer.)");
        paises.add("Ilhas Wallis e Futuna");
        paises.add("India");
        paises.add("Indonesia");
        paises.add("Inglaterra");
        paises.add("Irlanda");
        paises.add("Islandia");
        paises.add("Israel");
        paises.add("Italia");
        paises.add("Jamaica");
        paises.add("Japao");
        paises.add("Jordania");
        paises.add("Kuwait");
        paises.add("Latvia");
        paises.add("Libano");
        paises.add("Liechtenstein");
        paises.add("Lituania");
        paises.add("Luxemburgo");
        paises.add("Macau");
        paises.add("Macedonia");
        paises.add("Madagascar");
        paises.add("Malasia");
        paises.add("Malaui");
        paises.add("Mali");
        paises.add("Malta");
        paises.add("Marrocos");
        paises.add("Martinica");
        paises.add("Mauritania");
        paises.add("Mauritius");
        paises.add("Mexico");
        paises.add("Moldova");
        paises.add("Monaco");
        paises.add("Montserrat");
        paises.add("Nepal");
        paises.add("Nicaragua");
        paises.add("Niger");
        paises.add("Nigeria");
        paises.add("Noruega");
        paises.add("Nova Caledonia");
        paises.add("Nova Zelandia");
        paises.add("Oma");
        paises.add("Palau");
        paises.add("Panama");
        paises.add("Papua-nova Guine");
        paises.add("Paquistao");
        paises.add("Peru");
        paises.add("Polinesia Francesa");
        paises.add("Polonia");
        paises.add("Porto Rico");
        paises.add("Portugal");
        paises.add("Qatar");
        paises.add("Quenia");
        paises.add("Rep. Dominicana");
        paises.add("Rep. Tcheca");
        paises.add("Reunion");
        paises.add("Romenia");
        paises.add("Ruanda");
        paises.add("Russia");
        paises.add("Saipan");
        paises.add("Samoa Americana");
        paises.add("Senegal");
        paises.add("Serra Leone");
        paises.add("Seychelles");
        paises.add("Singapura");
        paises.add("Siria");
        paises.add("Sri Lanka");
        paises.add("St. Kitts & Nevis");
        paises.add("St. Lucia");
        paises.add("St. Vincent");
        paises.add("Sudao");
        paises.add("Suecia");
        paises.add("Suiça");
        paises.add("Suriname");
        paises.add("Tailandia");
        paises.add("Taiwan");
        paises.add("Tanzania");
        paises.add("Togo");
        paises.add("Trinidad & Tobago");
        paises.add("Tunisia");
        paises.add("Turquia");
        paises.add("Ucrania");
        paises.add("Uganda");
        paises.add("Uruguai");
        paises.add("Venezuela");
        paises.add("Vietna");
        paises.add("Zaire");
        paises.add("Zambia");
        paises.add("Zimbabue");
        return paises;
    }

}
