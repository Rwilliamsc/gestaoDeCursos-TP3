package br.edu.infnet.gestaodecursos.service;

import br.edu.infnet.gestaodecursos.model.Aluno;
import br.edu.infnet.gestaodecursos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o id: " + id));
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno update(Long id, Aluno alunoUpdate) {
        if (alunoRepository.existsById(id)) {
            alunoUpdate.setId(id);
            return alunoRepository.save(alunoUpdate);
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