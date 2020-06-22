import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;

import br.com.locadora.model.Grupo;
import br.com.locadora.model.Usuario;
import br.com.locadora.util.jpa.EntityManagerProducer;

public class InclusaoUsuarioGrupo {
	public static void main(String[] args) {
		EntityManager em = new EntityManagerProducer().create();
		
		Grupo grupoVendedor = new Grupo();
		grupoVendedor.setNome("VENDEDOR");
		grupoVendedor.setDescricao("Vendedores da Empresa");
		
		Grupo grupoAdministrador = new Grupo();
		grupoAdministrador.setNome("ADMNISTRADOR");
		grupoAdministrador.setDescricao("Administradores da Empresa");
		
		Grupo grupoAuxiliar = new Grupo();
		grupoAuxiliar.setNome("AUXILIAR");
		grupoAuxiliar.setDescricao("Auxiliar da Empresa");
		
		
		Usuario usuarioAuxiliar = new Usuario();
		usuarioAuxiliar.setNome("auxiliar");
		usuarioAuxiliar.setSenha("123");
		usuarioAuxiliar.setEmail("aux@locadora.com");
		
		Collection<Grupo> grupos = new ArrayList<>();
		grupos.add(grupoAuxiliar);
		usuarioAuxiliar.setGrupos(grupos);
		
		em.getTransaction().begin();
		em.merge(usuarioAuxiliar);
		em.getTransaction().commit();
		
		
		Usuario usuarioVendedor = new Usuario();
		usuarioVendedor.setNome("joao");
		usuarioVendedor.setSenha("123");
		usuarioVendedor.setEmail("joao@locadora.com");
		
		grupos = new ArrayList<>();
		grupos.add(grupoVendedor);
		usuarioVendedor.setGrupos(grupos);
		
//		em.getTransaction().begin();
//		em.merge(usuarioVendedor);
//		em.getTransaction().commit();
		
		Usuario usuarioAdm = new Usuario();
		usuarioAdm.setNome("admin");
		usuarioAdm.setSenha("123");
		usuarioAdm.setEmail("admin@locadora.com");
		
		grupos = new ArrayList<>();
		grupos.add(grupoVendedor);
		grupos.add(grupoAdministrador);
		
		usuarioAdm.setGrupos(grupos);
		
//		em.getTransaction().begin();
//		em.merge(usuarioAdm);
//		em.getTransaction().commit();
	}
}
