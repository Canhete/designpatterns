/* 
*  Pedido
*  Representa um pedido
*  Contém valor total do pedido
 */

package canhete.designpatterns.strategy.depois;

public class Pedido {

    private double valorTotal;

    // Constructor
    public Pedido(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // Getter e Setter
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
