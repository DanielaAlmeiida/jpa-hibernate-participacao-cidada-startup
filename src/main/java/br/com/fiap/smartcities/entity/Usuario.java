package br.com.fiap.smartcities.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tbl_usuario")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Usuario {
	@Id
	@SequenceGenerator(name="usuario",sequenceName="sq_usuario",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuario")
	@Column(name = "id_usuario")
	private Integer id;

	@Column(name = "nm_usuario", length = 50)
	private String nome;
	
	@Column(name = "email", length = 50)
	private String email;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "ds_localizacao")
	private String localizacao;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_registro")
	private Calendar dataDeRegistro;
	
	
	@OneToMany(mappedBy = "usuario")
	private List<Relato> relatos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Comentario> comentarios;

	
	public Usuario() {

	}

	public Usuario(String nome, String email, String senha, String localizacao, Calendar dataDeRegistro,
			List<Relato> relatos, List<Comentario> comentarios) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.localizacao = localizacao;
		this.dataDeRegistro = dataDeRegistro;
		this.relatos = relatos;
		this.comentarios = comentarios;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Calendar getDataDeRegistro() {
		return dataDeRegistro;
	}

	public List<Relato> getRelatos() {
		return relatos;
	}

	public void setRelatos(List<Relato> relatos) {
		this.relatos = relatos;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", localizacao="
				+ localizacao + ", dataDeRegistro=" + dataDeRegistro + ", relatos=" + relatos + ", comentarios="
				+ comentarios + "]";
	}
	
	
}