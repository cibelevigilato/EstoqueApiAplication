/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.api.controller;

import cibele.diva.EstoqueApiAplication.domain.model.Categoria;
import cibele.diva.EstoqueApiAplication.domain.model.Produto;
import cibele.diva.EstoqueApiAplication.domain.repository.CategoriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

@PutMapping("/categoria/{categoriaID}")
public ResponseEntity<Categoria> atualizar(@Valid @PathVariable Long categoriaID,@RequestBody Categoria categoria) {
        
    //verifica se o produto ja existe 
    
    if (!categoriaRepository.existsById(categoriaID)) {
        return ResponseEntity.notFound().build();
        
    }
   categoria.setId(categoriaID);
   categoria = categoriaRepository.save(categoria);
   return ResponseEntity.ok(categoria);
    




}
}
