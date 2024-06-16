package br.edu.infnet.gestaodecursos.controller;


import br.edu.infnet.gestaodecursos.model.Curso;
import br.edu.infnet.gestaodecursos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listar() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Curso> listarPorId(@PathVariable Long id) {
        try {
            return cursoService.findById(id);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping()
    public Curso cadastrar(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Curso curso) {
        try {
            return ResponseEntity.ok(cursoService.update(id, curso));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCurso(@PathVariable Long id) {
        try {
            cursoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
