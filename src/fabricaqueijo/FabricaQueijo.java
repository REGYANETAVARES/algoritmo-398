/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fabricaqueijo;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author REGYANE
 */
public class FabricaQueijo {

    public static void main(String[] args) {
        ArrayList<Produto> estoque = new ArrayList<>();
        double totalVendido = 0;

        // Cadastro de produtos
        while (true) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto (ou -1 para terminar):"));
            if (codigo == -1) {
                break; // Finaliza o cadastro de produtos
            }

            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade disponível do produto:"));
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de venda do produto:"));

            Produto produto = new Produto(codigo, quantidade, preco);
            estoque.add(produto);
        }

        // Venda dos produtos
        while (true) {
            int codigoVenda = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto a ser vendido (ou 0 para encerrar):"));

            if (codigoVenda == 0) {
                break; // Finaliza as vendas
            }

            // Procura o produto pelo código
            Produto produtoVenda = null;
            for (Produto p : estoque) {
                if (p.getCodigo() == codigoVenda) {
                    produtoVenda = p;
                    break;
                }
            }

            // Verifica se o produto foi cadastrado
            if (produtoVenda == null) {
                JOptionPane.showMessageDialog(null, "Produto Não-Cadastrado");
                continue;
            }

            int quantidadeVenda = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser vendida:"));

            // Verifica se a quantidade disponível é suficiente
            if (quantidadeVenda > produtoVenda.getQuantidade()) {
                JOptionPane.showMessageDialog(null, "Estoque Insuficiente");
            } else {
                // Realiza a venda
                produtoVenda.setQuantidade(produtoVenda.getQuantidade() - quantidadeVenda);
                totalVendido += quantidadeVenda * produtoVenda.getPreco();
                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
            }
        }

        // Relatório final
        JOptionPane.showMessageDialog(null, "Total vendido no dia: R$" + totalVendido);

        // Ordenando o estoque em ordem decrescente pela quantidade disponível
        Collections.sort(estoque, new Comparator<Produto>() {
            @Override
            public int compare(Produto p1, Produto p2) {
                return Integer.compare(p2.getQuantidade(), p1.getQuantidade());
            }
        });

        // Exibindo o estoque final
        StringBuilder relatorio = new StringBuilder("\nRelatório do Estoque Final:\n");
        for (Produto p : estoque) {
            relatorio.append(p.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, relatorio.toString());
    }
}
