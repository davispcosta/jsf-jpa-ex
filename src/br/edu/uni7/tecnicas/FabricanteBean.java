package br.edu.uni7.tecnicas;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@ManagedBean
public class FabricanteBean {
	private EntityManagerFactory factory;

	public FabricanteBean() {
		factory = Persistence.createEntityManagerFactory("uni7-pu");
	}

	public List<Fabricante> getFabricantes() {
		List<Fabricante> fabricantes = new ArrayList<>();

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("select f from Fabricante f");
		fabricantes = query.getResultList();
		em.getTransaction().commit();

		return fabricantes;
	}
}
