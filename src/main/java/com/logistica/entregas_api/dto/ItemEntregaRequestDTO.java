package com.logistica.entregas_api.dto;

public class ItemEntregaRequestDTO {

    private Integer produtoId;
    private Integer quantidade;

    public ItemEntregaRequestDTO() {}

    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Integer produtoId) { this.produtoId = produtoId; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}