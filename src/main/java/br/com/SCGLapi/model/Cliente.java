package br.com.SCGLapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLI_ID")
	private Integer clienteId;
	
	@NotNull
	@Size(min = 10, max = 250)
	@Column(name = "CLI_RAZAO_SOCIAL")
	private String clienteRazaoSocial;
	
	@NotNull
	@Size(min = 10, max = 250)
	@Column(name = "CLI_NOME_FANTASIA")
	private String clienteNomeFantasia;
	
	@NotNull
	@Column(name = "CLI_INSCRICAO_ESTADUAL")
	private Integer clienteInscricaoEstadual;
	
	@NotNull
	@Size(min = 14, max = 14)
	@Column(name = "CLI_CNPJ")
	private String clienteCnpj;
	
	@NotNull
	@Column(name = "CLI_EMAIL")
	private String clienteEmail;
	
	@NotNull
	@Column(name = "CLI_TELEFONE")
	private String clienteTelefone;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CLI_DT_INCLUSAO")
	private Date clienteDataInclusao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CLI_DT_EXCLUSAO")
	private Date clienteDataExclusao;
	
	@NotNull
	@Column(name = "CLI_CIDADE")
	private String clienteCidade;
	
	@NotNull
	@Column(name = "CLI_CEP")
	private Integer clienteCep;
	
	@NotNull
	@Column(name = "CLI_LOGRADOURO")
	private String clienteLogradouro;
	
	@NotNull
	@Column(name = "CLI_COMPLEMENTO")
	private String clienteComplementoEndereco;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "CLI_STATUS")
	private Status clienteStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "CLI_PERFIL")
	private Perfil clientePerfil;

	
	//Getters e Setters
	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteRazaoSocial() {
		return clienteRazaoSocial;
	}

	public void setClienteRazaoSocial(String clienteRazaoSocial) {
		this.clienteRazaoSocial = clienteRazaoSocial;
	}

	public String getClienteNomeFantasia() {
		return clienteNomeFantasia;
	}

	public void setClienteNomeFantasia(String clienteNomeFantasia) {
		this.clienteNomeFantasia = clienteNomeFantasia;
	}

	public Integer getClienteInscricaoEstadual() {
		return clienteInscricaoEstadual;
	}

	public void setClienteInscricaoEstadual(Integer clienteInscricaoEstadual) {
		this.clienteInscricaoEstadual = clienteInscricaoEstadual;
	}

	public String getClienteCnpj() {
		return clienteCnpj;
	}

	public void setClienteCnpj(String clienteCnpj) {
		this.clienteCnpj = clienteCnpj;
	}

	public String getClienteEmail() {
		return clienteEmail;
	}

	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}

	public String getClienteTelefone() {
		return clienteTelefone;
	}

	public void setClienteTelefone(String clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}

	public Date getClienteDataInclusao() {
		return clienteDataInclusao;
	}

	public void setClienteDataInclusao(Date clienteDataInclusao) {
		this.clienteDataInclusao = clienteDataInclusao;
	}

	public Date getClienteDataExclusao() {
		return clienteDataExclusao;
	}

	public void setClienteDataExclusao(Date clienteDataExclusao) {
		this.clienteDataExclusao = clienteDataExclusao;
	}

	public String getClienteCidade() {
		return clienteCidade;
	}

	public void setClienteCidade(String clienteCidade) {
		this.clienteCidade = clienteCidade;
	}

	public Integer getClienteCep() {
		return clienteCep;
	}

	public void setClienteCep(Integer clienteCep) {
		this.clienteCep = clienteCep;
	}

	public String getClienteLogradouro() {
		return clienteLogradouro;
	}

	public void setClienteLogradouro(String clienteLogradouro) {
		this.clienteLogradouro = clienteLogradouro;
	}

	public String getClienteComplementoEndereco() {
		return clienteComplementoEndereco;
	}

	public void setClienteComplementoEndereco(String clienteComplementoEndereco) {
		this.clienteComplementoEndereco = clienteComplementoEndereco;
	}

	public Status getClienteStatus() {
		return clienteStatus;
	}

	public void setClienteStatus(Status clienteStatus) {
		this.clienteStatus = clienteStatus;
	}

	public Perfil getClientePerfil() {
		return clientePerfil;
	}

	public void setClientePerfil(Perfil clientePerfil) {
		this.clientePerfil = clientePerfil;
	}

	//ToString
	@Override
	public String toString() {
		return "Cliente [clienteId=" + clienteId + ", clienteRazaoSocial=" + clienteRazaoSocial
				+ ", clienteNomeFantasia=" + clienteNomeFantasia + ", clienteInscricaoEstadual="
				+ clienteInscricaoEstadual + ", clienteCnpj=" + clienteCnpj + ", clienteEmail=" + clienteEmail
				+ ", clienteTelefone=" + clienteTelefone + ", clienteDataInclusao=" + clienteDataInclusao
				+ ", clienteDataExclusao=" + clienteDataExclusao + ", clienteCidade=" + clienteCidade + ", clienteCep="
				+ clienteCep + ", clienteLogradouro=" + clienteLogradouro + ", clienteComplementoEndereco="
				+ clienteComplementoEndereco + ", clienteStatus=" + clienteStatus + ", clientePerfil=" + clientePerfil
				+ "]";
	}
	
}
