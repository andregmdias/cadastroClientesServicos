package br.com.giannatech.apiclientes.br.com.giannatech.model.repository;

import br.com.giannatech.apiclientes.br.com.gianntech.apiclientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicosRepository extends JpaRepository<Servico, Integer> {
}
