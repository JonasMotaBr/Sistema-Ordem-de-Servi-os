package br.com.jsf.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ServicoEntity implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idServico;
	private String descricaoServico;
	private String funcionarioServico;
	private Date data;
	
	@ManyToOne
	private ClienteEntity clienteEntity;

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public String getFuncionarioServico() {
		return funcionarioServico;
	}

	public void setFuncionarioServico(String funcionarioServico) {
		this.funcionarioServico = funcionarioServico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public ClienteEntity getClienteEntity() {
		return clienteEntity;
	}

	public void setClienteEntity(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idServico == null) ? 0 : idServico.hashCode());
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
		ServicoEntity other = (ServicoEntity) obj;
		if (idServico == null) {
			if (other.idServico != null)
				return false;
		} else if (!idServico.equals(other.idServico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServicoEntity [idServico=" + idServico + ", descricaoServico=" + descricaoServico
				+ ", funcionarioServico=" + funcionarioServico + ", data=" + data + ", clienteEntity=" + clienteEntity
				+ "]";
	}
	
	
	
	
	
	
	
}
