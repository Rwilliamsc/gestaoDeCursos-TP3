package br.edu.infnet.gestaodecursos.service;

import br.edu.infnet.gestaodecursos.model.Aluno;
import br.edu.infnet.gestaodecursos.model.Curso;
import br.edu.infnet.gestaodecursos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoService cursoService;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return Optional.ofNullable(alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o id: " + id)));
    }

    public Aluno save(Aluno aluno) {
        Set<Curso> cursos =  aluno.getCursos().stream()
                .map(curso -> cursoService.searchById(curso.getId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        aluno.setCursos(null);
        Aluno savedAluno = alunoRepository.save(aluno);
        savedAluno.setCursos(new ArrayList<>(cursos));
        return alunoRepository.save(savedAluno);
    }

    public Aluno update(Long id, Aluno alunoUpdate) {
        if (alunoRepository.existsById(id)) {
            alunoUpdate.setId(id);
            return this.save(alunoUpdate);
        }
        throw new RuntimeException("Aluno não Localizado!");
    }

    public void deleteById(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return;
        }
        throw new RuntimeException("Impossivel remover o id: " + id+", aluno não localizado.");
    }
}