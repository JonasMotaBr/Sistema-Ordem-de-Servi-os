package br.com.jsf;

import org.junit.Test;

import br.com.dao.DaoGeneric;
import br.com.jsf.entity.EnderecoClienteEntity;

public class TesteTelefone {

	
	
	
	@Test
	public void deletarTelefone() {
		EnderecoClienteEntity end = new EnderecoClienteEntity();
		end.setIdEnd(19L);
		DaoGeneric<EnderecoClienteEntity> daoEnd = new DaoGeneric<EnderecoClienteEntity>();
		daoEnd.delete(end);
	}
}
