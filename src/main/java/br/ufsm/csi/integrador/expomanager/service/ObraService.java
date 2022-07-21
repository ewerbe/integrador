package br.ufsm.csi.integrador.expomanager.service;

import br.ufsm.csi.integrador.expomanager.model.Obra;
import br.ufsm.csi.integrador.expomanager.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;

    public Obra find(Long idObra) {
        return obraRepository.findById(idObra).orElse(null);
    }

    public void save(Obra obra) {
        obraRepository.save(obra);
    }

    public List<Obra> findAll() {
        return obraRepository.findAll();
    }

    public void delete(Long idObra) {
        obraRepository.deleteById(idObra);
    }
}
