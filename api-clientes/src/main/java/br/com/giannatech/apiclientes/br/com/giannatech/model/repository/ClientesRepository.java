package br.com.giannatech.apiclientes.br.com.giannatech.model.repository;

import br.com.giannatech.apiclientes.br.com.gianntech.apiclientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
}
