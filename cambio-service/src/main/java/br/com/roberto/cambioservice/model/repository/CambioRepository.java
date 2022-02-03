package br.com.roberto.cambioservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.roberto.cambioservice.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {
	
	Cambio findByFromAndTo(String from, String to);

}
