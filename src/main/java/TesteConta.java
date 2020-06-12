//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
//import java.util.Scanner;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import com.algaworks.curso.jpa2.model.Conta;
//
//public class TesteConta {
//	public static void main(String[] args) throws IOException {
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager em = factory.createEntityManager();
//		
//		
//		PrintStream printStream = System.out;
//		
//		Conta conta1 = em.find(Conta.class, 1L);
//		if(conta1 == null) {
//			printStream.println("Digite o saldo inicial da conta 1: ");
//			
//			InputStream in = System.in;
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader br = new BufferedReader(isr);
//			String linha = br.readLine();
//			Double saldo = new Double(linha);
//			
//			conta1 = new Conta();
//			conta1.setSaldo(saldo);
//		}
//		
//		Conta conta2 = em.find(Conta.class, 2L);
//		if(conta2 == null) {
//			printStream.println("Digite o saldo inicial da conta 2: ");
//			
//			InputStream in = System.in;
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader br = new BufferedReader(isr);
//			String linha = br.readLine();
//			Double saldo = new Double(linha);
//			
//			conta2 = new Conta();
//			conta2.setSaldo(saldo);
//		}
//		
//		em.getTransaction().begin();
//		em.persist(conta1);
//		em.persist(conta2);
//		em.getTransaction().commit();
//		em.close();
//		
//		printStream.println("Saldo conta1: " + conta1.getSaldo() + " Saldo conta2: " + conta2.getSaldo());
//		
//		printStream.println("Informe o valor da transferencia de conta1 para conta2: ");
//		
//		InputStream in = System.in;
//		InputStreamReader isr = new InputStreamReader(in);
//		BufferedReader br = new BufferedReader(isr);
//		String linha = br.readLine();
//		Double valorTransferencia = new Double(linha);
//		
//		em = factory.createEntityManager();
//		em.getTransaction().begin();
//		conta1.setSaldo(conta1.getSaldo() - valorTransferencia);
//		conta2.setSaldo(conta2.getSaldo() + valorTransferencia);
//		
//		em.merge(conta1);
//		em.merge(conta2);
//		
//		if(conta1.getSaldo() > 0) {
//			em.getTransaction().commit();
//			printStream.println("transferencia realizada com sucesso!");
//		}
//		else {
//			em.getTransaction().rollback();
//			printStream.println("erro ao realizar transferencia");
//		}
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
