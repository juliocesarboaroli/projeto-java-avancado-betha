package com.boaroli.arquetipo.java.avancado.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "CONVOCACOES")
public class Convocacao implements MyEntity, Serializable {

    @Id
    @Column(name = "CODIGO_CONVOCACAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATA", nullable = false)
    private LocalDate data;

    @Column(name = "HORA", nullable = false)
    private LocalTime hora;

    @Column(name = "ENDERECO", nullable = false)
    private String endereco;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "GOLEIRO", nullable = false,
            foreignKey = @ForeignKey(name = "FK_CONVOCACAO_GOLEIRO", value = ConstraintMode.CONSTRAINT))
    private Goleiro goleiro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Goleiro getGoleiro() {
        return goleiro;
    }

    public void setGoleiro(Goleiro goleiro) {
        this.goleiro = goleiro;
    }
}
