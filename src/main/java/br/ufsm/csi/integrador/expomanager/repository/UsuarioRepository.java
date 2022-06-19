package br.ufsm.csi.integrador.expomanager.repository;

import br.ufsm.csi.integrador.expomanager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //TODO: acho que não vou usar.
//    @Override
//    List<Usuario> findAll();
//
//    @Query(value = "SELECT * FROM USUARIOS US WHERE US.NOME = ?", nativeQuery = true)
//    Usuario findUsuarioByNome(@Param("nome") String nome);
}
