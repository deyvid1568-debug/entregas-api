package com.logistica.entregas_api.repository;

import com.logistica.entregas_api.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findByCep(String cep);
}
