/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.api.controller;

import cibele.diva.EstoqueApiAplication.domain.DTO.TotalCategoriaDTO;
import cibele.diva.EstoqueApiAplication.domain.model.Categoria;
import cibele.diva.EstoqueApiAplication.domain.model.Produto;
import cibele.diva.EstoqueApiAplication.domain.repository.CategoriaRepository;
import cibele.diva.EstoqueApiAplication.domain.service.CategoriaService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    //List<Categoria> listaCategoria;

    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/categoria")
    public List<Categoria> listas() {

        return categoriaRepository.findAll();

    }

    @GetMapping("/categoria/{categoriaID}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long categoriaID) {

        Optional<Categoria> categoria = categoriaRepository.findById(categoriaID);
        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

// ------ Adicionar produto -------------
    @PostMapping("/categoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria adicionar(@Valid @RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }

    // ------ Atualizar produto -------------
    @PutMapping("/categoria/{categoriaID}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long categoriaID,
            @Valid @RequestBody Categoria categoria) {
        return categoriaService.atualizar(categoriaID, categoria)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //------------------------Buscar por valor total--------------------------------
  //  @GetMapping("/relatorio-total")
   // public ResponseEntity<List<TotalCategoriaDTO>> buscarValorTotalPorCategoria() {
      //  List<TotalCategoriaDTO> relatorio = categoriaService.buscarValorTotalPorCategoria();
      //  return ResponseEntity.ok(relatorio);
    }

    
    
    
    
    





