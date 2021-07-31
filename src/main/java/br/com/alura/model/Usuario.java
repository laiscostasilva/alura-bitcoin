package br.com.alura.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@Entity
@UserDefinition
public class Usuario extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private String cpf;

  @Username
  private String username;

  @Password
  private String password;

  @Roles
  private String role;

  /**
   * @return String return the nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * @param nome the nome to set
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * @return String return the cpf
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * @param cpf the cpf to set
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * @return String return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return String return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return String return the role
   */
  public String getRole() {
      return role;
  }

  /**
   * @param role the role to set
   */
  public void setRole(String role) {
      this.role = role;
  }

  public static void adicionar(Usuario usuario){
    usuario.password = BcryptUtil.bcryptHash(usuario.password);
    usuario.role = validarUsername(usuario.username);
    usuario.persist();
  }


  private static String validarUsername(String username){
    if(username.equals("alura")){
      return "admin";
    } return "user";
  }

}