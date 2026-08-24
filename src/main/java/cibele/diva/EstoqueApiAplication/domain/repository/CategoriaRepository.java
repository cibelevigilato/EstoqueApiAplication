/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.domain.repository;

import cibele.diva.EstoqueApiAplication.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author digma
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
