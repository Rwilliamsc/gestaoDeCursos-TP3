package br.edu.infnet.gestaodecursos.service;

import br.edu.infnet.gestaodecursos.model.Usuario;
import br.edu.infnet.gestaodecursos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(String id){
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario update(String id, Usuario usuarioUpdate){
        if(usuarioRepository.existsById(id)){
          usuarioUpdate.setId(id);
          return usuarioRepository.save(usuarioUpdate);
        }
        throw new RuntimeException("Impossivel atualizar, usuario não localizado");
    }

    public void deleteById(String id){
        usuarioRepository.deleteById(id);
    }

}
