package Infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		
		emf = Persistence.createEntityManagerFactory("exercicios_jpa");
		
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
		
	}
	
	public DAO() {
		// TODO Auto-generated constructor stub
		em = emf.createEntityManager();
		
	}
	
	public DAO<E> open() {
		
		em.getTransaction().begin();
		
		return this;
	}
	
	public DAO<E> close() {
		
		em.getTransaction().commit();
		
		return this;
	}
	
	public DAO<E> insert(E classe){
		
		em.persist(classe);
		
		return this;
	}
	
	public DAO<E> insertAtomic(E classe){
		
		return this.open().insert(classe).close();
		
	}
	
	public List<E> getAll() {

		return getAll(10, 0);
		
	}
	
	public E getFromId(Object id) {
		
		return em.find(classe, id);
		
	}
	
	public List<E> getAll(int tamanho, int offSet){
		if (classe == null) {
			throw new UnsupportedOperationException("Classe Vazia");
		}
	String jpql = "select e from" + classe.getName() + "e";
	
	TypedQuery<E> query = em.createQuery(jpql, classe);
	query.setMaxResults(tamanho);
	query.setFirstResult(offSet);
	
	return query.getResultList();
		
	}
	
	public void fechar() {

		em.close();
		
	}
}
