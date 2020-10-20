package com.tiago.pontoInteligente.api.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	// Obrigatorio
	@Column(name = "razao_social", nullable = false)
	private String razaoSocial;
	
	// Obrigatorio
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	
	// Obrigatorio
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	// Obrigatorio
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	// 1 empresa possui um ou mais funcionarios
	// LAZY = Ao carregar uma empresa nao irei carregador todos os funcionarios automaticamente
	// CASCADE ALL = Executa qualquer operacao em funcionarios que sao dependentes de uma empresa
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios;
	
	// Construtor
	public Empresa() {}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + ", funcionarios=" + funcionarios + ", getId()=" + getId()
				+ ", getRazaoSocial()=" + getRazaoSocial() + ", getCnpj()=" + getCnpj() + ", getDataCriacao()="
				+ getDataCriacao() + ", getDataAtualizacao()=" + getDataAtualizacao() + ", getFuncionarios()="
				+ getFuncionarios() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
