/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.api.controller;

import cibele.diva.EstoqueApiAplication.domain.model.Categoria;
import cibele.diva.EstoqueApiAplication.domain.model.Produto;
import cibele.diva.EstoqueApiAplication.domain.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

//--- Listar todos os produtos ---------
    @GetMapping("/Produto")
    public List<Produto> listas() {

        return produtoRepository.findAll();
    } 
   
   //--- Listar todos os produtos por ID --------- 
    @GetMapping("/Produto/{produtoID}")
    public ResponseEntity<Produto> buscar(@PathVariable Long produtoID){

        Optional<Produto> produto = produtoRepository.findById(produtoID);
    if(produto.isPresent()){
        return ResponseEntity.ok(produto.get());
    }else {
        return ResponseEntity.notFound().build();
    }
    
    }
    
    //--- add productos ---------
    
    @PostMapping("/Produto")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar (@RequestBody Produto produto){
    
    return produtoRepository.save(produto);
    }
    }

