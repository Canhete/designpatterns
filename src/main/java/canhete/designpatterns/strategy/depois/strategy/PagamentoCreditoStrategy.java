/*
*  PagamentoCreditoStrategy
*  Representa implementação para Cartão de Crédito
 */

package canhete.designpatterns.strategy.depois.strategy;

public class PagamentoCreditoStrategy implements PagamentoStrategy {

    @Override
    public void pagar(double valorTotal) {
        double taxaCredito = valorTotal * 1.05;
        System.out.println("Processando cobrança no Cartão de Crédito...\n"
                + "Valor a ser pago: R$ " + taxaCredito);
    }
    
}
