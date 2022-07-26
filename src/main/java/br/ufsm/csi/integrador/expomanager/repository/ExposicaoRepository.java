package br.ufsm.csi.integrador.expomanager.repository;

import br.ufsm.csi.integrador.expomanager.model.Exposicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExposicaoRepository extends JpaRepository<Exposicao, Long> {
}
