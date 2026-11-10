/*
*  PagamentoDebitoStrategy
*  Representa implementação para Cartão de Débito
 */

package canhete.designpatterns.strategy.depois.strategy;

public class PagamentoDebitoStrategy implements PagamentoStrategy {

    @Override
    public void pagar(double valorTotal) {
        System.out.println("Debitando da conta corrente via Cartão de Débito...\n"
                + "Valor a ser pago: R$ " + valorTotal);
    }

}
