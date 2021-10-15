package exercicios_jpa.teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import exercicios_jpa.modelo.basico.Usuario;

public class Consulta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios_jpa");
		EntityManager em = emf.createEntityManager();
//		
//		String jpql = "select u from Usuario u where (nome = 'Vitor')";
//		
//		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
//		List<Usuario> result = query.getResultList();
//		
//		for (Usuario usuario : result) {
//			
//			System.out.println(usuario.getEmail());
//			
//		}
		
		
//		result.get(0).setEmail("vitorpaulo3121@gmail.com");
		
		Usuario user = new Usuario("Vitor", "vitorpaulo3122@gmail.com");
		user.setId(1L);
		
		em.getTransaction().begin();
		
		em.merge(user);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
	
}
