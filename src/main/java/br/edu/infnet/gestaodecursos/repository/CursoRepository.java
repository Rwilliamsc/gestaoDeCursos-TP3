package br.edu.infnet.gestaodecursos.repository;

import br.edu.infnet.gestaodecursos.model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoModel, Long> {
}
