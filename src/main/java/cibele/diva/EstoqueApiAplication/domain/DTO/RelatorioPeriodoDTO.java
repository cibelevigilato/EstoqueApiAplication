package cibele.diva.EstoqueApiAplication.domain.DTO;

import java.math.BigDecimal;

public class RelatorioPeriodoDTO {

    private Long id;
    private String nome;
    private BigDecimal valorUnitario;
    private Double totalEntradas;
    private Double totalSaidas;

    // Construtor sem argumentos (exigido pelo JPA/Jackson)
    public RelatorioPeriodoDTO() {
    }

    // Construtor EXATO com os tipos passados na Query do JPQL
    public RelatorioPeriodoDTO(Long id, String nome, BigDecimal valorUnitario, Double totalEntradas, Double totalSaidas) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.totalEntradas = totalEntradas;
        this.totalSaidas = totalSaidas;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getTotalEntradas() {
        return totalEntradas;
    }

    public void setTotalEntradas(Double totalEntradas) {
        this.totalEntradas = totalEntradas;
    }

    public Double getTotalSaidas() {
        return totalSaidas;
    }

    public void setTotalSaidas(Double totalSaidas) {
        this.totalSaidas = totalSaidas;
    }
}
