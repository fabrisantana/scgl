package br.com.SCGLapi.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
@Table(name = "participacao")
public class Participacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAR_ID")
	private Integer idParticipacao;
	
	@NotNull
	@Column(name = "PAR_FREQUENCIA")
	private Boolean participacaoFrequencia;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "PAR_DT_HORA_FREQUENCIA")
	private Date dataHoraParticipacao;
	
	@Column(name = "PAR_JUSTIFICATIVA")
	private String participacaoJustificativa;
	
	@NotNull
	@Column(name = "PAR_SES_ID")
	private Integer idSessaoLaboral;

	@NotNull
	@Column(name = "PAR_COL_ID")
	private Integer idColaborador;

	/*
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	*/
	
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

	public Date getDataHoraParticipacao() {
		return dataHoraParticipacao;
	}

	public void setDataHoraParticipacao(Date dataHoraParticipacao) {
		this.dataHoraParticipacao = dataHoraParticipacao;
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

	@Override
	public String toString() {
		return "Participacao [idParticipacao=" + idParticipacao + ", participacaoFrequencia=" + participacaoFrequencia
				+ ", dataHoraParticipacao=" + dataHoraParticipacao + ", participacaoJustificativa="
				+ participacaoJustificativa + ", idSessaoLaboral=" + idSessaoLaboral + ", idColaborador="
				+ idColaborador + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHoraParticipacao == null) ? 0 : dataHoraParticipacao.hashCode());
		result = prime * result + ((idColaborador == null) ? 0 : idColaborador.hashCode());
		result = prime * result + ((idParticipacao == null) ? 0 : idParticipacao.hashCode());
		result = prime * result + ((idSessaoLaboral == null) ? 0 : idSessaoLaboral.hashCode());
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
		if (dataHoraParticipacao == null) {
			if (other.dataHoraParticipacao != null)
				return false;
		} else if (!dataHoraParticipacao.equals(other.dataHoraParticipacao))
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