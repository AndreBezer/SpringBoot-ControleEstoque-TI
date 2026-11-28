package com.bezer.Gerenciamento.de.Estoque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String nome;

    @Column(nullable = true, unique = true)
    private Long cracha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SetorFuncionario setorFuncionario;

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private List<Notebook> notebook = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, Long cracha, SetorFuncionario setorFuncionario, List<Notebook> notebook) {
        this.id = id;
        this.nome = nome;
        this.cracha = cracha;
        this.setorFuncionario = setorFuncionario;
        this.notebook = notebook;
    }

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

    public Long getCracha() {
        return cracha;
    }

    public void setCracha(Long cracha) {
        this.cracha = cracha;
    }

    public SetorFuncionario getSetorFuncionario() {
        return setorFuncionario;
    }

    public void setSetorFuncionario(SetorFuncionario setorFuncionario) {
        this.setorFuncionario = setorFuncionario;
    }

    public List<Notebook> getNotebook() {
        return notebook;
    }

    public void setNotebook(List<Notebook> notebook) {
        this.notebook = notebook;
    }
}
