package com.logistica.entregas_api.service;

import com.logistica.entregas_api.dto.ViaCepResponseDTO;
import com.logistica.entregas_api.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    @Autowired
    private RestTemplate restTemplate;

    public Endereco buscarEnderecoPorCep(String cep) {
        String cepFormatado = cep.replaceAll("\\D", "");

        String url = "https://viacep.com.br/ws/" + cepFormatado + "/json/";

        ViaCepResponseDTO response = restTemplate.getForObject(url, ViaCepResponseDTO.class);

        if (response == null || Boolean.TRUE.equals(response.getErro())) {
            throw new RuntimeException("CEP " + cep + " não encontrado ou inválido!");
        }

        Endereco endereco = new Endereco();
        endereco.setCep(response.getCep());
        endereco.setLogradouro(response.getLogradouro());
        endereco.setBairro(response.getBairro());
        endereco.setCidade(response.getLocalidade());
        endereco.setUf(response.getUf());

        return endereco;
    }
}