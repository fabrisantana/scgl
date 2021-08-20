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
@Table(name = "colaborador")
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COL_ID")
	private Integer colaboradorId;
	
	@NotNull
	@Column(name = "COL_NOME")
	private String colaboradorNome;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "COL_DT_NASCIMENTO")
	private Date colaboradorDataNascimento;
	
	@NotNull
	@Size(min = 7, max = 7)
	@Column(name = "COL_RG")
	private Integer colaboradorRg;
	
	@NotNull
	@Size(min = 11, max = 11)
	@Column(name = "COL_CPF")
	private String colaboradorCpf;
	
	@NotNull
	@Column(name = "COL_EMAIL")
	private String colaboradorEmail;
	
	@NotNull
	@Size(min = 12, max = 12)
	@Column(name = "COL_TELEFONE")
	private String colaboradorTelefone;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "COL_DT_INCLUSAO")
	private Date colaboradorDataInclusao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "COL_DT_EXCLUSAO")
	private Date colaboradorDataExclusao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "COL_STATUS")
	private Status colaboradorStatus;
	
	@NotNull
	@Column(name = "COL_SET_ID")
	private Integer idSetorEmpresa;
	
	//Getters e Setters
	public Integer getColaboradorId() {
		return colaboradorId;
	}

	public void setColaboradorId(Integer colaboradorId) {
		this.colaboradorId = colaboradorId;
	}

	public String getColaboradorNome() {
		return colaboradorNome;
	}

	public void setColaboradorNome(String colaboradorNome) {
		this.colaboradorNome = colaboradorNome;
	}

	public Date getColaboradorDataNascimento() {
		return colaboradorDataNascimento;
	}

	public void setColaboradorDataNascimento(Date colaboradorDataNascimento) {
		this.colaboradorDataNascimento = colaboradorDataNascimento;
	}

	public Integer getColaboradorRg() {
		return colaboradorRg;
	}

	public void setColaboradorRg(Integer colaboradorRg) {
		this.colaboradorRg = colaboradorRg;
	}

	public String getColaboradorCpf() {
		return colaboradorCpf;
	}

	public void setColaboradorCpf(String colaboradorCpf) {
		this.colaboradorCpf = colaboradorCpf;
	}

	public String getColaboradorEmail() {
		return colaboradorEmail;
	}

	public void setColaboradorEmail(String colaboradorEmail) {
		this.colaboradorEmail = colaboradorEmail;
	}

	public String getColaboradorTelefone() {
		return colaboradorTelefone;
	}

	public void setColaboradorTelefone(String colaboradorTelefone) {
		this.colaboradorTelefone = colaboradorTelefone;
	}

	public Date getColaboradorDataInclusao() {
		return colaboradorDataInclusao;
	}

	public void setColaboradorDataInclusao(Date colaboradorDataInclusao) {
		this.colaboradorDataInclusao = colaboradorDataInclusao;
	}

	public Date getColaboradorDataExclusao() {
		return colaboradorDataExclusao;
	}

	public void setColaboradorDataExclusao(Date colaboradorDataExclusao) {
		this.colaboradorDataExclusao = colaboradorDataExclusao;
	}

	public Status getColaboradorStatus() {
		return colaboradorStatus;
	}

	public void setColaboradorStatus(Status colaboradorStatus) {
		this.colaboradorStatus = colaboradorStatus;
	}

	public Integer getIdSetorEmpresa() {
		return idSetorEmpresa;
	}

	public void setIdSetorEmpresa(Integer idSetorEmpresa) {
		this.idSetorEmpresa = idSetorEmpresa;
	}

	@Override
	public String toString() {
		return "Colaborador [colaboradorId=" + colaboradorId + ", colaboradorNome=" + colaboradorNome
				+ ", colaboradorDataNascimento=" + colaboradorDataNascimento + ", colaboradorRg=" + colaboradorRg
				+ ", colaboradorCpf=" + colaboradorCpf + ", colaboradorEmail=" + colaboradorEmail
				+ ", colaboradorTelefone=" + colaboradorTelefone + ", colaboradorDataInclusao="
				+ colaboradorDataInclusao + ", colaboradorDataExclusao=" + colaboradorDataExclusao
				+ ", colaboradorStatus=" + colaboradorStatus + ", idSetorEmpresa=" + idSetorEmpresa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colaboradorCpf == null) ? 0 : colaboradorCpf.hashCode());
		result = prime * result + ((colaboradorDataExclusao == null) ? 0 : colaboradorDataExclusao.hashCode());
		result = prime * result + ((colaboradorDataInclusao == null) ? 0 : colaboradorDataInclusao.hashCode());
		result = prime * result + ((colaboradorDataNascimento == null) ? 0 : colaboradorDataNascimento.hashCode());
		result = prime * result + ((colaboradorEmail == null) ? 0 : colaboradorEmail.hashCode());
		result = prime * result + ((colaboradorId == null) ? 0 : colaboradorId.hashCode());
		result = prime * result + ((colaboradorNome == null) ? 0 : colaboradorNome.hashCode());
		result = prime * result + ((colaboradorRg == null) ? 0 : colaboradorRg.hashCode());
		result = prime * result + ((colaboradorStatus == null) ? 0 : colaboradorStatus.hashCode());
		result = prime * result + ((colaboradorTelefone == null) ? 0 : colaboradorTelefone.hashCode());
		result = prime * result + ((idSetorEmpresa == null) ? 0 : idSetorEmpresa.hashCode());
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
		Colaborador other = (Colaborador) obj;
		if (colaboradorCpf == null) {
			if (other.colaboradorCpf != null)
				return false;
		} else if (!colaboradorCpf.equals(other.colaboradorCpf))
			return false;
		if (colaboradorDataExclusao == null) {
			if (other.colaboradorDataExclusao != null)
				return false;
		} else if (!colaboradorDataExclusao.equals(other.colaboradorDataExclusao))
			return false;
		if (colaboradorDataInclusao == null) {
			if (other.colaboradorDataInclusao != null)
				return false;
		} else if (!colaboradorDataInclusao.equals(other.colaboradorDataInclusao))
			return false;
		if (colaboradorDataNascimento == null) {
			if (other.colaboradorDataNascimento != null)
				return false;
		} else if (!colaboradorDataNascimento.equals(other.colaboradorDataNascimento))
			return false;
		if (colaboradorEmail == null) {
			if (other.colaboradorEmail != null)
				return false;
		} else if (!colaboradorEmail.equals(other.colaboradorEmail))
			return false;
		if (colaboradorId == null) {
			if (other.colaboradorId != null)
				return false;
		} else if (!colaboradorId.equals(other.colaboradorId))
			return false;
		if (colaboradorNome == null) {
			if (other.colaboradorNome != null)
				return false;
		} else if (!colaboradorNome.equals(other.colaboradorNome))
			return false;
		if (colaboradorRg == null) {
			if (other.colaboradorRg != null)
				return false;
		} else if (!colaboradorRg.equals(other.colaboradorRg))
			return false;
		if (colaboradorStatus != other.colaboradorStatus)
			return false;
		if (colaboradorTelefone == null) {
			if (other.colaboradorTelefone != null)
				return false;
		} else if (!colaboradorTelefone.equals(other.colaboradorTelefone))
			return false;
		if (idSetorEmpresa == null) {
			if (other.idSetorEmpresa != null)
				return false;
		} else if (!idSetorEmpresa.equals(other.idSetorEmpresa))
			return false;
		return true;
	}
	
}
