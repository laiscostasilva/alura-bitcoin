package br.com.alura.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double preco;

  private String tipo;

  private LocalDate data;

  private String status;

  @Column(name = "user_id")
  private Long userId;

  /**
   * @return Float return the preco
   */
  public Double getPreco() {
    return preco;
  }

  /**
   * @param preco the preco to set
   */
  public void setPreco(Double preco) {
    this.preco = preco;
  }

  /**
   * @return String return the tipo
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * @param tipo the tipo to set
   */
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  /**
   * @return Datetime return the data
   */
  public LocalDate getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(LocalDate data) {
    this.data = data;
  }

  /**
   * @return String return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return String return the status
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * @param status the status to set
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }
  

}