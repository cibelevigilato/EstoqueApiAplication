/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.domain.service;

import cibele.diva.EstoqueApiAplication.domain.model.Categoria;
import cibele.diva.EstoqueApiAplication.domain.model.Produto;
import cibele.diva.EstoqueApiAplication.domain.repository.CategoriaRepository;
import cibele.diva.EstoqueApiAplication.domain.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */

@Service
public class CategoriaService {
     private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Categoria salvar(Categoria categoria) {
        // Exemplo de regra de negócio futura:
        // if (produtoRepository.existsByNome(produto.getNome())) { throw Exception... }
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public Optional<Categoria> atualizar(Long categoriaID, Categoria CategoriaComNovosDados) {
        return categoriaRepository.findById(categoriaID)
                .map(categoriaExistente -> {
                    // Copia os dados recebidos para o produto buscado no banco, ignorando a chave primária
                    BeanUtils.copyProperties(CategoriaComNovosDados, categoriaExistente, "id");
                    return categoriaRepository.save(categoriaExistente);
                });
    }
}

