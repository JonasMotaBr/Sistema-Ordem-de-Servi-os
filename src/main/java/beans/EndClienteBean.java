package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.jsf.entity.ClienteEntity;
import br.com.jsf.entity.EnderecoClienteEntity;

@ManagedBean(name = "endeClienteBean")
@ViewScoped
public class EndClienteBean {
	
	ClienteEntity cliente = new ClienteEntity();
	EnderecoClienteEntity end = new EnderecoClienteEntity();
	DaoGeneric<EnderecoClienteEntity> daoEnd = new DaoGeneric<EnderecoClienteEntity>();
	DaoGeneric<ClienteEntity> daocliente = new DaoGeneric<ClienteEntity>();
	List<EnderecoClienteEntity>	listaEnd = new ArrayList<EnderecoClienteEntity>();
	
	
	
	@PostConstruct
	public void init() {
		String codUser = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigouser");
		cliente = daocliente.pesquisar(Long.parseLong(codUser), ClienteEntity.class);
	}

	public String Salvar() {
		end.setClienteEntity(cliente);
		daoEnd.salvar(end);
		return "";
	}



	public EnderecoClienteEntity getEnd() {
		return end;
	}


	public List<EnderecoClienteEntity> getListaEnd() {
    	listaEnd = daoEnd.getListEntity(EnderecoClienteEntity.class);
    	return listaEnd;
	}

	public void setEnd(EnderecoClienteEntity end) {
		this.end = end;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}



}
