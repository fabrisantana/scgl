package br.com.SCGLapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "fisioterapeuta")
public class Fisioterapeuta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FIS_ID")
	private Integer fisioId;
	
	@NotNull
	@Size(min = 10, max = 150)
	@Column(name = "FIS_NOME")
	private String fisioterapeutaNome;
		
	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "FIS_DT_NASCIMENTO")
	private Date fisioterapeutaDataNascimento;
	
	@NotNull
	@NotEmpty
	@Size(min = 7, max = 7)
	@Column(name = "FIS_RG")
	private Integer fisioterapeutaRg;
	
	@NotNull
	@Size(min = 11, max = 11)
	@Column(name = "FIS_CPF")
	private String fisioterapeutaCpf;
	
	@NotNull
	@NotEmpty
	@Column(name = "FIS_EMAIL")
	private String fisioterapeutaEmail;
	
	@NotNull
	@Column(name = "FIS_TELEFONE")
	private String fisioterapeutaTelefone;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "FIS_DT_ATUALIZACAO")
	private Date fisioterapeutaDtAtualizacao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "FIS_DT_EXCLUSAO")
	private Date fisioterapeutaDtExclusao;
	
	@NotNull
	@Column(name = "FIS_STATUS")
	private String fisioterapeutaStatus;

	
	//Getters e Setters
	public Integer getFisioId() {
		return fisioId;
	}


	public void setFisioId(Integer fisioId) {
		this.fisioId = fisioId;
	}


	public String getFisioterapeutaNome() {
		return fisioterapeutaNome;
	}


	public void setFisioterapeutaNome(String fisioterapeutaNome) {
		this.fisioterapeutaNome = fisioterapeutaNome;
	}


	public Date getFisioterapeutaDataNascimento() {
		return fisioterapeutaDataNascimento;
	}


	public void setFisioterapeutaDataNascimento(Date fisioterapeutaDataNascimento) {
		this.fisioterapeutaDataNascimento = fisioterapeutaDataNascimento;
	}


	public Integer getFisioterapeutaRg() {
		return fisioterapeutaRg;
	}


	public void setFisioterapeutaRg(Integer fisioterapeutaRg) {
		this.fisioterapeutaRg = fisioterapeutaRg;
	}


	public String getFisioterapeutaCpf() {
		return fisioterapeutaCpf;
	}


	public void setFisioterapeutaCpf(String fisioterapeutaCpf) {
		this.fisioterapeutaCpf = fisioterapeutaCpf;
	}


	public String getFisioterapeutaEmail() {
		return fisioterapeutaEmail;
	}


	public void setFisioterapeutaEmail(String fisioterapeutaEmail) {
		this.fisioterapeutaEmail = fisioterapeutaEmail;
	}


	public String getFisioterapeutaTelefone() {
		return fisioterapeutaTelefone;
	}


	public void setFisioterapeutaTelefone(String fisioterapeutaTelefone) {
		this.fisioterapeutaTelefone = fisioterapeutaTelefone;
	}


	public Date getFisioterapeutaDtAtualizacao() {
		return fisioterapeutaDtAtualizacao;
	}


	public void setFisioterapeutaDtAtualizacao(Date fisioterapeutaDtAtualizacao) {
		this.fisioterapeutaDtAtualizacao = fisioterapeutaDtAtualizacao;
	}


	public Date getFisioterapeutaDtExclusao() {
		return fisioterapeutaDtExclusao;
	}


	public void setFisioterapeutaDtExclusao(Date fisioterapeutaDtExclusao) {
		this.fisioterapeutaDtExclusao = fisioterapeutaDtExclusao;
	}


	public String getFisioterapeutaStatus() {
		return fisioterapeutaStatus;
	}


	public void setFisioterapeutaStatus(String fisioterapeutaStatus) {
		this.fisioterapeutaStatus = fisioterapeutaStatus;
	}


	@Override
	public String toString() {
		return "Fisioterapeuta [fisioId=" + fisioId + ", fisioterapeutaNome=" + fisioterapeutaNome
				+ ", fisioterapeutaDataNascimento=" + fisioterapeutaDataNascimento + ", fisioterapeutaRg="
				+ fisioterapeutaRg + ", fisioterapeutaCpf=" + fisioterapeutaCpf + ", fisioterapeutaEmail="
				+ fisioterapeutaEmail + ", fisioterapeutaTelefone=" + fisioterapeutaTelefone
				+ ", fisioterapeutaDtAtualizacao=" + fisioterapeutaDtAtualizacao + ", fisioterapeutaDtExclusao="
				+ fisioterapeutaDtExclusao + ", fisioterapeutaStatus=" + fisioterapeutaStatus + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fisioId == null) ? 0 : fisioId.hashCode());
		result = prime * result + ((fisioterapeutaCpf == null) ? 0 : fisioterapeutaCpf.hashCode());
		result = prime * result
				+ ((fisioterapeutaDataNascimento == null) ? 0 : fisioterapeutaDataNascimento.hashCode());
		result = prime * result + ((fisioterapeutaDtAtualizacao == null) ? 0 : fisioterapeutaDtAtualizacao.hashCode());
		result = prime * result + ((fisioterapeutaDtExclusao == null) ? 0 : fisioterapeutaDtExclusao.hashCode());
		result = prime * result + ((fisioterapeutaEmail == null) ? 0 : fisioterapeutaEmail.hashCode());
		result = prime * result + ((fisioterapeutaNome == null) ? 0 : fisioterapeutaNome.hashCode());
		result = prime * result + ((fisioterapeutaRg == null) ? 0 : fisioterapeutaRg.hashCode());
		result = prime * result + ((fisioterapeutaStatus == null) ? 0 : fisioterapeutaStatus.hashCode());
		result = prime * result + ((fisioterapeutaTelefone == null) ? 0 : fisioterapeutaTelefone.hashCode());
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
		Fisioterapeuta other = (Fisioterapeuta) obj;
		if (fisioId == null) {
			if (other.fisioId != null)
				return false;
		} else if (!fisioId.equals(other.fisioId))
			return false;
		if (fisioterapeutaCpf == null) {
			if (other.fisioterapeutaCpf != null)
				return false;
		} else if (!fisioterapeutaCpf.equals(other.fisioterapeutaCpf))
			return false;
		if (fisioterapeutaDataNascimento == null) {
			if (other.fisioterapeutaDataNascimento != null)
				return false;
		} else if (!fisioterapeutaDataNascimento.equals(other.fisioterapeutaDataNascimento))
			return false;
		if (fisioterapeutaDtAtualizacao == null) {
			if (other.fisioterapeutaDtAtualizacao != null)
				return false;
		} else if (!fisioterapeutaDtAtualizacao.equals(other.fisioterapeutaDtAtualizacao))
			return false;
		if (fisioterapeutaDtExclusao == null) {
			if (other.fisioterapeutaDtExclusao != null)
				return false;
		} else if (!fisioterapeutaDtExclusao.equals(other.fisioterapeutaDtExclusao))
			return false;
		if (fisioterapeutaEmail == null) {
			if (other.fisioterapeutaEmail != null)
				return false;
		} else if (!fisioterapeutaEmail.equals(other.fisioterapeutaEmail))
			return false;
		if (fisioterapeutaNome == null) {
			if (other.fisioterapeutaNome != null)
				return false;
		} else if (!fisioterapeutaNome.equals(other.fisioterapeutaNome))
			return false;
		if (fisioterapeutaRg == null) {
			if (other.fisioterapeutaRg != null)
				return false;
		} else if (!fisioterapeutaRg.equals(other.fisioterapeutaRg))
			return false;
		if (fisioterapeutaStatus == null) {
			if (other.fisioterapeutaStatus != null)
				return false;
		} else if (!fisioterapeutaStatus.equals(other.fisioterapeutaStatus))
			return false;
		if (fisioterapeutaTelefone == null) {
			if (other.fisioterapeutaTelefone != null)
				return false;
		} else if (!fisioterapeutaTelefone.equals(other.fisioterapeutaTelefone))
			return false;
		return true;
	}
}
