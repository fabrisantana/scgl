package br.com.SCGLapi.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.SCGLapi.model.Role;


@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "USU_DT_HORA_ATUALIZACAO")
	private Date dataHoraAtualizacao;
	
	@Id
	@NotNull
	@Column(name = "USU_LOGIN")
	private String login;
	
	@NotNull
	@Column(name = "SENHA")
	private String senha;
	
	@NotNull
	@Column(name = "USU_STATUS")
	private Boolean statusUsuario;
	
	@ManyToMany
	@JoinTable( 
	        name = "usuario_role", 
	        joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "USU_LOGIN"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole")) 
    
	private List<Role> roles;
	
	
	//Getters e Setters
	public Boolean getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(Boolean statusUsuario) {
		this.statusUsuario = statusUsuario;
	}
	
	public Date getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}

	public void setDataHoraAtualizacao(Date dataHoraAtualizacao) {
		this.dataHoraAtualizacao = dataHoraAtualizacao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	@Override
	public String toString() {
		return "Usuario [dataHoraAtualizacao=" + dataHoraAtualizacao + ", login=" + login
				+ ", senha=" + senha + ", statusUsuario=" + statusUsuario + ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHoraAtualizacao == null) ? 0 : dataHoraAtualizacao.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((statusUsuario == null) ? 0 : statusUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (dataHoraAtualizacao == null) {
			if (other.dataHoraAtualizacao != null)
				return false;
		} else if (!dataHoraAtualizacao.equals(other.dataHoraAtualizacao))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (statusUsuario == null) {
			if (other.statusUsuario != null)
				return false;
		} else if (!statusUsuario.equals(other.statusUsuario))
			return false;
		return true;
	}

	
	//Autorizações
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.statusUsuario;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.statusUsuario;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.statusUsuario;
	}

	@Override
	public boolean isEnabled() {
		
		return this.statusUsuario;
	}
	
}