package br.ufsm.csi.integrador.expomanager.service;

import br.ufsm.csi.integrador.expomanager.model.Artista;
import br.ufsm.csi.integrador.expomanager.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    public Artista find(Long idArtista) {
        return artistaRepository.findById(idArtista).orElse(null);
    }

    public Artista findByNome(String nome){return artistaRepository.findByNome(nome);}

    public void save(Artista artista) {
        artistaRepository.save(artista);
    }

    public List<Artista> findAll() {
        return artistaRepository.findAll();
    }

    public void delete(Long idArtista) {
        artistaRepository.deleteById(idArtista);
    }
}
