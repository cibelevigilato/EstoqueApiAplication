package cibele.diva.EstoqueApiAplication.domain.service;

import cibele.diva.EstoqueApiAplication.domain.model.Movimento;
import cibele.diva.EstoqueApiAplication.domain.model.Produto;
import cibele.diva.EstoqueApiAplication.domain.repository.MovimentoRepository;
import cibele.diva.EstoqueApiAplication.domain.repository.ProdutoRepository;
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

    public Movimento atualizaSaldo(Long idProduto, Double qtd) {
        Produto p = produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("produto não encontrado com ID:" + idProduto));

        Movimento movto = new Movimento(p, qtd);
        movimentoRepository.save(movto);
        produto.atualizaSaldo(qtd);
    }

}
