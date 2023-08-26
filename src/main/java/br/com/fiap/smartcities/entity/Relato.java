package br.com.fiap.smartcities.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tbl_relato")
public class Relato {

	@Id
	@SequenceGenerator(name="relato",sequenceName="sq_relato",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="relato")
	@Column(name = "id_relato")
	private Integer id;

	@Column(name = "titulo", length = 50)
	private String titulo;
	
	@Column(name = "ds_relato")
	private String descricao;
	
	@Column(name = "ds_local")
	private String local;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_relato")
	private Calendar dataRelato;
	
	@Column(name = "img_relato", length = 50)
    private String imagemRelato; // URL ou caminho da imagem
	
	
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

	@ManyToOne
    @JoinColumn(name = "id_status_relato")
    private StatusRelato status;
	

	@ManyToOne
	@JoinColumn(name = "id_categoria_relato")
    private CategoriaRelato categoria;
	
	@OneToMany(mappedBy = "relato")
	private List<Comentario> comentarios;

	public Relato() {

	}

	public Relato(String titulo, String descricao, String local, Calendar dataRelato, String imagemRelato,
			Usuario usuario, StatusRelato status, CategoriaRelato categoria, List<Comentario> comentarios) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.local = local;
		this.dataRelato = dataRelato;
		this.imagemRelato = imagemRelato;
		this.usuario = usuario;
		this.status = status;
		this.categoria = categoria;
		this.comentarios = comentarios;
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Calendar getDataRelato() {
		return dataRelato;
	}

	public String getImagemRelato() {
		return imagemRelato;
	}

	public void setImagemRelato(String imagemRelato) {
		this.imagemRelato = imagemRelato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public StatusRelato getStatus() {
		return status;
	}

	public void setStatus(StatusRelato status) {
		this.status = status;
	}

	public CategoriaRelato getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaRelato categoria) {
		this.categoria = categoria;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Relato [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", local=" + local
				+ ", dataRelato=" + dataRelato + ", usuario=" + usuario.getNome() + "]";
	}

	
	
	
}