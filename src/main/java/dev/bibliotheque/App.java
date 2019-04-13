package dev.bibliotheque;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class App {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tp");

		EntityManager em1 = emf.createEntityManager();
		EntityTransaction tx = em1.getTransaction();

		tx.begin();
		
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
		
		// Réaliser une requête qui permet d’extraire un emprunt et tous ses livres associés.
		TypedQuery<Emprunt> requeteEmprunt = em1.createQuery("SELECT e FROM Emprunt e", Emprunt.class);
		
		List<Emprunt> emprunts = requeteEmprunt.getResultList();
		
		emprunts.forEach(emprunt -> {
			System.out.println(emprunt.getId() + " - délai: " + emprunt.getDelai() + emprunt.getLivres());
		});
		
		// Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
		TypedQuery<Emprunt> requeteEmpruntClient = em1.createQuery("SELECT e FROM Emprunt e WHERE e.client.id = :id", Emprunt.class);
		requeteEmpruntClient.setParameter("id", 1);
		
		List<Emprunt> empruntClient = requeteEmpruntClient.getResultList();
		
		empruntClient.forEach(e -> {
			
			System.out.println(e.getClient().getNom() + " " + e.getClient().getPrenom() + " -> " + e.getDelai());
			
		});
		
		
		// Ajouter/Modifier un livre

		Livre livre1 = new Livre();
		livre1.setId(203);
		livre1.setAuteur("Rossi");
		livre1.setTitre("formation jpa");
		
		// Pour faire un insert
//		em1.persist(livre1);
		
		// Pour faire une mise à jour
//		em1.merge(livre1);
		
		tx.commit();

		em1.close();
		emf.close();

	}
}
