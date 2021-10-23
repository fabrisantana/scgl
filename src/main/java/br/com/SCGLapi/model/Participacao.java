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
@Table(name = "participacao")
public class Participacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAR_ID")
	private Integer idParticipacao;
	
	@NotNull
	@Column(name = "PAR_FREQUENCIA")
	private Boolean participacaoFrequencia;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "PAR_DT_FREQUENCIA")
	private Date dataParticipacao;
	
	@Column(name = "PAR_JUSTIFICATIVA")
	private String participacaoJustificativa;
	
	@NotNull
	@Column(name = "PAR_SES_ID")
	private Integer idSessaoLaboral;

	@NotNull
	@Column(name = "PAR_COL_ID")
	private Integer idColaborador;
	
	@NotNull
	@Column(name = "PAR_SET_ID")
	private Integer idSetorEmpresa;

	
	//Getters e Setters
	public Integer getIdParticipacao() {
		return idParticipacao;
	}

	public void setIdParticipacao(Integer idParticipacao) {
		this.idParticipacao = idParticipacao;
	}

	public Boolean getParticipacaoFrequencia() {
		return participacaoFrequencia;
	}

	public void setParticipacaoFrequencia(Boolean participacaoFrequencia) {
		this.participacaoFrequencia = participacaoFrequencia;
	}

	public Date getDataParticipacao() {
		return dataParticipacao;
	}

	public void setDataParticipacao(Date dataParticipacao) {
		this.dataParticipacao = dataParticipacao;
	}

	public String getParticipacaoJustificativa() {
		return participacaoJustificativa;
	}

	public void setParticipacaoJustificativa(String participacaoJustificativa) {
		this.participacaoJustificativa = participacaoJustificativa;
	}

	public Integer getIdSessaoLaboral() {
		return idSessaoLaboral;
	}

	public void setIdSessaoLaboral(Integer idSessaoLaboral) {
		this.idSessaoLaboral = idSessaoLaboral;
	}

	public Integer getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Integer getIdSetorEmpresa() {
		return idSetorEmpresa;
	}

	public void setIdSetorEmpresa(Integer idSetorEmpresa) {
		this.idSetorEmpresa = idSetorEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataParticipacao == null) ? 0 : dataParticipacao.hashCode());
		result = prime * result + ((idColaborador == null) ? 0 : idColaborador.hashCode());
		result = prime * result + ((idParticipacao == null) ? 0 : idParticipacao.hashCode());
		result = prime * result + ((idSessaoLaboral == null) ? 0 : idSessaoLaboral.hashCode());
		result = prime * result + ((idSetorEmpresa == null) ? 0 : idSetorEmpresa.hashCode());
		result = prime * result + ((participacaoFrequencia == null) ? 0 : participacaoFrequencia.hashCode());
		result = prime * result + ((participacaoJustificativa == null) ? 0 : participacaoJustificativa.hashCode());
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
		Participacao other = (Participacao) obj;
		if (dataParticipacao == null) {
			if (other.dataParticipacao != null)
				return false;
		} else if (!dataParticipacao.equals(other.dataParticipacao))
			return false;
		if (idColaborador == null) {
			if (other.idColaborador != null)
				return false;
		} else if (!idColaborador.equals(other.idColaborador))
			return false;
		if (idParticipacao == null) {
			if (other.idParticipacao != null)
				return false;
		} else if (!idParticipacao.equals(other.idParticipacao))
			return false;
		if (idSessaoLaboral == null) {
			if (other.idSessaoLaboral != null)
				return false;
		} else if (!idSessaoLaboral.equals(other.idSessaoLaboral))
			return false;
		if (idSetorEmpresa == null) {
			if (other.idSetorEmpresa != null)
				return false;
		} else if (!idSetorEmpresa.equals(other.idSetorEmpresa))
			return false;
		if (participacaoFrequencia == null) {
			if (other.participacaoFrequencia != null)
				return false;
		} else if (!participacaoFrequencia.equals(other.participacaoFrequencia))
			return false;
		if (participacaoJustificativa == null) {
			if (other.participacaoJustificativa != null)
				return false;
		} else if (!participacaoJustificativa.equals(other.participacaoJustificativa))
			return false;
		return true;
	}
	
}