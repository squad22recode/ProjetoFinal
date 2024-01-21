package com.gestaoCash.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name = "endereco_empresa")
public class AddressCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@OneToOne(mappedBy = "enderecoEmpresa")
//	private Company empresa;
	
	@Column(columnDefinition = "VARCHAR(20)")
	private String bairro;

	@Column(columnDefinition = "VARCHAR(9)")
	private String cep;

	@Column(columnDefinition = "VARCHAR(25)")
	private String estado;

	@Column(columnDefinition = "VARCHAR(25)")
	private String cidade;

	@Column(columnDefinition = "VARCHAR(50)")
	private String endereco;

	@Column(columnDefinition = "VARCHAR(50)")
	private String complemento;

	public AddressCompany() {
	}

	public AddressCompany(Long id, String bairro, String cep, String estado, String cidade, String endereco,
			String complemento) {
		this.id = id;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.endereco = endereco;
		this.complemento = complemento;
	}
	

//	public Company getEmpresa() {
//		return empresa;
//	}
//
//	public void setEmpresa(Company empresa) {
//		this.empresa = empresa;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "AddressCompany [id=" + id + ", bairro=" + bairro + ", cep=" + cep + ", estado=" + estado + ", cidade="
				+ cidade + ", endereco=" + endereco + ", complemento=" + complemento + "]";
	}
	
	
	
}