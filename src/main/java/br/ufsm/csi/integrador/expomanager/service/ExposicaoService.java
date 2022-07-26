package br.ufsm.csi.integrador.expomanager.service;

import br.ufsm.csi.integrador.expomanager.model.Exposicao;
import br.ufsm.csi.integrador.expomanager.repository.ExposicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExposicaoService {

    @Autowired
    private ExposicaoRepository exposicaoRepository;

    public Exposicao find(Long idExposicao) {
        return exposicaoRepository.findById(idExposicao).orElse(null);
    }

    public void save(Exposicao obra) {
        exposicaoRepository.save(obra);
    }

    public List<Exposicao> findAll() {
        return exposicaoRepository.findAll();
    }

    public void delete(Long idExposicao) {
        exposicaoRepository.deleteById(idExposicao);
    }
}
