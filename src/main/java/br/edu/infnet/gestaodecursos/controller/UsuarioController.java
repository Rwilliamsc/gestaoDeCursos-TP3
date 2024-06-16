package br.edu.infnet.gestaodecursos.controller;

import br.edu.infnet.gestaodecursos.model.Usuario;
import br.edu.infnet.gestaodecursos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodos(){
        return usuarioService.findAll();
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @GetMapping("/{id}")
    public Optional<?> buscar(@PathVariable String id){
        return usuarioService.findById(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable String id, @RequestBody Usuario usuario){
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir (@PathVariable String id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
