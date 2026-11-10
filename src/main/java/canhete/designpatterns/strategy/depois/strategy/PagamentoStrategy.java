/*
*  PagamentoStrategy
*  Representa a abstração de qualquer pagamento
*  Apresenta o contrato que as Strategies concretas
*  devem implementar
 */

package canhete.designpatterns.strategy.depois.strategy;

public interface PagamentoStrategy {
    
    // Todas strategies concretas devem implementar 
    // o método pagar
    void pagar(double valorTotal);

}
