package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jsf.entity.ClienteEntity;
import br.com.jsf.entity.EnderecoClienteEntity;
import br.com.util.HibernateUtil;

public class DaoEndereco<E> extends DaoGeneric<EnderecoClienteEntity>{

	
	public List<E> getListEntityPorId(Class<E> entidade, ClienteEntity cliente){
		
		EntityManager entityManager = HibernateUtil.geEntityManager();
		entityManager.clear();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<E> retorno = entityManager.createQuery("from " + entidade.getName() + " where clienteEntity = " + cliente.getIdCliente()).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	}

	
	
	
}
