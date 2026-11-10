/*
*  Caixa
*  Representa uma caixa dentro do sistema
*  Uma caixa pode guardar produtos ou
*  outras caixas dentro dela
 */
package canhete.designpatterns.composite.antes;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Caixa {
    
    // Nome da caixa
    private String nome;
    
    // Há duas listas separadas para tipos de objetos diferentes
    private List<Produto> produtos = new ArrayList<>();
    private List<Caixa> subcaixas = new ArrayList<>();
    
    // Constructor
    public Caixa(String nome) {
        this.nome = nome;
    }
    
    // Adiciona exclusivamente produtos
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }
    
    // Remove um produto
    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }
    
    // Busca um produto
    public Produto getProduto(int index) {
        return this.produtos.get(index);
    }
    
    // Adiciona exclusivamente caixas dentro da caixa
    public void adicionarSubCaixa(Caixa caixa) {
        this.subcaixas.add(caixa);
    }
    
    // Remove uma subcaixa
    public void removerSubCaixa(Caixa caixa) {
        this.subcaixas.remove(caixa);
    }
    
    // Busca uma subcaixa
    public Caixa getSubCaixa(int index) {
        return this.subcaixas.get(index);
    }
    
    // Retorna o nome da caixa e tudo que está dentro
    public String getNome() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome).append(": ");
        
        StringJoiner sj = new StringJoiner(", ");
        
        for (Caixa c : subcaixas) {
            sb.append("\n").append(c.getNome());
        }
        
        for (Produto p : produtos) {
            sj.add(p.getNome());
        }
        
        sb.append(sj);
        
        return sb.toString();
        
    }
    
    // Calcula o preço total da caixa
    public double getPrecoTotal() {
        
        // Considerando a regra de negócio
        // cada caixa tem custo fixo
        // Suponha custo = R$ 4,00
        double total = 4.00;
        
        // Devemos primeiro somar o preço dos produtos
        for (Produto p : produtos) {
            total += p.getPreco();
        }
        
        // Depois devemos pegar o preço de cada subcaixa
        for (Caixa c : subcaixas) {
            total += c.getPrecoTotal();
        }
        
        // Finalmente retornamos o valor de tudo
        return total;
        
    }
    
    // Setter
    public void setNome(String nome) {
        this.nome = nome;
    }
}
