package beans;

import javax.faces.bean.ManagedBean;

import br.com.dao.DaoFuncionario;
import br.com.dao.DaoGeneric;
import br.com.jsf.entity.FuncionarioEntity;
import br.com.jsf.entity.ServicoEntity;

@ManagedBean(name = "servicoBean")
public class ServicoBean {

	ServicoEntity servico = new ServicoEntity();
	DaoGeneric<ServicoEntity> daoservico = new DaoGeneric<ServicoEntity>();
	FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
	DaoFuncionario<FuncionarioEntity> daoFuncionario = new DaoFuncionario<FuncionarioEntity>();
	
	public String salvarServico(){
		FuncionarioEntity func = new FuncionarioEntity();
		func = daoFuncionario.pesquisarPorNome(funcionarioEntity.getNomeFunc(), FuncionarioEntity.class);
		//funcionarioEntity = daoFuncionario.pesquisar(2L, FuncionarioEntity.class);
		servico.setFuncionarioEntity(func);
		daoservico.salvar(servico);
		return "";
	}
	
	
	
	public ServicoEntity getServico() {
		return servico;
	}
	public void setServico(ServicoEntity servico) {
		this.servico = servico;
	}
	public FuncionarioEntity getFuncionarioEntity() {
		return funcionarioEntity;
	}
	public void setFuncionarioEntity(FuncionarioEntity funcionarioEntity) {
		this.funcionarioEntity = funcionarioEntity;
	}
	
	
	
	
	
}
