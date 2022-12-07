package comdevti.aula.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;



@Entity
public class Cidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //torna a variavel como chame primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // torna a varialve como auto incremet no Banco de dados
	@ApiModelProperty(value = "ID, Chave primaria")
	private Integer id;
	@Column
	@ApiModelProperty(value = "Nome da Cidade")
	private String nome;
	@Column
	@ApiModelProperty(value = "Estado ou Unidade federativa")
	private String uf;
	
	public Cidade() {
		this(0, "", "");
	}
	
	public Cidade(Integer id, String nome, String uf) {
		this.id = id;
		this.nome = nome;
		this.uf = uf;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
