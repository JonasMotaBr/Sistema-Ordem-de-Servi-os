package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jsf.entity.UsuarioEntity;
import br.com.util.HibernateUtil;

public class DaoGeneric<E> {

	


	public void salvar(E entidade) {
		EntityManager entityManager = HibernateUtil.geEntityManager();
		EntityTransaction transaction = entityManager.getTransaction(); //Obejto de transaÃ§Ã£o
		transaction.begin();// Inicia uma transaÃ§Ã£o
		entityManager.persist(entidade);// Salva no banco de dados
		transaction.commit();// Grava no banco de dados
		entityManager.close();
	}
	
	
	

	public E merge(E entidade){
		EntityManager entityManager = HibernateUtil.geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		E retorno = entityManager.merge(entidade);
		
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	}
	
	
	public void delete(E entidade){
		EntityManager entityManager = HibernateUtil.geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(entidade);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public void deletePorId(E entidade){
		EntityManager entityManager = HibernateUtil.geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = HibernateUtil.getPrimaryKey(entidade);
		entityManager.createQuery("delete from " + entidade.getClass().getCanonicalName() + " where id = " + id).executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	
	public List<E> getListEntity(Class<E> entidade){
		EntityManager entityManager = HibernateUtil.geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<E> retorno = entityManager.createQuery("from " + entidade.getName()).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	}
	public E pesquisar(Long id, Class<E> entidade) {
		EntityManager entityManager = HibernateUtil.geEntityManager();
		entityManager.clear();
		E e = (E) entityManager.createQuery("from " + entidade.getSimpleName() + " where id = " + id).getSingleResult();
		return e;

	}
	
}
