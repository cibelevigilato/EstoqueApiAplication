/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.domain.DTO;

import cibele.diva.EstoqueApiAplication.domain.model.Categoria;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 *
 * @author digma
 */
public class TotalCategoriaDTO {
    
    @ManyToOne
     @JoinColumn(name="categoria",insertable=false, updatable=false)
     private Categoria categoria;
    
    
    @JoinColumn(name = "qtd")
    private Double quantidade;
    
     @JoinColumn(name = "valor_unitario")
    private BigDecimal valor_unitario;
     
     private BigDecimal valorTotal;

    public TotalCategoriaDTO() {
    }

    public TotalCategoriaDTO(Categoria categoria, Double quantidade, BigDecimal valor_unitario, BigDecimal valorTotal) {
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
        this.valorTotal = valorTotal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(BigDecimal valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
     
     
    
}
