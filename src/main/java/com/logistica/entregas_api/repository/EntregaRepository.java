package com.logistica.entregas_api.repository;

import com.logistica.entregas_api.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    List<Entrega> findByClienteId(Long clienteId);

}