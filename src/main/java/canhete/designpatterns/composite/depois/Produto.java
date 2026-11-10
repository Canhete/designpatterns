/*
*  Produto
*  Representa um produto específico
*  Contém nome e preço
*  No contexto do composite, o Produto é
*  uma Leaf (Folha), porque não possui
*  filhos
 */
package canhete.designpatterns.composite.depois;

public class Produto implements PedidoComponent {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Os getters são sobrescritos
    // por implementarem métodos
    // da interface
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public double getPreco() {
        return preco;
    }
    
    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
