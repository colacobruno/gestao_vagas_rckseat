package br.colaco.gestao_vagas.modules.company.controllers;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.colaco.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.colaco.gestao_vagas.modules.company.useCases.AuthCompanyUseCase;

@RestController
@RequestMapping("auth")
public class AuthCompanyController {
  
@Autowired
private AuthCompanyUseCase authCompanyUseCase;

  @PostMapping("/company")
  public ResponseEntity<String> create(@RequestBody AuthCompanyDTO authCompanyDTO) {
    try{
      var result = this.authCompanyUseCase.execute(authCompanyDTO);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
    
  }
}
