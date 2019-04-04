package dev.jpa_tp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class App {
	public static void main(String[] args) {

		// Etape 1 - Créer une instance d'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tp");

		// Début d'une unité de travail
		EntityManager em1 = emf.createEntityManager();
		EntityTransaction tx = em1.getTransaction();

		// début de transaction
		tx.begin();
		
		// création d'une requête
		TypedQuery<Livre> requete = em1.createQuery("select l from Livre l", Livre.class);

		List<Livre> listeLivres = requete.getResultList();

		listeLivres.forEach(unLivre -> {
			System.out.println(unLivre.getId() + " - " + unLivre.getTitre() + " - " + unLivre.getAuteur());
		});

		// recherche d'un livre en fonction de l'auteur
		TypedQuery<Livre> requete1 = em1.createQuery("select l from Livre l where TITRE = :titre", Livre.class);
		
		requete1.setParameter("titre", "formation jpa");
		
		List<Livre> livre = requete1.getResultList();

		livre.forEach(unLivre -> {
			System.out.println(unLivre.getId() + " - " + unLivre.getTitre() + " - " + unLivre.getAuteur());
		});
		
		Livre livre1 = new Livre();
		livre1.setId(201);
		livre1.setAuteur("Rossi");
		livre1.setTitre("formation jpa");
		
		// Pour faire un insert
//		em1.persist(livre1);
		
		// Pour faire une mise à jour
//		em1.merge(livre1);
		
		// fin de la transaction
		tx.commit();

		// Fin d'une unité de travail
		em1.close();

		emf.close();

	}
}
