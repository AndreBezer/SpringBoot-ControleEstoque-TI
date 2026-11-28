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

    @Column(nullable = false, length = 30, unique = true)
    private String tagPatrimonio;

    @Column(name = "apelido_computador", length = 50, unique = true)
    private String apelidoComputador;

    // Memória RAM em GB (ex.: 16)
    @Column(name = "mem_ram")
    private Integer memRam;

    // Armazenamento (ROM) em GB (ex.: 512)
    @Column(name = "mem_rom")
    private Integer memRom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusNotebook status;

    @ManyToOne
    @JoinColumn(name = "funcionario_id") // fica nulo enquanto o item está em estoque
    private Funcionario funcionario;

    public Notebook() {
    }

    public Notebook(String marca, Long id, String processador, String tagPatrimonio, String apelidoComputador, Integer memRam, Integer memRom, StatusNotebook status, Funcionario funcionario) {
        this.marca = marca;
        this.id = id;
        this.processador = processador;
        this.tagPatrimonio = tagPatrimonio;
        this.apelidoComputador = apelidoComputador;
        this.memRam = memRam;
        this.memRom = memRom;
        this.status = status;
        this.funcionario = funcionario;
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

    public String getApelidoComputador() {
        return apelidoComputador;
    }

    public void setApelidoComputador(String apelidoComputador) {
        this.apelidoComputador = apelidoComputador;
    }

    public Integer getMemRam() {
        return memRam;
    }

    public void setMemRam(Integer memRam) {
        this.memRam = memRam;
    }

    public Integer getMemRom() {
        return memRom;
    }

    public void setMemRom(Integer memRom) {
        this.memRom = memRom;
    }

    public StatusNotebook getStatus() {
        return status;
    }

    public void setStatus(StatusNotebook status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}