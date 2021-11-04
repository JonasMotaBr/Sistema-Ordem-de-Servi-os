package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.dao.DaoGeneric;
import br.com.jsf.entity.ClienteEntity;

@ManagedBean(name = "clienteBean")
public class ClienteBean {

	
	private ClienteEntity cliente = new ClienteEntity();
	private DaoGeneric<ClienteEntity> dao = new DaoGeneric<ClienteEntity>();
	private List<ClienteEntity> lista = new ArrayList<ClienteEntity>();
	

	
	public String PagInicial() {
		return "index";
	}
	
	public String editarCliente() {
		dao.merge(cliente);
		return "EditarCliente";
	}
	
	public String salvar() {
		dao.salvar(cliente);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "Salvo com sucesso!"));
		return "";
	}
	public String Remover() {
		dao.deletePorId(cliente);
		cliente = new ClienteEntity();
		return "";
	}
	

	public List<ClienteEntity> getLista() {
		lista = dao.getListEntity(ClienteEntity.class);
		return lista;
	}


	

	
	
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
}
