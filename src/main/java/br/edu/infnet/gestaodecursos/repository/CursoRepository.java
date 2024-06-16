package br.edu.infnet.gestaodecursos.repository;

import br.edu.infnet.gestaodecursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
