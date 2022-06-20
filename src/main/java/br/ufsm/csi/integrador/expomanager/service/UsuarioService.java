package br.ufsm.csi.integrador.expomanager.service;

import br.ufsm.csi.integrador.expomanager.dao.UsuarioDao;
import br.ufsm.csi.integrador.expomanager.model.Usuario;
import br.ufsm.csi.integrador.expomanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    public UsuarioService(UsuarioRepository usuarioRepository) {
//        this.usuarioRepository = usuarioRepository;
//    }

        public void save(Usuario colaborador) {
        usuarioRepository.save(colaborador);
    }

//    public void save(Usuario colaborador) {
//        usuarioDao.save(colaborador);
//    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
//    public List<Usuario> findAll() {
//        return usuarioDao.findAll();
//    }
}
