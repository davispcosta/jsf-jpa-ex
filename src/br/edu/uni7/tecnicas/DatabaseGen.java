package br.edu.uni7.tecnicas;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseGen {
	public static void main(String[] args) {
		Properties config = new Properties();
		config.put("hibernate.hbm2ddl.auto", "create");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni7-pu", config);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Fabricante dell = new Fabricante(null, "Dell", "12312312");
		em.persist(dell);
		
		Produto p = new Produto(null, "notebook", 2000.0);
		em.persist(p);
		dell.adiconarProduto(p);
		
		Fabricante apple = new Fabricante(null, "Apple", "9238234734734");
		em.persist(apple);

		p = new Produto(null, "iphone 7", 3500.0);
		em.persist(p);
		apple.adiconarProduto(p);

		em.getTransaction().commit();

		em.close();
		factory.close();
	}
}