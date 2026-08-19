package com.logistica.entregas_api.dto;

import java.util.List;

public class EntregaRequestDTO {

    private Integer clienteId;
    private String cep;
    private String numero;
    private String complemento;
    private String referencia;
    private List<ItemEntregaRequestDTO> itens;

    public EntregaRequestDTO() {}

    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public List<ItemEntregaRequestDTO> getItens() { return itens; }
    public void setItens(List<ItemEntregaRequestDTO> itens) { this.itens = itens; }
}