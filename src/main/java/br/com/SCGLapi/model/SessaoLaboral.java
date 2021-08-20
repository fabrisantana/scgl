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
@Table(name = "sessao_laboral")
public class SessaoLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SES_ID")
	private Integer idSessaoLaboral;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "SES_DT_HORA_SESSAO")
	private Date dataSessaoLaboral;
	
	@NotNull
	@Column(name = "SES_FIS_ID")
	private Integer idFisioterapeuta;

	@NotNull
	@Column(name = "SES_AVA_ID")
	private Integer idAvaliacao;

	/*
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	*/
	
	//Getters e Setters
	public Integer getIdSessaoLaboral() {
		return idSessaoLaboral;
	}

	public void setIdSessaoLaboral(Integer idSessaoLaboral) {
		this.idSessaoLaboral = idSessaoLaboral;
	}

	public Date getDataSessaoLaboral() {
		return dataSessaoLaboral;
	}

	public void setDataSessaoLaboral(Date dataSessaoLaboral) {
		this.dataSessaoLaboral = dataSessaoLaboral;
	}

	public Integer getIdFisioterapeuta() {
		return idFisioterapeuta;
	}

	public void setIdFisioterapeuta(Integer idFisioterapeuta) {
		this.idFisioterapeuta = idFisioterapeuta;
	}

	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	@Override
	public String toString() {
		return "SessaoLaboral [idSessaoLaboral=" + idSessaoLaboral + ", dataSessaoLaboral=" + dataSessaoLaboral
				+ ", idFisioterapeuta=" + idFisioterapeuta + ", idAvaliacao=" + idAvaliacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSessaoLaboral == null) ? 0 : dataSessaoLaboral.hashCode());
		result = prime * result + ((idAvaliacao == null) ? 0 : idAvaliacao.hashCode());
		result = prime * result + ((idFisioterapeuta == null) ? 0 : idFisioterapeuta.hashCode());
		result = prime * result + ((idSessaoLaboral == null) ? 0 : idSessaoLaboral.hashCode());
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
		SessaoLaboral other = (SessaoLaboral) obj;
		if (dataSessaoLaboral == null) {
			if (other.dataSessaoLaboral != null)
				return false;
		} else if (!dataSessaoLaboral.equals(other.dataSessaoLaboral))
			return false;
		if (idAvaliacao == null) {
			if (other.idAvaliacao != null)
				return false;
		} else if (!idAvaliacao.equals(other.idAvaliacao))
			return false;
		if (idFisioterapeuta == null) {
			if (other.idFisioterapeuta != null)
				return false;
		} else if (!idFisioterapeuta.equals(other.idFisioterapeuta))
			return false;
		if (idSessaoLaboral == null) {
			if (other.idSessaoLaboral != null)
				return false;
		} else if (!idSessaoLaboral.equals(other.idSessaoLaboral))
			return false;
		return true;
	}
	
}