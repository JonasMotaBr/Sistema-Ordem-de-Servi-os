package br.com.jsf.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FuncionarioEntity implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFuncionario;
    private String nomeFunc;
    private String sobreNomeFunc;
    private String senhaFunc;
    
    
    
    
    
    
	public FuncionarioEntity() {
		super();
	}
	public FuncionarioEntity(String nomeFunc, String sobreNomeFunc, String senhaFunc) {
		super();
		this.nomeFunc = nomeFunc;
		this.sobreNomeFunc = sobreNomeFunc;
		this.senhaFunc = senhaFunc;
	}

	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
		result = prime * result + ((nomeFunc == null) ? 0 : nomeFunc.hashCode());
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
		FuncionarioEntity other = (FuncionarioEntity) obj;
		if (idFuncionario == null) {
			if (other.idFuncionario != null)
				return false;
		} else if (!idFuncionario.equals(other.idFuncionario))
			return false;
		if (nomeFunc == null) {
			if (other.nomeFunc != null)
				return false;
		} else if (!nomeFunc.equals(other.nomeFunc))
			return false;
		return true;
	}
	public Long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNomeFunc() {
		return nomeFunc;
	}
	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}
	public String getSobreNomeFunc() {
		return sobreNomeFunc;
	}
	public void setSobreNomeFunc(String sobreNomeFunc) {
		this.sobreNomeFunc = sobreNomeFunc;
	}
	public String getSenhaFunc() {
		return senhaFunc;
	}
	public void setSenhaFunc(String senhaFunc) {
		this.senhaFunc = senhaFunc;
	}

    
    
}
