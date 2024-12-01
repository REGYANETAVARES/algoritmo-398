/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaqueijo;

/**
 *
 * @author REGYANE
 */
public class Produto {
    
private int codigo;
    private int quantidade;
    private double preco;

    public Produto(int codigo, int quantidade, double preco) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String toString() {
        return "Codigo: " + codigo + " | Quantidade: " + quantidade + " | Preço: " + preco;
    }
}
