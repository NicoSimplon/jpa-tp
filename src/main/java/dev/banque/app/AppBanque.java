package dev.banque.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.banque.model.Adresse;
import dev.banque.model.AssuranceVie;
import dev.banque.model.Banque;
import dev.banque.model.Clientb;
import dev.banque.model.Compte;
import dev.banque.model.LivretA;
import dev.banque.model.Operation;
import dev.banque.model.Virement;

public class AppBanque {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");

		// Initialisation de la base de données
		EntityManager ema = emf.createEntityManager();

//		 EntityTransaction et = ema.getTransaction();
//		 et.begin();
//		
//		 ema.persist(new Banque());
//		 ema.persist(new Clientb());
//		 ema.persist(new LivretA());
//		 ema.persist(new AssuranceVie());
//		 ema.persist(new Virement());
//		
//		 et.commit();
//		 ema.close();

		// Création de banques test

		Banque banque = new Banque();
		banque.setNom("Ma super banque");

		Banque banque2 = new Banque();
		banque2.setNom("Banque à Picsou");

		Banque banque3 = new Banque();
		banque3.setNom("Banque Love Money");

		// Création d'adresses de test

		Adresse add1 = new Adresse();
		add1.setCodePostal(75000);
		add1.setNumero(2);
		add1.setRue("Rue bidon");
		add1.setVille("Paris");

		Adresse add2 = new Adresse();
		add2.setCodePostal(31000);
		add2.setNumero(2);
		add2.setRue("Rue bidon");
		add2.setVille("Toulouse");

		Adresse add3 = new Adresse();
		add3.setCodePostal(44000);
		add3.setNumero(2);
		add3.setRue("Rue bidon");
		add3.setVille("Nantes");

		// Création de clients test
		Clientb client1 = new Clientb();
		client1.setNom("Lanvin");
		client1.setPrenom("Gérard");
		client1.setDateNaissance(LocalDate.now());
		client1.setBanque(banque);
		client1.setAdresse(add1);

		Clientb client2 = new Clientb();
		client2.setNom("Bidon");
		client2.setPrenom("Bob");
		client2.setDateNaissance(LocalDate.now());
		client2.setBanque(banque2);
		client2.setAdresse(add2);

		Clientb client3 = new Clientb();
		client3.setNom("Bidon");
		client3.setPrenom("Martha");
		client3.setDateNaissance(LocalDate.now());
		client3.setBanque(banque2);
		client3.setAdresse(add2);

		Clientb client4 = new Clientb();
		client4.setNom("Kent");
		client4.setPrenom("Clark");
		client4.setDateNaissance(LocalDate.now());
		client4.setBanque(banque3);
		client4.setAdresse(add3);

		// Création de comptes test

		AssuranceVie compte = new AssuranceVie();
		compte.setNumero("1c");
		compte.setSolde(1000.0);
		compte.setTaux(10.0);
		compte.setDateFin(LocalDate.now());

		AssuranceVie compte1 = new AssuranceVie();
		compte1.setNumero("2c");
		compte1.setSolde(1000.0);
		compte1.setTaux(10.0);
		compte1.setDateFin(LocalDate.now());

		AssuranceVie compte2 = new AssuranceVie();
		compte2.setNumero("3c");
		compte2.setSolde(1000.0);
		compte2.setTaux(10.0);
		compte2.setDateFin(LocalDate.now());
		
		LivretA compte3 = new LivretA();
		compte3.setNumero("4c");
		compte3.setSolde(1000.0);
		compte3.setTaux(5.0);

		// Création des opérations de test

		Virement op1 = new Virement();
		op1.setCompte(compte1);
		op1.setDate(LocalDateTime.now());
		op1.setMontant(100.0);
		op1.setMotif("salaire");
		op1.setBeneficiaire("Bob Lennon");

		Virement op2 = new Virement();
		op2.setCompte(compte2);
		op2.setDate(LocalDateTime.now());
		op2.setMontant(100.0);
		op2.setMotif("salaire");
		op2.setBeneficiaire("Bob Lennon");

		Virement op3 = new Virement();
		op3.setCompte(compte);
		op3.setDate(LocalDateTime.now());
		op3.setMontant(100.0);
		op3.setMotif("cadeau");
		op3.setBeneficiaire("Bob Lennon");

		// Jonction entre les comptes et leur client

		List<Compte> compteClient1 = new ArrayList<>();
		compteClient1.add(compte);
		client1.setComptes(compteClient1);

		List<Compte> compteClient2 = new ArrayList<>();
		compteClient2.add(compte1);
		client2.setComptes(compteClient2);
		client3.setComptes(compteClient2);
		
		//*
		List<Compte> compteClient3 = new ArrayList<>();
		compteClient3.add(compte3);
		client4.setComptes(compteClient3);
		//*/

		// Jonction entre les opérations et les comptes

		List<Operation> listOpe1 = new ArrayList<>();
		listOpe1.add(op1);
		compte.setOperations(listOpe1);

		List<Operation> listOpe2 = new ArrayList<>();
		listOpe2.add(op2);
		compte.setOperations(listOpe2);

		List<Operation> listOpe3 = new ArrayList<>();
		listOpe3.add(op3);
		compte.setOperations(listOpe3);

		// Rcupération des objets sous forme de listes

		List<Banque> listBanque = new ArrayList<>();
		listBanque.add(banque);
		listBanque.add(banque2);
		listBanque.add(banque3);

		List<Clientb> listClients = new ArrayList<>();
		listClients.add(client1);
		listClients.add(client2);
		listClients.add(client3);
		listClients.add(client4);

		List<Compte> listCompte = new ArrayList<>();
		listCompte.add(compte);
		listCompte.add(compte1);
		listCompte.add(compte2);
		
		List<Operation> listOperation = new ArrayList<>();
		listOperation.add(op1);
		listOperation.add(op2);
		listOperation.add(op3);

		// Création de l'entity manager

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		// Pour insérer les données
		tx.begin();
		for (Banque b : listBanque) {
			em.persist(b);
		}
		tx.commit();
		
		tx.begin();
		for (Compte co : listCompte) {
			em.persist(co);
		}
		tx.commit();
		
		tx.begin();
		for (Operation op : listOperation) {
			em.persist(op);
		}
		tx.commit();
		
		tx.begin();
		for (Clientb c : listClients) {
			em.persist(c);
		}
		tx.commit();

		em.close();
		emf.close();

	}

}
