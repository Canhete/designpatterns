/* 
*  Classe Main
*  A classe principal para executar os códigos
 */

package canhete.designpatterns.strategy.antes;

public class Main {

    public static void main(String args[]) {

        // Temos um pedido
        Pedido p1 = new Pedido(1000.00);

        // A classe pedido mesmo, tem o método
        // para pagar e recebe uma String com
        // a forma de pagamento
        // Pagamento por Pix
        p1.pagar("pix");

        // Mais um pedido
        Pedido p2 = new Pedido(1600.00);

        // Pagamento por Credito
        p2.pagar("credito");

        // Outro pedido
        Pedido p3 = new Pedido(2400.00);

        // Nesse caso não tem como o usuário escolher
        // o método de pagamento, a não ser que pague
        // ou seja, escolher o método de pagamento
        // está fechado com o pagamento
        // Pagamento por debito
        p3.pagar("debito");

        // Último pedido
        Pedido p4 = new Pedido(400.00);

        // Se for uma String de um método de pagamento 
        // que não existe, imprime uma mensagem de pagamento
        // inválido, mas não lança uma exceção explícita
        // contendo informações do erro
        p4.pagar("boleto");

    }

}
