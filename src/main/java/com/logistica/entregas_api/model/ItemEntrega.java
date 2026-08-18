package com.logistica.entregas_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_item_entrega")
public class ItemEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;
    private Double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "entrega_id")
    private Entrega entrega;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public ItemEntrega() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(Double precoUnitario) { this.precoUnitario = precoUnitario; }

    public Entrega getEntrega() { return entrega; }
    public void setEntrega(Entrega entrega) { this.entrega = entrega; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
}