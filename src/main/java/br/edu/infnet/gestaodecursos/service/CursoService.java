package br.edu.infnet.gestaodecursos.service;

import br.edu.infnet.gestaodecursos.model.Curso;

import br.edu.infnet.gestaodecursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Cacheable(value = "curso")
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Cacheable(value = "curso", key = "#id")
    public Optional<Curso> findById(Long id) {
        return Optional.ofNullable(cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não Localizado!")));
    }

    public Optional<Curso> searchById(Long id) {
        return Optional.ofNullable(cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não Localizado!")));
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @CacheEvict(value = "curso",  key = "#id")
    public Curso update(Long id, Curso curso) {

        if (cursoRepository.existsById(id)) {
            curso.setId(id);
            return cursoRepository.save(curso);
        }
        throw new RuntimeException("Curso não Localizado!");
    }

    @CacheEvict(value = "curso",  key = "#id")
    public void deleteById(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return;
        }

        throw new RuntimeException("Impossivel remover o id: " + id+", curso não localizado.");
    }

}
