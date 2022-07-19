package br.ufsm.csi.integrador.expomanager.service;

import br.ufsm.csi.integrador.expomanager.model.Usuario;
import br.ufsm.csi.integrador.expomanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario find(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    public void save(Usuario colaborador) {
        usuarioRepository.save(colaborador);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

//    public void update(Usuario colaborador) {
//        usuarioRepository.save(colaborador);
//    }

    //public void delete(Long idUsuario) {
//        usuarioRepository.deleteById(idUsuario);
//    }

    public void delete(Usuario colaborador) {
        usuarioRepository.delete(colaborador);
    }

}
