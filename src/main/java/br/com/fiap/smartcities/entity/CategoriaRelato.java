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
@Table(name="tbl_categoria_relato")
public class CategoriaRelato {

	@Id
	@SequenceGenerator(name="categoria",sequenceName="sq_categoria",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="categoria")
	@Column(name = "id_categoria_relato")
	private Integer id;

	@Column(name = "nm_categoria", length = 50)
	private String titulo;
	
	@Column(name = "ds_categoria")
	private String descricao;


    @OneToMany(mappedBy = "categoria")
    private List<Relato> relatos;


	public CategoriaRelato() {

	}

	public CategoriaRelato(String titulo, String descricao, List<Relato> relatos) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.relatos = relatos;
	}

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Relato> getRelatos() {
		return relatos;
	}

	public void setRelatos(List<Relato> relatos) {
		this.relatos = relatos;
	}

	@Override
	public String toString() {
		return "CategoriaRelato [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", relatos=" + relatos
				+ "]";
	}
    
	
}