package br.ufsm.csi.integrador.expomanager.repository;

import br.ufsm.csi.integrador.expomanager.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {
}
