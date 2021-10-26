package br.com.SCGLapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "usuario_role")
public class UsuariosRole {

	@Id
	@Column(name = "USUARIO_ID")
	private String loginUsuario;
	
	@NotNull
	@Column(name = "ROLE_ID")
	private String tipoRole;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "USR_DT_HORA_ATUALIZACAO")
	private Date dataHoraAtualizacao;
	
	@NotNull
	@Column(name = "USR_NOME")
	private String nomeUsuario;
	
	@NotNull
	@Column(name = "USR_STATUS")
	private Boolean statusUsuario;
	
	@NotNull
	@Column(name = "USR_EMAIL")
	private String emailUsuario;
	
	
	//Getters e Setters
	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getTipoRole() {
		return tipoRole;
	}

	public void setTipoRole(String tipoRole) {
		this.tipoRole = tipoRole;
	}

	public Date getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}

	public void setDataHoraAtualizacao(Date dataHoraAtualizacao) {
		this.dataHoraAtualizacao = dataHoraAtualizacao;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Boolean getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(Boolean statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	
	@Override
	public String toString() {
		return "UsuariosRole [loginUsuario=" + loginUsuario + ", tipoRole=" + tipoRole + ", dataHoraAtualizacao="
				+ dataHoraAtualizacao + ", nomeUsuario=" + nomeUsuario + ", statusUsuario=" + statusUsuario
				+ ", emailUsuario=" + emailUsuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHoraAtualizacao == null) ? 0 : dataHoraAtualizacao.hashCode());
		result = prime * result + ((emailUsuario == null) ? 0 : emailUsuario.hashCode());
		result = prime * result + ((loginUsuario == null) ? 0 : loginUsuario.hashCode());
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		result = prime * result + ((statusUsuario == null) ? 0 : statusUsuario.hashCode());
		result = prime * result + ((tipoRole == null) ? 0 : tipoRole.hashCode());
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
		UsuariosRole other = (UsuariosRole) obj;
		if (dataHoraAtualizacao == null) {
			if (other.dataHoraAtualizacao != null)
				return false;
		} else if (!dataHoraAtualizacao.equals(other.dataHoraAtualizacao))
			return false;
		if (emailUsuario == null) {
			if (other.emailUsuario != null)
				return false;
		} else if (!emailUsuario.equals(other.emailUsuario))
			return false;
		if (loginUsuario == null) {
			if (other.loginUsuario != null)
				return false;
		} else if (!loginUsuario.equals(other.loginUsuario))
			return false;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		if (statusUsuario == null) {
			if (other.statusUsuario != null)
				return false;
		} else if (!statusUsuario.equals(other.statusUsuario))
			return false;
		if (tipoRole == null) {
			if (other.tipoRole != null)
				return false;
		} else if (!tipoRole.equals(other.tipoRole))
			return false;
		return true;
	}
	
}