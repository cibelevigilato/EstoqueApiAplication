package cibele.diva.EstoqueApiAplication.api.controller;

import cibele.diva.EstoqueApiAplication.domain.DTO.MovimentoDTO;
import cibele.diva.EstoqueApiAplication.domain.model.Movimento;
import cibele.diva.EstoqueApiAplication.domain.repository.MovimentoRepository;
import cibele.diva.EstoqueApiAplication.domain.service.MovimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */


@RestController
@RequestMapping("/movto")
public class MovimentoController {
@Autowired
private MovimentoService movtoService;

@Autowired
private MovimentoRepository movtoRepository;

@PostMapping 
public ResponseEntity<Movimento> atualizaSaldo
        (@RequestBody @Valid MovimentoDTO movtoDTO){
            Movimento newMovimento = movtoService.atualizaSaldo(movtoDTO.getIdProduto(), movtoDTO.getQuantidade());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(newMovimento);
        }
}
