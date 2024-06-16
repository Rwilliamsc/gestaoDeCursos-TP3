package br.edu.infnet.gestaodecursos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "cursos")
    @JsonBackReference
    private List<AlunoModel> alunoModels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AlunoModel> getAlunos() {
        return alunoModels;
    }

    public void setAlunos(List<AlunoModel> alunoModels) {
        this.alunoModels = alunoModels;
    }
}
