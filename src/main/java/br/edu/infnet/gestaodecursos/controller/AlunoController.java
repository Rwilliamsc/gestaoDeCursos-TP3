package br.edu.infnet.gestaodecursos.controller;


import br.edu.infnet.gestaodecursos.model.Aluno;
import br.edu.infnet.gestaodecursos.service.AlunoService;
import br.edu.infnet.gestaodecursos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private CursoService cursoService;


    @GetMapping()
    public List<Aluno> listar() {
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<?> listarPorId(@PathVariable Long id) {
        try {
            return alunoService.findById(id);
        }
        catch (Exception e){
            return Optional.of(ResponseEntity.badRequest().body(e.getMessage()));
        }

    }

    @PostMapping()
    public Aluno inserir(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        try {
            return ResponseEntity.ok(alunoService.update(id, aluno));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            alunoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
