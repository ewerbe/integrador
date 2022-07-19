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
        paises.add("África do Sul");
        paises.add("Albânia");
        paises.add("Alemanha");
        paises.add("Andorra");
        paises.add("Angola");
        paises.add("Anguilla");
        paises.add("Antigua");
        paises.add("Arábia Saudita");
        paises.add("Argentina");
        paises.add("Armênia");
        paises.add("Aruba");
        paises.add("Austrália");
        paises.add("Áustria");
        paises.add("Azerbaijão");
        paises.add("Bahamas");
        paises.add("Bahrein");
        paises.add("Bangladesh");
        paises.add("Barbados");
        paises.add("Bélgica");
        paises.add("Benin");
        paises.add("Bermudas");
        paises.add("Botsuana");
        paises.add("Brasil");
        paises.add("Brunei");
        paises.add("Bulgária");
        paises.add("Burkina Fasso");
        paises.add("Butão");
        paises.add("Cabo Verde");
        paises.add("Camarões");
        paises.add("Camboja");
        paises.add("Canadá");
        paises.add("Cazaquistão");
        paises.add("Chade");
        paises.add("Chile");
        paises.add("China");
        paises.add("Cidade do Vaticano");
        paises.add("Colômbia");
        paises.add("Congo");
        paises.add("Coréia do Norte");
        paises.add("Coréia do Sul");
        paises.add("Costa do Marfim");
        paises.add("Costa Rica");
        paises.add("Croácia");
        paises.add("Dinamarca");
        paises.add("Djibuti");
        paises.add("Dominica");
        paises.add("EUA");
        paises.add("Egito");
        paises.add("El Salvador");
        paises.add("Emirados Árabes");
        paises.add("Equador");
        paises.add("Eritréia");
        paises.add("Escócia");
        paises.add("Eslováquia");
        paises.add("Eslovênia");
        paises.add("Espanha");
        paises.add("Estônia");
        paises.add("Etiópia");
        paises.add("Fiji");
        paises.add("Filipinas");
        paises.add("Finlândia");
        paises.add("França");
        paises.add("Gabão");
        paises.add("Gâmbia");
        paises.add("Gana");
        paises.add("Geórgia");
        paises.add("Gibraltar");
        paises.add("Granada");
        paises.add("Grécia");
        paises.add("Guadalupe");
        paises.add("Guam");
        paises.add("Guatemala");
        paises.add("Guiana");
        paises.add("Guiana Francesa");
        paises.add("Guiné-bissau");
        paises.add("Haiti");
        paises.add("Holanda");
        paises.add("Honduras");
        paises.add("Hong Kong");
        paises.add("Hungria");
        paises.add("Iêmen");
        paises.add("Ilhas Cayman");
        paises.add("Ilhas Cook");
        paises.add("Ilhas Curaçao");
        paises.add("Ilhas Marshall");
        paises.add("Ilhas Turks & Caicos");
        paises.add("Ilhas Virgens (brit.)");
        paises.add("Ilhas Virgens(amer.)");
        paises.add("Ilhas Wallis e Futuna");
        paises.add("Índia");
        paises.add("Indonésia");
        paises.add("Inglaterra");
        paises.add("Irlanda");
        paises.add("Islândia");
        paises.add("Israel");
        paises.add("Itália");
        paises.add("Jamaica");
        paises.add("Japão");
        paises.add("Jordânia");
        paises.add("Kuwait");
        paises.add("Latvia");
        paises.add("Líbano");
        paises.add("Liechtenstein");
        paises.add("Lituânia");
        paises.add("Luxemburgo");
        paises.add("Macau");
        paises.add("Macedônia");
        paises.add("Madagascar");
        paises.add("Malásia");
        paises.add("Malaui");
        paises.add("Mali");
        paises.add("Malta");
        paises.add("Marrocos");
        paises.add("Martinica");
        paises.add("Mauritânia");
        paises.add("Mauritius");
        paises.add("México");
        paises.add("Moldova");
        paises.add("Mônaco");
        paises.add("Montserrat");
        paises.add("Nepal");
        paises.add("Nicarágua");
        paises.add("Niger");
        paises.add("Nigéria");
        paises.add("Noruega");
        paises.add("Nova Caledônia");
        paises.add("Nova Zelândia");
        paises.add("Omã");
        paises.add("Palau");
        paises.add("Panamá");
        paises.add("Papua-nova Guiné");
        paises.add("Paquistão");
        paises.add("Peru");
        paises.add("Polinésia Francesa");
        paises.add("Polônia");
        paises.add("Porto Rico");
        paises.add("Portugal");
        paises.add("Qatar");
        paises.add("Quênia");
        paises.add("Rep. Dominicana");
        paises.add("Rep. Tcheca");
        paises.add("Reunion");
        paises.add("Romênia");
        paises.add("Ruanda");
        paises.add("Rússia");
        paises.add("Saipan");
        paises.add("Samoa Americana");
        paises.add("Senegal");
        paises.add("Serra Leone");
        paises.add("Seychelles");
        paises.add("Singapura");
        paises.add("Síria");
        paises.add("Sri Lanka");
        paises.add("St. Kitts & Nevis");
        paises.add("St. Lúcia");
        paises.add("St. Vincent");
        paises.add("Sudão");
        paises.add("Suécia");
        paises.add("Suiça");
        paises.add("Suriname");
        paises.add("Tailândia");
        paises.add("Taiwan");
        paises.add("Tanzânia");
        paises.add("Togo");
        paises.add("Trinidad & Tobago");
        paises.add("Tunísia");
        paises.add("Turquia");
        paises.add("Ucrânia");
        paises.add("Uganda");
        paises.add("Uruguai");
        paises.add("Venezuela");
        paises.add("Vietnã");
        paises.add("Zaire");
        paises.add("Zâmbia");
        paises.add("Zimbábue");
        return paises;
    }

}
