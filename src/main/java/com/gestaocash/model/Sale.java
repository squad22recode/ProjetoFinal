package com.gestaoCash.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="venda")
@Entity
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_venda")
	private long id;
	
	@JoinColumn(name="cliente_id", foreignKey = @ForeignKey(name = "FKCLI_ID"))
	@ManyToOne
	private Client cliente;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "produto_venda", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "id_venda"))
//	private List<Product> produtos = new ArrayList<>();
	
	@Column(columnDefinition = "json")
	private String produtos;
	
	
	private double valorTotal;
	private int desconto;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getProdutos() {
		return produtos;
	}
	public void setProdutos(String produtos) {
		this.produtos = produtos;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getDesconto() {
		return desconto;
	}
	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	@Override
	public String toString() {
		return "Sale [id=" + id + ", produtos=" + produtos + ", valorTotal=" + valorTotal
				+ ", desconto=" + desconto + "]";
	}
	public Client getCliente() {
		return cliente;
	}
	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}
	
//	
//	private int quantidade;
//	private double valor;
//	
//	@OneToMany(mappedBy = "venda", orphanRemoval = true, cascade = CascadeType.PERSIST)
//	private List<Product> produto = new ArrayList<Product>();
//	
//	@JoinColumn(name="cliente_id", foreignKey = @ForeignKey(name = "FKCLI_ID"))
//	@ManyToOne
//	private Client cliente;
//	
//	@DateTimeFormat(iso = ISO.DATE)
//	private LocalDate data;
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public int getQuantidade() {
//		return quantidade;
//	}
//
//	public void setQuantidade(int quantidade) {
//		this.quantidade = quantidade;
//	}
//
//	public double getValor() {
//		return valor;
//	}
//
//	public void setValor(double valor) {
//		this.valor = valor;
//	}
//
//	public List<Product> getProduto() {
//		return produto;
//	}
//
//	public void setProduto(List<Product> produto) {
//		this.produto = produto;
//	}
//
//	public Client getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Client cliente) {
//		this.cliente = cliente;
//	}
//
//	public LocalDate getData() {
//		return data;
//	}
//
//	public void setData(LocalDate data) {
//		this.data = data;
//	}
//	
	
}
