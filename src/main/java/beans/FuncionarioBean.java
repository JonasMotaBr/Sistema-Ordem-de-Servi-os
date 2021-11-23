package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.dao.DaoGeneric;
import br.com.jsf.entity.FuncionarioEntity;

@ManagedBean(name = "funcionarioBean")
public class FuncionarioBean {
	
	
	private DaoGeneric<FuncionarioEntity> daoFunc = new DaoGeneric<FuncionarioEntity>();
	FuncionarioEntity funcEntity = new  FuncionarioEntity();
	List<FuncionarioEntity> listaFunc = new ArrayList<FuncionarioEntity>();
	
	
	
	public String addFunc() {
		daoFunc.salvar(funcEntity);
		return "";
	}
	
	public DaoGeneric<FuncionarioEntity> getDaoFunc() {
		return daoFunc;
	}
	public void setDaoFunc(DaoGeneric<FuncionarioEntity> daoFunc) {
		this.daoFunc = daoFunc;
	}
	public FuncionarioEntity getFuncEntity() {
		return funcEntity;
	}
	public void setFuncEntity(FuncionarioEntity funcEntity) {
		this.funcEntity = funcEntity;
	}
	public List<FuncionarioEntity> getListaFunc() {
		listaFunc = daoFunc.getListEntity(FuncionarioEntity.class);
		return listaFunc;
	}
	
	
	

}
