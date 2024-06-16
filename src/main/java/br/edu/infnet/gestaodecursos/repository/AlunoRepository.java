package br.edu.infnet.gestaodecursos.repository;

import br.edu.infnet.gestaodecursos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
