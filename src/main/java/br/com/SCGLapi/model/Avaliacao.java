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
@Table(name = "avaliacao")
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AVA_ID")
	private Integer idAvaliacao;
	
	@NotNull
	@Size(min = 5, max = 500)
	@Column(name = "AVA_DESCRICAO")
	private String descricaoAvaliacao;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "AVA_DT_HORA_AVALIACAO")
	private Date dataHoraAvaliacao;
	
	@NotNull
	@Column(name = "AVA_FIS_ID")
	private Integer idFisioterapeuta;

	@NotNull
	@Column(name = "AVA_COL_ID")
	private Integer idColaborador;
	
	/*
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	*/
	
	//Getters e Setters
	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getDescricaoAvaliacao() {
		return descricaoAvaliacao;
	}

	public void setDescricaoAvaliacao(String descricaoAvaliacao) {
		this.descricaoAvaliacao = descricaoAvaliacao;
	}

	public Date getDataHoraAvaliacao() {
		return dataHoraAvaliacao;
	}

	public void setDataHoraAvaliacao(Date dataHoraAvaliacao) {
		this.dataHoraAvaliacao = dataHoraAvaliacao;
	}

	public Integer getIdFisioterapeuta() {
		return idFisioterapeuta;
	}

	public void setIdFisioterapeuta(Integer idFisioterapeuta) {
		this.idFisioterapeuta = idFisioterapeuta;
	}

	public Integer getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}

	@Override
	public String toString() {
		return "Avaliacao [idAvaliacao=" + idAvaliacao + ", descricaoAvaliacao=" + descricaoAvaliacao
				+ ", dataHoraAvaliacao=" + dataHoraAvaliacao + ", idFisioterapeuta=" + idFisioterapeuta
				+ ", idColaborador=" + idColaborador + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHoraAvaliacao == null) ? 0 : dataHoraAvaliacao.hashCode());
		result = prime * result + ((descricaoAvaliacao == null) ? 0 : descricaoAvaliacao.hashCode());
		result = prime * result + ((idAvaliacao == null) ? 0 : idAvaliacao.hashCode());
		result = prime * result + ((idColaborador == null) ? 0 : idColaborador.hashCode());
		result = prime * result + ((idFisioterapeuta == null) ? 0 : idFisioterapeuta.hashCode());
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
		Avaliacao other = (Avaliacao) obj;
		if (dataHoraAvaliacao == null) {
			if (other.dataHoraAvaliacao != null)
				return false;
		} else if (!dataHoraAvaliacao.equals(other.dataHoraAvaliacao))
			return false;
		if (descricaoAvaliacao == null) {
			if (other.descricaoAvaliacao != null)
				return false;
		} else if (!descricaoAvaliacao.equals(other.descricaoAvaliacao))
			return false;
		if (idAvaliacao == null) {
			if (other.idAvaliacao != null)
				return false;
		} else if (!idAvaliacao.equals(other.idAvaliacao))
			return false;
		if (idColaborador == null) {
			if (other.idColaborador != null)
				return false;
		} else if (!idColaborador.equals(other.idColaborador))
			return false;
		if (idFisioterapeuta == null) {
			if (other.idFisioterapeuta != null)
				return false;
		} else if (!idFisioterapeuta.equals(other.idFisioterapeuta))
			return false;
		return true;
	}
	
}