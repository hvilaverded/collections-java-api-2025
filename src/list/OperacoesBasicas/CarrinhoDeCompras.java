package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> carrinho;

    public CarrinhoDeCompras(){
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome,double preco, int quantidade){
            carrinho.add(new Item(nome, preco, quantidade));
    }
    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        for (Item i:carrinho){
            if(i.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(i);
            }
        }
        carrinho.removeAll(itensParaRemover);
    }
    public void calcularValorTotal(){
       double total =0;
        for (Item i:carrinho){
           total= i.getQuantidade() * i.getPreco();
        }
        System.out.println("O valor total é " + total);
    }
    public void exibirItem(){
        System.out.println(this.carrinho);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();


        carrinhoDeCompras.adicionarItem("caneta",5.50,3);
        carrinhoDeCompras.adicionarItem("lapis",4.50,5);
        carrinhoDeCompras.adicionarItem("borracha",6.50,2);
        carrinhoDeCompras.exibirItem();
        carrinhoDeCompras.removerItem("borracha");
        carrinhoDeCompras.exibirItem();
        carrinhoDeCompras.calcularValorTotal();


    }
}

