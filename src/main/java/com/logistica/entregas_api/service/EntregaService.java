package com.logistica.entregas_api.service;

import com.logistica.entregas_api.dto.EntregaRequestDTO;
import com.logistica.entregas_api.dto.ItemEntregaRequestDTO;
import com.logistica.entregas_api.model.*;
import com.logistica.entregas_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Transactional
    public Entrega criarEntrega(EntregaRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + dto.getClienteId()));

        Endereco endereco = enderecoRepository.findByCep(dto.getCep())
                .orElseGet(() -> {
                    Endereco novoEndereco = viaCepService.buscarEnderecoPorCep(dto.getCep());
                    return enderecoRepository.save(novoEndereco);
                });

        cliente.adicionarEndereco(endereco);
        clienteRepository.save(cliente);

        Entrega entrega = new Entrega();
        entrega.setCliente(cliente);
        entrega.setEndereco(endereco);
        entrega.setNumero(dto.getNumero());
        entrega.setComplemento(dto.getComplemento());
        entrega.setReferencia(dto.getReferencia());

        for (ItemEntregaRequestDTO itemDto : dto.getItens()) {
            Produto produto = produtoRepository.findById(itemDto.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + itemDto.getProdutoId()));

            if (produto.getQuantidadeEstoque() < itemDto.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome()
                        + ". Disponível: " + produto.getQuantidadeEstoque()
                        + ", Solicitado: " + itemDto.getQuantidade());
            }

            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - itemDto.getQuantidade());
            produtoRepository.save(produto);

            ItemEntrega item = new ItemEntrega();
            item.setProduto(produto);
            item.setQuantidade(itemDto.getQuantidade());
            item.setPrecoUnitario(produto.getPreco());

            entrega.adicionarItem(item);
        }

        return entregaRepository.save(entrega);
    }
}