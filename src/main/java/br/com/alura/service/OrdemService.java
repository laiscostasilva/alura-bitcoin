package br.com.alura.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {

  @Inject
  OrdemRepository ordemRepository;

  public void inserir(SecurityContext securityContext, Ordem ordem) {
    Optional<Usuario> usuarioOptional =
      Usuario.findByIdOptional(ordem.getUserId());
    Usuario usuario = usuarioOptional.orElseThrow();
    if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())){
      throw new RuntimeException("O usuário logado é diferente do userId");
    }
    ordem.setData(LocalDate.now());
    ordem.setStatus("ENVIADA");
    ordemRepository.persist(ordem);
  }

  public List<Ordem> listar(){
    return ordemRepository.listAll();
  }
    
}