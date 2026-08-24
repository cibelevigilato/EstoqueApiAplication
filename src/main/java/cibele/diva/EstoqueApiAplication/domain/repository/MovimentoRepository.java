/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.domain.repository;

import cibele.diva.EstoqueApiAplication.domain.model.Movimento;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
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
    List<Movimento> findByQtd(Long qtd);
    
    // Busca movimentações com quantidade menor que o valor informado (ex: saídas com qtd < 0),
    // ordenando da data mais recente para a mais antiga
    List<Movimento> findByQtdLessThanOrderByDataMovtoDesc(Double qtd);
    
    // Busca todas as movimentações realizadas dentro de um intervalo de datas (período)
    List<Movimento> findByDataMovtoBetween(LocalDate dataInicio, LocalDate dataFim);
}
