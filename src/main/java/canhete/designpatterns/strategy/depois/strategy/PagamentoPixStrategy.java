/*
*  PagamentoPixStrategy
*  Representa implementação para Pix
 */

package canhete.designpatterns.strategy.depois.strategy;

public class PagamentoPixStrategy implements PagamentoStrategy {

    @Override
    public void pagar(double valorTotal) {
        double valorComDesconto = valorTotal * 0.9;
        System.out.println("Gerando QR Code Pix...\n"
                + "Valor a ser pago: R$ " + valorComDesconto);
    }
    
}
