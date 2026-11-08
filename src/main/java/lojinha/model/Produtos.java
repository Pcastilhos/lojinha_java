package lojinha.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produtos {

	@Column
	private String nomeProduto;
	@Column
	private int quantidade;
	@Column
	private double valorCompra;
	@Column
	private double valorVenda;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Produtos() {
	}

	public Produtos(String nomeProduto, int quantidade, double valorVenda, double valorCompra ) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
    }


    public Long getid() {
        return id;
    }

    public String getnomeProduto() {
        return nomeProduto;
    }
    public void setnomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getquantidade() {
        return quantidade;
    }
    public void setquantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getvalorVenda() {
        return valorVenda;
    }
    public void setvalorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getvalorCompra() {
        return valorCompra;
    }
    public void setvalorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
}
