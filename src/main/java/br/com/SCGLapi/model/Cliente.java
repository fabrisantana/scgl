package br.com.SCGLapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Size(min = 4, max = 250)
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
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CLI_DT_ATUALIZACAO")
	private Date clienteDataAtualizacao;
	
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
	@Column(name = "CLI_STATUS")
	private String clienteStatus;
	
	
	
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

	public Date getClienteDataAtualizacao() {
		return clienteDataAtualizacao;
	}

	public void setClienteDataAtualizacao(Date clienteDataAtualizacao) {
		this.clienteDataAtualizacao = clienteDataAtualizacao;
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

	public String getClienteStatus() {
		return clienteStatus;
	}

	public void setClienteStatus(String clienteStatus) {
		this.clienteStatus = clienteStatus;
	}

	
	@Override
	public String toString() {
		return "Cliente [clienteId=" + clienteId + ", clienteRazaoSocial=" + clienteRazaoSocial
				+ ", clienteNomeFantasia=" + clienteNomeFantasia + ", clienteInscricaoEstadual="
				+ clienteInscricaoEstadual + ", clienteCnpj=" + clienteCnpj + ", clienteEmail=" + clienteEmail
				+ ", clienteTelefone=" + clienteTelefone + ", clienteDataAtualizacao=" + clienteDataAtualizacao
				+ ", clienteDataExclusao=" + clienteDataExclusao + ", clienteCidade=" + clienteCidade + ", clienteCep="
				+ clienteCep + ", clienteLogradouro=" + clienteLogradouro + ", clienteComplementoEndereco="
				+ clienteComplementoEndereco + ", clienteStatus=" + clienteStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clienteCep == null) ? 0 : clienteCep.hashCode());
		result = prime * result + ((clienteCidade == null) ? 0 : clienteCidade.hashCode());
		result = prime * result + ((clienteCnpj == null) ? 0 : clienteCnpj.hashCode());
		result = prime * result + ((clienteComplementoEndereco == null) ? 0 : clienteComplementoEndereco.hashCode());
		result = prime * result + ((clienteDataAtualizacao == null) ? 0 : clienteDataAtualizacao.hashCode());
		result = prime * result + ((clienteDataExclusao == null) ? 0 : clienteDataExclusao.hashCode());
		result = prime * result + ((clienteEmail == null) ? 0 : clienteEmail.hashCode());
		result = prime * result + ((clienteId == null) ? 0 : clienteId.hashCode());
		result = prime * result + ((clienteInscricaoEstadual == null) ? 0 : clienteInscricaoEstadual.hashCode());
		result = prime * result + ((clienteLogradouro == null) ? 0 : clienteLogradouro.hashCode());
		result = prime * result + ((clienteNomeFantasia == null) ? 0 : clienteNomeFantasia.hashCode());
		result = prime * result + ((clienteRazaoSocial == null) ? 0 : clienteRazaoSocial.hashCode());
		result = prime * result + ((clienteStatus == null) ? 0 : clienteStatus.hashCode());
		result = prime * result + ((clienteTelefone == null) ? 0 : clienteTelefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (clienteCep == null) {
			if (other.clienteCep != null)
				return false;
		} else if (!clienteCep.equals(other.clienteCep))
			return false;
		if (clienteCidade == null) {
			if (other.clienteCidade != null)
				return false;
		} else if (!clienteCidade.equals(other.clienteCidade))
			return false;
		if (clienteCnpj == null) {
			if (other.clienteCnpj != null)
				return false;
		} else if (!clienteCnpj.equals(other.clienteCnpj))
			return false;
		if (clienteComplementoEndereco == null) {
			if (other.clienteComplementoEndereco != null)
				return false;
		} else if (!clienteComplementoEndereco.equals(other.clienteComplementoEndereco))
			return false;
		if (clienteDataAtualizacao == null) {
			if (other.clienteDataAtualizacao != null)
				return false;
		} else if (!clienteDataAtualizacao.equals(other.clienteDataAtualizacao))
			return false;
		if (clienteDataExclusao == null) {
			if (other.clienteDataExclusao != null)
				return false;
		} else if (!clienteDataExclusao.equals(other.clienteDataExclusao))
			return false;
		if (clienteEmail == null) {
			if (other.clienteEmail != null)
				return false;
		} else if (!clienteEmail.equals(other.clienteEmail))
			return false;
		if (clienteId == null) {
			if (other.clienteId != null)
				return false;
		} else if (!clienteId.equals(other.clienteId))
			return false;
		if (clienteInscricaoEstadual == null) {
			if (other.clienteInscricaoEstadual != null)
				return false;
		} else if (!clienteInscricaoEstadual.equals(other.clienteInscricaoEstadual))
			return false;
		if (clienteLogradouro == null) {
			if (other.clienteLogradouro != null)
				return false;
		} else if (!clienteLogradouro.equals(other.clienteLogradouro))
			return false;
		if (clienteNomeFantasia == null) {
			if (other.clienteNomeFantasia != null)
				return false;
		} else if (!clienteNomeFantasia.equals(other.clienteNomeFantasia))
			return false;
		if (clienteRazaoSocial == null) {
			if (other.clienteRazaoSocial != null)
				return false;
		} else if (!clienteRazaoSocial.equals(other.clienteRazaoSocial))
			return false;
		if (clienteStatus == null) {
			if (other.clienteStatus != null)
				return false;
		} else if (!clienteStatus.equals(other.clienteStatus))
			return false;
		if (clienteTelefone == null) {
			if (other.clienteTelefone != null)
				return false;
		} else if (!clienteTelefone.equals(other.clienteTelefone))
			return false;
		return true;
	}
	
}
