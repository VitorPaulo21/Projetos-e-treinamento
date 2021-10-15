package exercicios_jpa.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exercicios_jpa.modelo.basico.Usuario;

public class newUser {

	public static void main(String[] args) {
		
		EntityManagerFactory  emf = Persistence
				  .createEntityManagerFactory("exercicios_jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario user = new Usuario("Vitor", "vitorpaulo31212gmal.com");
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		
		emf.close();
	}
	
}
