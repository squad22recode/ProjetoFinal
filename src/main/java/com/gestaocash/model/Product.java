package com.gestaoCash.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown
= true)
@Entity
@Table(name = "produto")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	private String nome;

	@Column(nullable = false, columnDefinition = "decimal(10,2)")
	private double custo;

	@Column(length = 255)
	private String descricao;

	@JoinColumn(name = "empresa_id", foreignKey = @ForeignKey(name = "FKProduct"))
	@ManyToOne
	private Company empresa;

	private int quantidade;
	
	private String img;
	
//
//	public Sale getVenda() {
//		return venda;
//	}
//
//	public void setVenda(Sale venda) {
//		this.venda = venda;
//	}

	public Company getEmpresa() {
		return empresa;
	}

	
	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public void setEmpresa(Company empresa) {
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nome=" + nome + ", custo=" + custo + ", descricao=" + descricao + ", empresa="
				+ empresa + ", quantidade=" + quantidade + "]";
	}

}
