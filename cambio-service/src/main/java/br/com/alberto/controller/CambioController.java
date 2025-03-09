package br.com.alberto.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alberto.model.Cambio;
import br.com.alberto.repository.CambioRepository;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
  @Autowired
  private CambioRepository repository;

  @GetMapping(value = "/{amount}/{from}/{to}")
  public Cambio getCambio(@PathVariable ("amount") BigDecimal amount, @PathVariable ("from") String from, @PathVariable ("to") String to) {
    var cambio = repository.findByFromCurrencyAndToCurrency(from, to);
    if (cambio == null) throw new RuntimeException("Currency Unsupported");
    var conversionFactor = cambio.getConversionFactor();
    cambio.setConvertedValue(amount.multiply(conversionFactor));
    cambio.setEnvironment("8000");
    return cambio;
  }
}
