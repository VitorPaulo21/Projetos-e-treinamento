package exercicios_jpa.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exercicios_jpa.modelo.basico.Usuario;

public class RemoverUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios_jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario user = em.find(Usuario.class, 1L);
		
		if (user != null) {
			
			em.getTransaction().begin();
			
			em.remove(user);
			
			em.getTransaction().commit();
			
		}
		
		emf.close();
		em.close();
		
	}
	
}
