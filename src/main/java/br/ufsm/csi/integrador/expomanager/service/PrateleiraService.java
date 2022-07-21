package br.ufsm.csi.integrador.expomanager.service;

import br.ufsm.csi.integrador.expomanager.model.Prateleira;
import br.ufsm.csi.integrador.expomanager.repository.PrateleiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrateleiraService {

    @Autowired
    private PrateleiraRepository prateleiraRepository;

    public Prateleira find(Long idPrateleira) {
        return prateleiraRepository.findById(idPrateleira).orElse(null);
    }

    public void save(Prateleira prateleira) {
        prateleiraRepository.save(prateleira);
    }

    public List<Prateleira> findAll() {
        return prateleiraRepository.findAll();
    }

    public void delete(Long idPrateleira) {
        prateleiraRepository.deleteById(idPrateleira);
    }
}
