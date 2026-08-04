/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.api.controller;

import cibele.diva.EstoqueApiAplication.domain.model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */

@RestController
public class ProdutoController {
    
    List<Produto>listaProduto;
    
    @GetMapping("/produto")
    public List<Produto> listas(){
    
    listaProduto = new ArrayList<Produto>();
    listaProduto.add(new Produto(1, "Mouse", 1, 90));
    
    return listaProduto;
    
    }
    
    
    }
      
    

