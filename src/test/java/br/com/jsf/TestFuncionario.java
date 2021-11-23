package br.com.jsf;

import java.util.List;

import org.junit.Test;

import beans.FuncionarioBean;
import br.com.dao.DaoFuncionario;
import br.com.jsf.entity.FuncionarioEntity;

public class TestFuncionario {
	
	
	
	@Test
	public void addFunc() {
		FuncionarioEntity funcionario = new FuncionarioEntity();
		funcionario.setNomeFunc("Func2");
		funcionario.setSenhaFunc("123456");
		
		FuncionarioBean funcBean = new FuncionarioBean();
		funcBean.setFuncEntity(funcionario);
		funcBean.addFunc();
		
		
	}
	
	
	@Test
	public void ListaFunc() {
		FuncionarioBean funcBean = new FuncionarioBean();
		
		List<FuncionarioEntity> lista = funcBean.getListaFunc();
		
		for(FuncionarioEntity f : lista) {
			System.out.println(f.getNomeFunc());
		}
	}
	
	@Test
	public void buscarPorNome() {
		FuncionarioEntity func = new FuncionarioEntity();
		DaoFuncionario<FuncionarioEntity> dao = new DaoFuncionario<FuncionarioEntity>();
		func = (FuncionarioEntity) dao.pesquisarPorNome("Carlos", FuncionarioEntity.class);
		System.out.println(func);
		
	}
	
	

}
