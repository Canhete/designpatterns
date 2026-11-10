/* 
*  PagadorPedido
*  Responsável por gerenciar o pagamento
*  de um pedido de acordo com a forma de
*  pagamento escolhida pelo cliente,
*  isto é, através de uma PagamentoStrategy
 */

package canhete.designpatterns.strategy.depois;

import canhete.designpatterns.strategy.depois.strategy.*;

public class PagadorPedido {
    
    // Para guardar estado da estrategia usada,
    // devemos guardar uma referência no contexto
    // para a Strategy
    private PagamentoStrategy estrategia;
    
    // Constructor
    public PagadorPedido() {
        
        // Por padrão, nenhum pagamento está definido
        // forçando ao pagamento ser settado
        // explicitamente com o setter
        estrategia = null; 
        
    }
    
    public void pagar(Pedido pedido) {

        // Se a Strategy não for definida, joga exceção
        if (estrategia == null) {
            throw new IllegalStateException("Estratégia não definida!");
        }

        // Finalmente chama o método da Strategy
        // dependendo da implementação, cada Strategy
        // realiza o método pagar de forma diferente
        estrategia.pagar(pedido.getValorTotal());
        
    }
    
    // Setter da Strategy, crucial para permitir
    // a mudança de Strategy em tempo de execução
    public void setEstrategia(PagamentoStrategy estrategia) {
        this.estrategia = estrategia;
    }
    
}
