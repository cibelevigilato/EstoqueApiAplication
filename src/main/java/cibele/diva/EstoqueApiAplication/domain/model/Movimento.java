/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cibele.diva.EstoqueApiAplication.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author digma
 */
@Entity
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    
    @NotNull
    @JoinColumn(name = "id_produto")
    private long id_produto;
        
    private Double qtd;
    
    
     @NotNull
     private  Date dataMovto;

     @ManyToOne
     @JoinColumn(name="id_produto",insertable=false, updatable=false)
     private Produto produto;
     
     public Movimento() {
    }

     public Movimento (Produto produto, Double qtd) {
         this.produto = produto;
         this.qtd = qtd;
         this.dataMovto = new Date();
     }
     
     public Movimento (Long id, long id_produto, Double qtd, Date data_movto) {
         this.id = id;
        // this.id_produto = id_produto;
         this.qtd = qtd;
         this.dataMovto = data_movto;
     }
     
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_produto() {
        return id_produto;
    }

    public void setId_produto(long id_produto) {
        this.id_produto = id_produto;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public Date getData_movto() {
        return dataMovto;
    }

    public void setData_movto(Date data_movto) {
        this.dataMovto = data_movto;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimento other = (Movimento) obj;
        return this.id == other.id;
    }

}