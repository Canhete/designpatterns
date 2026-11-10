/*
*   Main
*   Roda o código principal
 */

package canhete.designpatterns.composite.antes;

public class Main {

    public static void main(String args[]) {

        // Vamos supor que estamos empacotando
        // produtos para um Cliente
        // Vamos criar alguns produtos para 
        // adicionarmos às caixas
        Produto foneOuvido = new Produto("Fone de ouvido", 119.21);
        Produto mouse = new Produto("Mouse", 75.49);
        Produto teclado = new Produto("Teclado", 110.25);
        Produto placaDeVideo = new Produto("Placa de vídeo", 1691.44);
        Produto processador = new Produto("Processador", 1132.03);

        // Colocamos a placa de vídeo e
        // o processador na mesma caixa
        Caixa c1 = new Caixa("Caixa 1");
        c1.adicionarProduto(placaDeVideo);
        c1.adicionarProduto(processador);

        // Agora vamos embalar o mouse e o
        // teclado juntos
        Caixa c2 = new Caixa("Caixa 2");
        c2.adicionarProduto(mouse);
        c2.adicionarProduto(teclado);

        // O fone de ouvido ficará numa caixa
        // isolada
        Caixa c3 = new Caixa("Caixa 3");
        c3.adicionarProduto(foneOuvido);

        // Agora precisamos empacotar essas caixas
        // uma dentro da outra
        // Vamos empacotar a caixa de mouse teclado
        // junto com o foneOuvido porque são periféricos
        Caixa perifericos = new Caixa("Caixa periféricos");
        perifericos.adicionarSubCaixa(c2);
        perifericos.adicionarSubCaixa(c3);

        // Para proteção extra, vamos colocar mais
        // uma caixa extra para a placa de vídeo
        // e o processador
        Caixa hardwares = new Caixa("Caixa hardwares");
        hardwares.adicionarSubCaixa(c1);

        // Por último, precisamos adicionar essas
        // duas caixas à caixa principal, para
        // finalizar o empacotamento para a entrega
        // ao cliente
        // Criamos uma caixa principal para adicionar
        // Todas as caixas restantes dentro dela
        Caixa caixaPrincipal = new Caixa("Caixa principal");
        caixaPrincipal.adicionarSubCaixa(perifericos);
        caixaPrincipal.adicionarSubCaixa(hardwares);

        // Por último, calculamos o preço total
        // dos produtos dentro das caixas e de
        // cada caixa para saber o valor da
        // caixa principal
        double total = caixaPrincipal.getPrecoTotal();

        // Imprime o valor da caixa
        // e o nome dos itens
        // perceba que não há profundidade
        System.out.printf("Valor total da Caixa principal: R$ %.2f\n", total);
        System.out.println(caixaPrincipal.getNome());
        
    }
}
