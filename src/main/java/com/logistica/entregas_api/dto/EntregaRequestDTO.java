package com.logistica.entregas_api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class EntregaRequestDTO {

    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clienteId;

    @NotBlank(message = "O CEP é obrigatório")
    @Pattern(regexp = "\\d{8}|\\d{5}-\\d{3}", message = "Formato de CEP inválido")
    private String cep;

    @NotBlank(message = "O número é obrigatório")
    private String numero;

    private String complemento;
    private String referencia;

    @NotEmpty(message = "A entrega deve conter pelo menos um item")
    @Valid
    private List<ItemEntregaRequestDTO> itens;

    public EntregaRequestDTO() {}

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

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