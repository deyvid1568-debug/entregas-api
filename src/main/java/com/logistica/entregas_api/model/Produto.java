package com.logistica.entregas_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;
    private Integer quantidadeEstoque;
    private Double pesoKg;

    public Produto() {}

    public Produto(String nome, Double preco, Integer quantidadeEstoque, Double pesoKg) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.pesoKg = pesoKg;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(Double pesoKg) { this.pesoKg = pesoKg; }
}