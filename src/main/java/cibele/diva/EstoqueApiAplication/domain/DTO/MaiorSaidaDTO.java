package cibele.diva.EstoqueApiAplication.domain.DTO;

import java.math.BigDecimal;

public class MaiorSaidaDTO {

    private String nomeProduto;
    private Double quantidadeTotalSaida;
    private Double valorTotalFinanceiroSaidas;

    public MaiorSaidaDTO(String nomeProduto, Double quantidadeTotalSaida, Double valorTotalFinanceiroSaidas) {
        this.nomeProduto = nomeProduto;
        this.quantidadeTotalSaida = quantidadeTotalSaida;
        this.valorTotalFinanceiroSaidas = valorTotalFinanceiroSaidas;
    }

    public MaiorSaidaDTO() {
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getQuantidadeTotalSaida() {
        return quantidadeTotalSaida;
    }

    public void setQuantidadeTotalSaida(Double quantidadeTotalSaida) {
        this.quantidadeTotalSaida = quantidadeTotalSaida;
    }

    public Double getValorTotalFinanceiroSaidas() {
        return valorTotalFinanceiroSaidas;
    }

    public void setValorTotalFinanceiroSaidas(Double valorTotalFinanceiroSaidas) {
        this.valorTotalFinanceiroSaidas = valorTotalFinanceiroSaidas;
    }

}