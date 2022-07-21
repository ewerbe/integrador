package br.ufsm.csi.integrador.expomanager.service;

import br.ufsm.csi.integrador.expomanager.model.Tecnica;
import br.ufsm.csi.integrador.expomanager.repository.TecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicaService {

    @Autowired
    private TecnicaRepository tecnicaRepository;

    public Tecnica find(Long idTecnica) {
        return tecnicaRepository.findById(idTecnica).orElse(null);
    }

    public void save(Tecnica tecnica) {
        tecnicaRepository.save(tecnica);
    }

    public List<Tecnica> findAll() {
        return tecnicaRepository.findAll();
    }

    public void delete(Long idTecnica) {
        tecnicaRepository.deleteById(idTecnica);
    }
}
