package br.com.alura.model;

import java.time.LocalDate;

/**
 *
 * @author laiscosta
 */
public class Bitcoin {

  private Long id;
  private Double preco;
  private String tipo;
  private LocalDate data;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getPreco() {
    return this.preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public LocalDate getData() {
    return this.data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

}
