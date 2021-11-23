package br.com.dao;

import javax.persistence.EntityManager;

import br.com.jsf.entity.FuncionarioEntity;
import br.com.util.HibernateUtil;

public class DaoFuncionario<E> extends DaoGeneric<FuncionarioEntity> {

	
	public E pesquisarPorNome(String nome, Class<E> entidade) {
		EntityManager entityManager = HibernateUtil.geEntityManager();
		entityManager.clear();
		E e = (E) entityManager.createQuery("from " + entidade.getSimpleName() + " where nomeFunc = '" +nome+"'" ).getSingleResult();
		return e;

	}
	
}
