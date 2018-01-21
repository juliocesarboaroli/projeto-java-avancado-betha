package com.boaroli.arquetipo.java.avancado.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "GOLEIROS")
public class Goleiro implements MyEntity, Serializable {
    @Id
    @Column(name = "CODIGO_GOLEIRO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome é obrigatório")
    @Size(min = 1, max = 100, message = "O nome deve ter no máximo {max} caracteres")
    @Column(name = "NOME", length = 100, nullable = false)
    @Pattern(regexp = "[^0-9]*", message = "O nome não pode conter números")
    private String nome;

    @NotNull(message = "A altura é obrigatória")
    @Column(name = "ALTURA", precision = 10, scale = 2)
    private BigDecimal altura;

    @Size(min = 10, max = 13, message = "O telefone deve ter no mínimo {min} e no máximo {max} caracteres")
    @Column(name = "TELEFONE", length = 13, nullable = false)
    @Pattern(regexp = "(\\([0-9]{2}\\)[0-9]{4,5}-?[0-9]{4})", message = "O telefone deve corresponder a (00)X0000-0000 ou (00)X00000000")
    private String telefone;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ENDERECO")
    private String endereco;

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

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
