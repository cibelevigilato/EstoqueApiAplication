/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.domain.repository;

import cibele.diva.EstoqueApiAplication.domain.DTO.MaiorSaidaDTO;
import cibele.diva.EstoqueApiAplication.domain.DTO.RelatorioPeriodoDTO;
import cibele.diva.EstoqueApiAplication.domain.model.Movimento;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digma
 */
@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

    // Busca todas as movimentações realizadas em uma data específica
    List<Movimento> findBydataMovto(Date dataMovto);

    // Busca movimentações filtrando pela quantidade exata
    List<Movimento> findByQtd(Double qtd);

    // Busca movimentações com quantidade menor que o valor informado (ex: saídas com qtd < 0),
    // ordenando da data mais recente para a mais antiga
    List<Movimento> findByQtdLessThanOrderByDataMovtoDesc(Double qtd);

    @Query("SELECT new cibele.diva.EstoqueApiAplication.domain.DTO.RelatorioPeriodoDTO("
            + "p.id, p.nome, p.valor_unitario, "
            + "SUM(CASE WHEN m.qtd > 0 THEN m.qtd ELSE 0.0 END), "
            + "SUM(CASE WHEN m.qtd < 0 THEN -m.qtd ELSE 0.0 END)) "
            + "FROM Movimento m JOIN m.produto p "
            + "WHERE (:dataInicio IS NULL OR m.dataMovto >= :dataInicio) "
            + "AND (:dataFim IS NULL OR m.dataMovto <= :dataFim) "
            + "GROUP BY p.id, p.nome, p.valor_unitario "
            + "ORDER BY p.nome")
    List<RelatorioPeriodoDTO> findRelatorioEstoqueViaJPQL(
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim);

    @Query("SELECT new cibele.diva.EstoqueApiAplication.domain.DTO.MaiorSaidaDTO("
            + "p.nome, "
            + "SUM(CASE WHEN m.qtd < 0 THEN -m.qtd ELSE 0.0 END), "
            + "SUM(CASE WHEN m.qtd < 0 THEN (-m.qtd * p.valor_unitario) ELSE 0.0 END)) "
            + "FROM Movimento m JOIN m.produto p "
            + "WHERE (:dataInicio IS NULL OR m.dataMovto >= :dataInicio) "
            + "AND (:dataFim IS NULL OR m.dataMovto <= :dataFim) "
            + "GROUP BY p.id, p.nome, p.valor_unitario "
            + "HAVING SUM(CASE WHEN m.qtd < 0 THEN -m.qtd ELSE 0.0 END) > 0 "
            + "ORDER BY SUM(CASE WHEN m.qtd < 0 THEN -m.qtd ELSE 0.0 END) DESC")
    List<MaiorSaidaDTO> findMaioresSaidasPorPeriodo(
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim);

}
