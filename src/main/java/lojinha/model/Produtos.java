package lojinha.model;

public class Produtos {
	
	private String nomeProduto;
	private int quantidade;
	private double valorCompra;
	private double valorVenda;
	
	public Produtos(String nomeProduto, int quantidade, double valorVenda, double valorCompra ) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
    }


    public String getnomeProduto() {
        return nomeProduto;
    }
    public String setnomeProduto() {
        return nomeProduto;
    }

    public int getquantidade() {
        return quantidade;
    }
    public int setquantidade() {
        return quantidade;
    }
    
    public double getvalorVenda() {
        return valorVenda;
    }
    public double setvalorVenda() {
        return valorVenda;
    }
    
    public double getvalorCompra() {
        return valorCompra;
    }
    public double setvalorCompra() {
        return valorCompra;
    }
}
  
