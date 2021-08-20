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
@Table(name = "atendimento")
public class Atendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATE_ID")
	private Integer idAtendimento;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "ATE_DT_HORA_ATENDIMENTO")
	private Date dataHoraAtendimento;
	
	@NotNull
	@Column(name = "ATE_FIS_ID")
	private Integer idFisioterapeuta;

	@NotNull
	@Column(name = "ATE_CLI_ID")
	private Integer idCliente;
	
	/*
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	*/
	
	//Getters e Setters
	public Integer getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(Integer idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public Date getDataHoraAtendimento() {
		return dataHoraAtendimento;
	}

	public void setDataHoraAtendimento(Date dataHoraAtendimento) {
		this.dataHoraAtendimento = dataHoraAtendimento;
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
		return "Atendimento [idAtendimento=" + idAtendimento + ", dataHoraAtendimento=" + dataHoraAtendimento
				+ ", idFisioterapeuta=" + idFisioterapeuta + ", idCliente=" + idCliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHoraAtendimento == null) ? 0 : dataHoraAtendimento.hashCode());
		result = prime * result + ((idAtendimento == null) ? 0 : idAtendimento.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
		Atendimento other = (Atendimento) obj;
		if (dataHoraAtendimento == null) {
			if (other.dataHoraAtendimento != null)
				return false;
		} else if (!dataHoraAtendimento.equals(other.dataHoraAtendimento))
			return false;
		if (idAtendimento == null) {
			if (other.idAtendimento != null)
				return false;
		} else if (!idAtendimento.equals(other.idAtendimento))
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
		return true;
	}

}