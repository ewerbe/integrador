package br.ufsm.csi.integrador.expomanager.service;

import br.ufsm.csi.integrador.expomanager.model.Linguagem;
import br.ufsm.csi.integrador.expomanager.repository.LinguagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinguagemService {

    @Autowired
    private LinguagemRepository linguagemRepository;

    public Linguagem find(Long idLinguagem) {
        return linguagemRepository.findById(idLinguagem).orElse(null);
    }

    public void save(Linguagem linguagem) {
        linguagemRepository.save(linguagem);
    }

    public List<Linguagem> findAll() {
        return linguagemRepository.findAll();
    }

    public void delete(Long idLinguagem) {
        linguagemRepository.deleteById(idLinguagem);
    }
}
