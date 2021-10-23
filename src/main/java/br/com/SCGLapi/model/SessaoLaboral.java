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
@Table(name = "sessao_laboral")
public class SessaoLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SES_ID")
	private Integer idSessaoLaboral;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "SES_DT_HORA_SESSAO")
	private Date dataHoraSessaoLaboral;
	
	@NotNull
	@Column(name = "SES_FIS_ID")
	private Integer idFisioterapeuta;

	@NotNull
	@Column(name = "SES_CLI_ID")
	private Integer idCliente;
	
	
	//Getters e Setters
	public Integer getIdSessaoLaboral() {
		return idSessaoLaboral;
	}

	public void setIdSessaoLaboral(Integer idSessaoLaboral) {
		this.idSessaoLaboral = idSessaoLaboral;
	}

	public Date getDataHoraSessaoLaboral() {
		return dataHoraSessaoLaboral;
	}

	public void setDataHoraSessaoLaboral(Date dataHoraSessaoLaboral) {
		this.dataHoraSessaoLaboral = dataHoraSessaoLaboral;
	}

	public Integer getIdFisioterapeuta() {
		return idFisioterapeuta;
	}

	public void setIdFisioterapeuta(Integer idFisioterapeuta) {
		this.idFisioterapeuta = idFisioterapeuta;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	
	@Override
	public String toString() {
		return "SessaoLaboral [idSessaoLaboral=" + idSessaoLaboral + ", dataHoraSessaoLaboral=" + dataHoraSessaoLaboral
				+ ", idFisioterapeuta=" + idFisioterapeuta + ", idCliente=" + idCliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHoraSessaoLaboral == null) ? 0 : dataHoraSessaoLaboral.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
		if (dataHoraSessaoLaboral == null) {
			if (other.dataHoraSessaoLaboral != null)
				return false;
		} else if (!dataHoraSessaoLaboral.equals(other.dataHoraSessaoLaboral))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
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