package br.ufsm.csi.integrador.expomanager.repository;

import br.ufsm.csi.integrador.expomanager.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long>{
    Artista findByNome(String nome);
}
