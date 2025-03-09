package br.com.alberto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.alberto.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {
Cambio findByFromCurrencyAndToCurrency(@Param("from") String from, @Param("to") String to);

}
