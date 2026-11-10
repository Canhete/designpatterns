/* 
*  Classe Main
*  A classe principal para executar os códigos
 */

package canhete.designpatterns.strategy.depois;

import canhete.designpatterns.strategy.depois.strategy.*;

public class Main {

    public static void main(String args[]) {

        // Novo pedido, precisa ser pago
        Pedido p1 = new Pedido(1000.00);

        // Cria o contexto, aquele que usará a Strategy
        PagadorPedido pagadorPedido = new PagadorPedido();
        
        // Antes de pagar o pedido, o contexto deve 
        // receber a estrategia para realizar o método
        // pagar
        // Podemos criar variáveis para guardar a referência
        // de cada Strategy concreta, para evitar múltiplas
        // instanciações
        PagamentoStrategy pix = new PagamentoPixStrategy();
        PagamentoStrategy credito = new PagamentoCreditoStrategy();
        PagamentoStrategy debito = new PagamentoDebitoStrategy();

        // Nesse caso definimos a estrategia Pix
        pagadorPedido.setEstrategia(pix);

        // Pagamento por pix
        pagadorPedido.pagar(p1);

        // Recebemos outro pedido, também precisa ser pago
        Pedido p2 = new Pedido(1600.00);

        // Se não mudarmos o método de pagamento
        // o contexto guardou a referência do último
        // método de pagamento, portanto, o pagamento também
        // será por Pix
        // Vamos mudar a Strategy em tempo de execução
        pagadorPedido.setEstrategia(credito);

        // Pagamento por Credito
        pagadorPedido.pagar(p2);

        // Temos mais um pedido
        Pedido p3 = new Pedido(2400.00);

        // Vamos supor que o cliente escolheu Pix
        // mas então decidiu de mudar a forma de pagamento
        // para débito. 
        // Com Strategy isso é possível em tempo de execução
        // antes mesmo do pagamento ser executado
        pagadorPedido.setEstrategia(pix);
        pagadorPedido.setEstrategia(debito);

        // Pagamento por Débito
        pagadorPedido.pagar(p3);

        // Último pedido
        Pedido p4 = new Pedido(400.00);

        // Se colocarmos uma Strategy que não existe
        // recebemos erro direto na compilação
        //
        // pagadorPedido.setEstrategia(new PagamentoBoletoStrategy());
        //
        // Vamos supor que por algum motivo
        // a forma de pagamento é nula
        pagadorPedido.setEstrategia(null);

        // Essa linha joga exceção, porque o método
        // pagar lança exceção se a Strategy não for
        // definida
        pagadorPedido.pagar(p4);

    }

}
