package cibele.diva.EstoqueApiAplication.domain.service;

import cibele.diva.EstoqueApiAplication.domain.model.Movimento;
import cibele.diva.EstoqueApiAplication.domain.model.Produto;
import cibele.diva.EstoqueApiAplication.domain.repository.MovimentoRepository;
import cibele.diva.EstoqueApiAplication.domain.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class MovimentoService {

    @Autowired
   
     ProdutoRepository produtoRepository;
    
    @Autowired
    MovimentoRepository movimentoRepository;

    
    @Transactional
    public Movimento atualizaSaldo(Long idProduto, Double qtd) {
     Produto produto = produtoRepository.findById(idProduto)
             .orElseThrow(() -> new RuntimeException("produto não encontrado com ID:" + idProduto));
               
     
     Movimento movto = new Movimento(produto, qtd);
       movimentoRepository.save(movto);
        
        produto.atualizaSaldo(qtd);
        produtoRepository.save(produto);
    
        return movto;
    }

}
