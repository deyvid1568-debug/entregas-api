package com.logistica.entregas_api.dto;

public class ItemEntregaRequestDTO {

    private Long produtoId;
    private Integer quantidade;

    public ItemEntregaRequestDTO() {}

    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}