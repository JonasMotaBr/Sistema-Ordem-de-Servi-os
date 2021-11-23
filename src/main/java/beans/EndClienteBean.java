package beans;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

import com.google.gson.Gson;

import br.com.dao.DaoEndereco;
import br.com.dao.DaoGeneric;
import br.com.jsf.entity.ClienteEntity;
import br.com.jsf.entity.EnderecoClienteEntity;

@ManagedBean(name = "endeClienteBean")
@ViewScoped
public class EndClienteBean {
	
	ClienteEntity cliente = new ClienteEntity();
	EnderecoClienteEntity end = new EnderecoClienteEntity();
	DaoEndereco<EnderecoClienteEntity> daoEnd = new DaoEndereco<EnderecoClienteEntity>();
	
	DaoGeneric<ClienteEntity> daocliente = new DaoGeneric<ClienteEntity>();
	List<EnderecoClienteEntity>	listaEnd = new ArrayList<EnderecoClienteEntity>();
	
	
	
	@PostConstruct
	public void init() {
		String codUser = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigouser");
		if(codUser != null){ 
			cliente = daocliente.pesquisar(Long.parseLong(codUser), ClienteEntity.class);
	   }
	}
	public String Paginainicial() {
		return "index";
	}
	
	
	public void pesquisacep(AjaxBehaviorEvent event) {
		try {
			URL url = new URL("https://viacep.com.br/ws/"+end.getCep()+"/json/");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			String cep = "";
			StringBuilder jsonCep = new StringBuilder();
			while ((cep = br.readLine()) != null)  {
				jsonCep.append(cep);
			}
			
			EnderecoClienteEntity enderecoCep = new Gson().fromJson(jsonCep.toString(), EnderecoClienteEntity.class);
             end.setBairro(enderecoCep.getBairro());
             end.setComplemento(enderecoCep.getComplemento());
             end.setDdd(enderecoCep.getDdd());
             end.setGia(enderecoCep.getGia());
             end.setIbge(enderecoCep.getIbge());
             end.setLocalidade(enderecoCep.getLocalidade());
             end.setLogradouro(enderecoCep.getLogradouro());
             end.setUf(enderecoCep.getUf());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String Salvar() {
		end.setClienteEntity(cliente);
		daoEnd.salvar(end);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Salvo com sucesso!"));
		return "index";
	}
    public String RemoverEndereco() {
    	System.out.println(end);
    	daoEnd.deletePorId(end);
    	end = new EnderecoClienteEntity();
    	return "";
    }


	public EnderecoClienteEntity getEnd() {
		return end;
	}


	public List<EnderecoClienteEntity> getListaEnd() {
    	listaEnd = daoEnd.getListEntityPorId(EnderecoClienteEntity.class, cliente );
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
