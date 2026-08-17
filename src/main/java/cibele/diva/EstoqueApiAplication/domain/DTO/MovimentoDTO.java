/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.domain.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author digma
 */
public class MovimentoDTO {
    @NotNull
    Long idProduto;
    
    @NotNull
    @Column(name = "qtd")
    Double quantidade;

    public MovimentoDTO() {
    }

    public MovimentoDTO(Long idProduto, Double quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
