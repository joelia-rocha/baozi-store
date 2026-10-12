package com.baozistore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome e obrigatorio")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull(message = "O preco e obrigatorio")
    @DecimalMin(value = "0.00", inclusive = false, message = "O preco deve ser maior que zero")
    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @NotNull(message = "O estoque e obrigatorio")
    @Column(name = "estoque", nullable = false)
    private Boolean estoque;

    public Produto() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public Boolean getEstoque() { return estoque; }
    public void setEstoque(Boolean estoque) { this.estoque = estoque; }
}
