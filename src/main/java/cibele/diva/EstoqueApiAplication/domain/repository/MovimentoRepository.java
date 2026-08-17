/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.domain.repository;

import cibele.diva.EstoqueApiAplication.domain.model.Movimento;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digma
 */
@Repository
public interface MovimentoRepository {

    List<Movimento> findById(Long id);

    List<Movimento> findByDate(Date data_movto);

    List<Movimento> findByQtd(Long qtd);
}
