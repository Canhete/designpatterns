/*
*   Main
*   Roda o código principal
 */

package canhete.designpatterns.composite.depois;

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
        c1.adicionar(placaDeVideo);
        c1.adicionar(processador);

        // Agora vamos embalar o mouse e o
        // teclado juntos
        Caixa c2 = new Caixa("Caixa 2");
        c2.adicionar(mouse);
        c2.adicionar(teclado);

        // O fone de ouvido ficará numa caixa
        // isolada
        Caixa c3 = new Caixa("Caixa 3");
        c3.adicionar(foneOuvido);

        // Agora precisamos empacotar essas caixas
        // uma dentro da outra
        // Vamos empacotar a caixa de mouse teclado
        // junto com o foneOuvido porque são periféricos
        Caixa perifericos = new Caixa("Caixa periféricos");
        perifericos.adicionar(c2);
        perifericos.adicionar(c3);

        // Para proteção extra, vamos colocar mais
        // uma caixa extra para a placa de vídeo
        // e o processador
        Caixa hardwares = new Caixa("Caixa hardwares");
        hardwares.adicionar(c1);

        // Por último, precisamos adicionar essas
        // duas caixas à caixa principal, para
        // finalizar o empacotamento para a entrega
        // ao cliente
        // Criamos uma caixa principal para adicionar
        // Todas as caixas restantes dentro dela
        Caixa caixaPrincipal = new Caixa("Caixa principal");
        caixaPrincipal.adicionar(perifericos);
        caixaPrincipal.adicionar(hardwares);

        // Por último, simplesmente chamamos a função
        // getPreco da caixa principal, ela chama
        // por recursão o preço de outras caixas e
        // produtos dentro
        double total = caixaPrincipal.getPreco();

        // Imprime o preço total
        // e a árvore
        System.out.printf("Valor total da Caixa principal: R$ %.2f\n", total);
        System.out.println(caixaPrincipal.getNome());
        
    }
}
