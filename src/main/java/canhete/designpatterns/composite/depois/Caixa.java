/*
*  Caixa
*  Representa uma caixa dentro do sistema
*  Uma caixa pode guardar produtos ou
*  outras caixas dentro dela
*  No contexto do composite, a Caixa é
*  um Composite, porque ela possui filhos
 */

package canhete.designpatterns.composite.depois;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Caixa implements PedidoComponent {

    // Nome para caixa para identificação
    private String nome;
    
    // Guardamos uma constante com o valor unitário
    // da caixa, Suponha custo = R$ 4,00
    private static final double CUSTO_CAIXA = 4.0;

    // Composição
    // Uma lista para elementos pedidos
    private List<PedidoComponent> itens = new ArrayList<>();

    // Construtor
    public Caixa(String nome) {
        this.nome = nome;
    }
    
    // Agora a caixa adiciona elementos genéricos
    // sem se preocupar se é outra caixa ou
    // se é um produto
    public void adicionar(PedidoComponent item) {
        this.itens.add(item);
    }
    
    // Remoção
    public void remover(PedidoComponent item) {
        this.itens.remove(item);
    }
    
    // Busca por filho por index
    public PedidoComponent getItem(int index) {
        return this.itens.get(index);
    }

    // Retorna o nome da caixa e todos seus componentes
    @Override
    public String getNome() {
        return getNome(0);
    }
    
    // Função interna com parâmetro profundidade
    // usado para exibir profundidade da árvore
    // na String
    private String getNome(int profundidade) {
        
        // String builder
        StringBuilder sb = new StringBuilder();
        
        // Tabulação
        sb.append("    ".repeat(profundidade))
          .append(this.nome)
          .append(": ");
        
        StringJoiner sj = new StringJoiner(", ");
        
        // Adiciona cada item separado por vírgula
        for (PedidoComponent item : itens) {
            if (item instanceof Caixa caixa) {
                // Casting explícito
                sb.append("\n")
                  .append(caixa.getNome(profundidade + 1));
            }
            else {
                sj.add(item.getNome());
            }
        }
        
        // Adiciona ao StringBuilder
        sb.append(sj);
        
        // Retorna a String de um nível
        return sb.toString();
        
    }
    
    // Calcula o preço total da caixa
    @Override
    public double getPreco() {
        
        // Considerando a regra de negócio
        // cada caixa tem custo fixo
        double total = CUSTO_CAIXA;

        // Trata produtos e subcaixas exatamente da mesma forma
        // Chamada recursiva
        for (PedidoComponent item : itens) {
            total += item.getPreco();
        }
        
        return total;
        
    }
    
}
