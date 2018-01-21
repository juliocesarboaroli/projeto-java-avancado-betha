package com.boaroli.arquetipo.java.avancado.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "CONVOCACOES")
public class Convocacao implements MyEntity, Serializable {

    @Id
    @Column(name = "CODIGO_CONVOCACAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATA_HORA", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "ENDERECO", nullable = false)
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "GOLEIRO", nullable = false,
            foreignKey = @ForeignKey(name = "FK_CONVOCACAO_GOLEIRO", value = ConstraintMode.CONSTRAINT))
    private Goleiro goleiro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
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
