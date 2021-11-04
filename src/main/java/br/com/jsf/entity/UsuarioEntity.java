package br.com.jsf.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioEntity implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	private String loginUsuario;
	private String senhaUsuario;
	private String repSenhaUsuario;
	private String nomeUsuario;
	private String emailUsuario;
	private int CPF;
	
	
	public UsuarioEntity(Long idUsuario, String loginUsuario, String senhaUsuario, String repSenhaUsuario,
			String nomeUsuario, String emailUsuario, int cPF) {
		super();
		this.idUsuario = idUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
		this.repSenhaUsuario = repSenhaUsuario;
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		CPF = cPF;
	}


	public UsuarioEntity() {
	}


	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getLoginUsuario() {
		return loginUsuario;
	}


	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}


	public String getSenhaUsuario() {
		return senhaUsuario;
	}


	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}


	public String getRepSenhaUsuario() {
		return repSenhaUsuario;
	}


	public void setRepSenhaUsuario(String repSenhaUsuario) {
		this.repSenhaUsuario = repSenhaUsuario;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getEmailUsuario() {
		return emailUsuario;
	}


	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}


	public int getCPF() {
		return CPF;
	}


	public void setCPF(int cPF) {
		CPF = cPF;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		UsuarioEntity other = (UsuarioEntity) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UsuarioEntity [idUsuario=" + idUsuario + ", loginUsuario=" + loginUsuario + ", senhaUsuario="
				+ senhaUsuario + ", repSenhaUsuario=" + repSenhaUsuario + ", nomeUsuario=" + nomeUsuario
				+ ", emailUsuario=" + emailUsuario + ", CPF=" + CPF + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
