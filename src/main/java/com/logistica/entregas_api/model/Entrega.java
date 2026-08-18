package com.logistica.entregas_api.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String complemento;
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntrega> itens = new ArrayList<>();

    public Entrega() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public List<ItemEntrega> getItens() { return itens; }
    public void setItens(List<ItemEntrega> itens) { this.itens = itens; }


    public void adicionarItem(ItemEntrega item) {
        itens.add(item);
        item.setEntrega(this);
    }
}