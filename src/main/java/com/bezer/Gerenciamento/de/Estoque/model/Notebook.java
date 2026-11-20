package com.bezer.Gerenciamento.de.Estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notebook")
public class Notebook {

    private Long id;

    private String marca;

    private String processador;

    private String tagPatrimonio;

    private String status;

}
