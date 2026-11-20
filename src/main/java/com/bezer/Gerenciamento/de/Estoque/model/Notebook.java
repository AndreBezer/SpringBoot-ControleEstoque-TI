package com.bezer.Gerenciamento.de.Estoque.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Notebook")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String marca;

    @Column(nullable = false, length = 30)
    private String processador;

    @Column(nullable = false, length = 30)
    private String tagPatrimonio;

    @Column(nullable = false, length = 30)
    private String status;

    public Notebook() {
    }

    public Notebook(Long id, String marca, String processador, String tagPatrimonio, String status) {
        this.id = id;
        this.marca = marca;
        this.processador = processador;
        this.tagPatrimonio = tagPatrimonio;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getTagPatrimonio() {
        return tagPatrimonio;
    }

    public void setTagPatrimonio(String tagPatrimonio) {
        this.tagPatrimonio = tagPatrimonio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
