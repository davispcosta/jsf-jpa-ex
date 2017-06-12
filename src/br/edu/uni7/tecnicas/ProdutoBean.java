package br.edu.uni7.tecnicas;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@ManagedBean
public class ProdutoBean {
	private EntityManagerFactory factory;

	public ProdutoBean() {
		factory = Persistence.createEntityManagerFactory("uni7-pu");
	}

	private Produto produto = new Produto();
	
	public String inserir(){
		String next = "produtos";
		
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist(produto);
		produto = new Produto();
		
		em.getTransaction().commit();
		
		return next;
	}

	public List<Produto> getProdutos() {
		List<Produto> produtos = new ArrayList<>();

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("select p from Produto p");
		produtos = query.getResultList();
		em.getTransaction().commit();

		return produtos;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
