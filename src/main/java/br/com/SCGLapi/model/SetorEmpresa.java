package br.com.SCGLapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "setor_empresa")
public class SetorEmpresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SET_ID")
	private Integer idSetorEmpresa;
	
	@NotNull
	@Column(name = "SET_NOME")
	private String nomeSetorEmpresa;
	
	@NotNull
	@Column(name = "SET_SIGLA")
	private String siglaSetorEmpresa;
	
	
	@NotNull
	@Column(name = "SET_CLI_ID")
	private Integer idCliente;


	public Integer getIdSetorEmpresa() {
		return idSetorEmpresa;
	}


	public void setIdSetorEmpresa(Integer idSetorEmpresa) {
		this.idSetorEmpresa = idSetorEmpresa;
	}


	public String getNomeSetorEmpresa() {
		return nomeSetorEmpresa;
	}


	public void setNomeSetorEmpresa(String nomeSetorEmpresa) {
		this.nomeSetorEmpresa = nomeSetorEmpresa;
	}


	public String getSiglaSetorEmpresa() {
		return siglaSetorEmpresa;
	}


	public void setSiglaSetorEmpresa(String siglaSetorEmpresa) {
		this.siglaSetorEmpresa = siglaSetorEmpresa;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	@Override
	public String toString() {
		return "SetorEmpresa [idSetorEmpresa=" + idSetorEmpresa + ", nomeSetorEmpresa=" + nomeSetorEmpresa
				+ ", siglaSetorEmpresa=" + siglaSetorEmpresa + ", idCliente=" + idCliente + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idSetorEmpresa == null) ? 0 : idSetorEmpresa.hashCode());
		result = prime * result + ((nomeSetorEmpresa == null) ? 0 : nomeSetorEmpresa.hashCode());
		result = prime * result + ((siglaSetorEmpresa == null) ? 0 : siglaSetorEmpresa.hashCode());
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
		SetorEmpresa other = (SetorEmpresa) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (idSetorEmpresa == null) {
			if (other.idSetorEmpresa != null)
				return false;
		} else if (!idSetorEmpresa.equals(other.idSetorEmpresa))
			return false;
		if (nomeSetorEmpresa == null) {
			if (other.nomeSetorEmpresa != null)
				return false;
		} else if (!nomeSetorEmpresa.equals(other.nomeSetorEmpresa))
			return false;
		if (siglaSetorEmpresa == null) {
			if (other.siglaSetorEmpresa != null)
				return false;
		} else if (!siglaSetorEmpresa.equals(other.siglaSetorEmpresa))
			return false;
		return true;
	}
	
	
}