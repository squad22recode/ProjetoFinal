package com.gestaoCash.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name="empresa")
@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_empresa")
	public long idEmpresa;
	
	@Column(name="nome_empresa", length = 50)
	public String nomeEmpresa;
	
	@Column(name="cnpj", length = 18)
	public String cnpj;
	
	@Column(name="razao_social", length = 50)
	public String razaoSocial;
	
	@OneToOne(mappedBy = "empresa")
	private Users usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private AddressCompany enderecoEmpresa;
	

	public AddressCompany getEnderecoEmpresa() {
		return enderecoEmpresa;
	}

	public void setEnderecoEmpresa(AddressCompany enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}

	public Users getUsuario() {
		return usuario;
	}

	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}

	public long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String toString() {
		return "Company [idEmpresa=" + idEmpresa + ", nomeEmpresa=" + nomeEmpresa + ", cnpj=" + cnpj + ", razaoSocial="
				+ razaoSocial + ", usuario=" + usuario + ", enderecoEmpresa=" + enderecoEmpresa.toString() + "]";
	}
	
	
		
}
