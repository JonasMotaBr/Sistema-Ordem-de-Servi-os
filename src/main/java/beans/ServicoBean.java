package beans;

import javax.faces.bean.ManagedBean;

import br.com.dao.DaoGeneric;
import br.com.jsf.entity.ServicoEntity;

@ManagedBean(name = "servicoBean")
public class ServicoBean {

	ServicoEntity servico = new ServicoEntity();
	DaoGeneric<ServicoEntity> daoservico = new DaoGeneric<ServicoEntity>();
	
	
	
	public String salvarServico() {
		daoservico.salvar(servico);
		return "";
	}
	
	
	
	public ServicoEntity getServico() {
		return servico;
	}
	public void setServico(ServicoEntity servico) {
		this.servico = servico;
	}
	
	
	
	
	
}
