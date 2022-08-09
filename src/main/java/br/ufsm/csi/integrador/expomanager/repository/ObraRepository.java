package br.ufsm.csi.integrador.expomanager.repository;

import br.ufsm.csi.integrador.expomanager.model.Artista;
import br.ufsm.csi.integrador.expomanager.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObraRepository extends JpaRepository<Obra, Long> {

    List<Obra> findByArtista(Artista artista);
}
