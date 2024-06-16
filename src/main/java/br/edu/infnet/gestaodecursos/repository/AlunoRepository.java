package br.edu.infnet.gestaodecursos.repository;

import br.edu.infnet.gestaodecursos.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
}
