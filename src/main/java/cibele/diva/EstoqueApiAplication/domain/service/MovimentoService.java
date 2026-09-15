package cibele.diva.EstoqueApiAplication.domain.service;

import cibele.diva.EstoqueApiAplication.domain.DTO.MaiorSaidaDTO;
import cibele.diva.EstoqueApiAplication.domain.DTO.RelatorioPeriodoDTO;
import cibele.diva.EstoqueApiAplication.domain.model.Movimento;
import cibele.diva.EstoqueApiAplication.domain.model.Produto;
import cibele.diva.EstoqueApiAplication.domain.repository.MovimentoRepository;
import cibele.diva.EstoqueApiAplication.domain.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
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

    public List<RelatorioPeriodoDTO> findRelatorioEstoqueViaJPQL(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return movimentoRepository.findRelatorioEstoqueViaJPQL(dataInicio, dataFim);
    }

    public List<MaiorSaidaDTO> findMaioresSaidasPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return movimentoRepository.findMaioresSaidasPorPeriodo(dataInicio, dataFim);

    }

}
