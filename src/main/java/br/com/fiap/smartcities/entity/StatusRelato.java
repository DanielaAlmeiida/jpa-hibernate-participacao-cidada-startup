package br.com.fiap.smartcities.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tbl_status_relato")
public class StatusRelato {

	@Id
	@SequenceGenerator(name="status",sequenceName="sq_status",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="status")
	@Column(name = "id_status_relato")
	private Integer id;

	@Column(name = "nm_status", length = 50)
	private String nome;

	
	@OneToMany(mappedBy = "status")
	private List<Relato> relatos;

	
	public StatusRelato() {
	}

	public StatusRelato(String nome, List<Relato> relatos) {
		this.nome = nome;
		this.relatos = relatos;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Relato> getRelatos() {
		return relatos;
	}

	public void setRelatos(List<Relato> relatos) {
		this.relatos = relatos;
	}

	@Override
	public String toString() {
		return "StatusRelato [id=" + id + ", nome=" + nome + ", relatos=" + relatos + "]";
	}
	

}