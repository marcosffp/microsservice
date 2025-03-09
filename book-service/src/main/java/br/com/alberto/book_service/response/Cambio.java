package br.com.alberto.book_service.response;


public class Cambio {
  private Long id;
  private String fromCurrency;
  private String toCurrency;
  private Double conversionFactor;
  private Double convertedValue;
  private String environment;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFromCurrency() {
    return fromCurrency;
  }

  public void setFromCurrency(String fromCurrency) {
    this.fromCurrency = fromCurrency;
  }

  public String getToCurrency() {
    return toCurrency;
  }

  public void setToCurrency(String toCurrency) {
    this.toCurrency = toCurrency;
  }

  public Double getConversionFactor() {
    return conversionFactor;
  }

  public void setConversionFactor(Double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public Double getConvertedValue() {
    return convertedValue;
  }

  public void setConvertedValue(Double convertedValue) {
    this.convertedValue = convertedValue;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((fromCurrency == null) ? 0 : fromCurrency.hashCode());
    result = prime * result + ((toCurrency == null) ? 0 : toCurrency.hashCode());
    result = prime * result + ((conversionFactor == null) ? 0 : conversionFactor.hashCode());
    result = prime * result + ((convertedValue == null) ? 0 : convertedValue.hashCode());
    result = prime * result + ((environment == null) ? 0 : environment.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cambio other = (Cambio) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (fromCurrency == null) {
      if (other.fromCurrency != null)
        return false;
    } else if (!fromCurrency.equals(other.fromCurrency))
      return false;
    if (toCurrency == null) {
      if (other.toCurrency != null)
        return false;
    } else if (!toCurrency.equals(other.toCurrency))
      return false;
    if (conversionFactor == null) {
      if (other.conversionFactor != null)
        return false;
    } else if (!conversionFactor.equals(other.conversionFactor))
      return false;
    if (convertedValue == null) {
      if (other.convertedValue != null)
        return false;
    } else if (!convertedValue.equals(other.convertedValue))
      return false;
    if (environment == null) {
      if (other.environment != null)
        return false;
    } else if (!environment.equals(other.environment))
      return false;
    return true;
  }

  public Cambio(Long id, String fromCurrency, String toCurrency, 
      Double conversionFactor, 
      Double convertedValue,
      String environment) {
    this.id = id;
    this.fromCurrency = fromCurrency;
    this.toCurrency = toCurrency;
    this.conversionFactor = conversionFactor;
    this.convertedValue = convertedValue;
    this.environment = environment;
  }

  public Cambio() {
  }

}
