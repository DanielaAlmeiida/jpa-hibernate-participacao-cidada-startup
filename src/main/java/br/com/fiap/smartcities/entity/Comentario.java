package br.com.fiap.smartcities.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tbl_comentario")
public class Comentario {

	@Id
	@SequenceGenerator(name="comentario",sequenceName="sq_comentario",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comentario")
	@Column(name = "id_comentario")
	private Integer id;
	
	@Column(name = "ds_comentario")
	private String descricaoComentario;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_comentario")
	private Calendar datacomentario;
	
	
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_relato")
    private Relato relato;

    
	public Comentario() {

	}

	public Comentario(String descricaoComentario, Calendar datacomentario, Usuario usuario, Relato relato) {
		super();
		this.descricaoComentario = descricaoComentario;
		this.datacomentario = datacomentario;
		this.usuario = usuario;
		this.relato = relato;
	}

	
	public String getDescricaoComentario() {
		return descricaoComentario;
	}

	public void setDescricaoComentario(String descricaoComentario) {
		this.descricaoComentario = descricaoComentario;
	}

	public Calendar getDatacomentario() {
		return datacomentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Relato getRelato() {
		return relato;
	}

	public void setRelato(Relato relato) {
		this.relato = relato;
	}
	

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", descricaoComentario=" + descricaoComentario + ", datacomentario="
				+ datacomentario + ", usuario=" + usuario + ", relato=" + relato + "]";
	}
 


}