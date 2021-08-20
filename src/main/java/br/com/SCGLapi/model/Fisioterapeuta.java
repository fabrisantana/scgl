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
	//@CPF(message="cpf inválido")
	@Column(name = "FIS_CPF")
	private String fisioterapeutaCpf;
	
	@NotNull
	@NotEmpty
	@Column(name = "FIS_EMAIL")
	private String fisioterapeutaEmail;
	
	@NotNull
	@Column(name = "FIS_TELEFONE")
	private String fisioterapeutaTelefone;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "FIS_DT_INCLUSAO")
	private Date fisioterapeutaDtInclusao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "FIS_DT_EXCLUSAO")
	private Date fisioterapeutaDtExclusao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "FIS_STATUS")
	private Status fisioterapeutaStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FIS_PERFIL")
	private Perfil fisioterapeutaPerfil;
	
	
	//Getters e Setters
	public Integer getId() {
		return fisioId;
	}

	public void setId(Integer fisioterapeuta_Id) {
		this.fisioId = fisioterapeuta_Id;
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

	public Date getFisioterapeutaDtInclusao() {
		return fisioterapeutaDtInclusao;
	}

	public void setFisioterapeutaDtInclusao(Date fisioterapeutaDtInclusao) {
		this.fisioterapeutaDtInclusao = fisioterapeutaDtInclusao;
	}

	public Date getFisioterapeutaDtExclusao() {
		return fisioterapeutaDtExclusao;
	}

	public void setFisioterapeutaDtExclusao(Date fisioterapeutaDtExclusao) {
		this.fisioterapeutaDtExclusao = fisioterapeutaDtExclusao;
	}

	public Status getStatus() {
		return fisioterapeutaStatus;
	}	

	public void setStatus(Status status) {
		fisioterapeutaStatus = status;
	}
	
	public Perfil getFisioterapeutaPerfil() {
		return fisioterapeutaPerfil;
	}

	public void setFisioterapeutaPerfil(Perfil fisioterapeutaPerfil) {
		this.fisioterapeutaPerfil = fisioterapeutaPerfil;
	}
	
	
	//ToString
	@Override
	public String toString() {
		return "Fisioterapeuta [fisioId=" + fisioId + ", fisioterapeutaNome=" + fisioterapeutaNome
				+ ", fisioterapeutaDataNascimento=" + fisioterapeutaDataNascimento + ", fisioterapeutaRg="
				+ fisioterapeutaRg + ", fisioterapeutaCpf=" + fisioterapeutaCpf + ", fisioterapeutaEmail="
				+ fisioterapeutaEmail + ", fisioterapeutaTelefone=" + fisioterapeutaTelefone
				+ ", fisioterapeutaDtInclusao=" + fisioterapeutaDtInclusao + ", fisioterapeutaDtExclusao="
				+ fisioterapeutaDtExclusao + ", fisioterapeutaStatus=" + fisioterapeutaStatus
				+ ", fisioterapeutaPerfil=" + fisioterapeutaPerfil + "]";
	}	
}
