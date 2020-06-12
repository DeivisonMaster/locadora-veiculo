//package jpql;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;
//
//import com.algaworks.curso.jpa2.model.Carro;
//
//public class ConsultaComNamedQuery {
//	public static void main(String[] args) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		
//		List<Carro> lista = entityManager.createNamedQuery("Carro.buscarTodos", Carro.class).getResultList();
//		for (Carro carro : lista) {
//			System.out.println(carro.getCor());
//		}
//	}
//}
