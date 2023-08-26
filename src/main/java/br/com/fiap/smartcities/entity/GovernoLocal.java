package br.com.fiap.smartcities.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="tbl_governo_local")
public class GovernoLocal extends Usuario{

	@Column(name = "tipo_governo", length = 50)
	private String tipoGoverno;
	
	@Column(name = "ds_contato", length = 50)
	private String contato;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fundacao")
	private Calendar dataFundacao;

	
	public GovernoLocal() {

	}
		
	public GovernoLocal(String tipoGoverno, String contato, Calendar dataFundacao) {
		super();
		this.tipoGoverno = tipoGoverno;
		this.contato = contato;
		this.dataFundacao = dataFundacao;
	}


	public String getTipGoverno() {
		return tipoGoverno;
	}

	public void setTipGoverno(String tipGoverno) {
		this.tipoGoverno = tipGoverno;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	@Override
	public String toString() {
		return "GovernoLocal [tipoGoverno=" + tipoGoverno + ", contato=" + contato + ", dataFundacao=" + dataFundacao
				+ "]";
	}
	
}