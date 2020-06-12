//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import com.algaworks.curso.jpa2.model.Carro;
//
//public class PesquisaFoto {
//	public static void main(String[] args) {
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		Carro carro = entityManager.find(Carro.class, 3L);
//		
//		if(carro.getFoto() != null) {
//			try {
//				BufferedImage img = ImageIO.read(new ByteArrayInputStream(carro.getFoto()));
//				
//				JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}else {
//			System.out.println("Carro não possui foto cadastrada!");
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
//
//
//
//
//
//
