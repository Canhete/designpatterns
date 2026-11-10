/* 
*  Classe Pedido
*  Representa um pedido, nesse exemplo
*  a classe Pedido quem gerencia o pagamento
 */

package canhete.designpatterns.strategy.antes;

public class Pedido {

    private double valorTotal;

    // Constructor
    public Pedido(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // Processador de pagamentos
    // Note que o comportamento e implementação do pagamento
    // varia de acordo com a forma de pagamento e também
    // a cadeia de condicionais usada para representar um comportamento 
    // diferente na mesma função
    public void pagar(String formaPagamento) {

        // Pagamento por PIX
        // Considere RN pix tem desconto de 10%
        if (formaPagamento.equalsIgnoreCase("pix")) {
            double valorComDesconto = getValorTotal() * 0.9;
            System.out.println("Gerando QR Code Pix...\n"
                    + "Valor a ser pago: R$ " + valorComDesconto);
        } 

        // Pagamento por cartão de crédito
        // Considere RN credito tem taxa de 5% por parcelamento
        else if (formaPagamento.equalsIgnoreCase("credito")) {
            double taxaCredito = getValorTotal() * 1.05;
            System.out.println("Processando cobrança no Cartão de Crédito...\n"
                    + "Valor a ser pago: R$ " + taxaCredito);
        } 

        // Pagamento por cartão de debito
        // Considere RN débito tem taxa zero
        else if (formaPagamento.equalsIgnoreCase("debito")) {
            System.out.println("Debitando da conta corrente via Cartão de Débito...\n"
                    + "Valor a ser pago: R$ " + getValorTotal());
        } 

        // Se não for especificado é forma de pagamento invalida
        else {
            System.out.println("Forma de pagamento inválida!");
        }
    }

    // Getter e Setter
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
