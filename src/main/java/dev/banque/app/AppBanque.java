package dev.banque.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.banque.model.Adresse;
import dev.banque.model.AssuranceVie;
import dev.banque.model.Banque;
import dev.banque.model.Clientb;
import dev.banque.model.Compte;
import dev.banque.model.LivretA;
import dev.banque.model.Operation;
import dev.banque.model.Virement;

public class AppBanque {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppBanque.class);

	/**
	 * Retourne une instance de Banque
	 * 
	 * @param name
	 * @return Banque
	 */
	public static Banque createBank(String name) {
		Banque banque = new Banque();
		banque.setNom(name);
		return banque;
	}

	/**
	 * Retourne une instance d'Adresse
	 * 
	 * @param codePostal
	 * @param numRue
	 * @param libelleRue
	 * @param ville
	 * @return Adresse
	 */
	public static Adresse createAdress(int codePostal, int numRue, String libelleRue, String ville) {
		Adresse adresse = new Adresse();
		adresse.setCodePostal(codePostal);
		adresse.setNumero(numRue);
		adresse.setRue(libelleRue);
		adresse.setVille(ville);
		return adresse;
	}

	/**
	 * Retourne une instance de Clientb
	 * 
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param banque
	 * @param adresse
	 * @return Clientb
	 */
	public static Clientb createClient(String nom, String prenom, LocalDate dateNaissance, Banque banque,
			Adresse adresse) {
		Clientb client = new Clientb();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setDateNaissance(dateNaissance);
		client.setBanque(banque);
		client.setAdresse(adresse);
		return client;
	}

	/**
	 * Retourne une instance de Compte
	 * 
	 * @param identifiantCompte
	 * @param solde
	 * @return Compte
	 */
	public static Compte createCompte(String identifiantCompte, double solde) {
		Compte compte = new Compte();
		compte.setNumero(identifiantCompte);
		compte.setSolde(solde);
		return compte;
	}

	/**
	 * Retourne une instance d'AssuranceVie
	 * 
	 * @param identifiantCompte
	 * @param solde
	 * @param taux
	 * @param dateFin
	 * @return AssuranceVie
	 */
	public static AssuranceVie createAssuranceVie(String identifiantCompte, double solde, double taux,
			LocalDate dateFin) {
		AssuranceVie compte = new AssuranceVie();
		compte.setNumero(identifiantCompte);
		compte.setSolde(solde);
		compte.setTaux(taux);
		compte.setDateFin(dateFin);
		return compte;
	}

	/**
	 * Retourne une instance de LivretA
	 * 
	 * @param identifiantCompte
	 * @param solde
	 * @param taux
	 * @return LivretA
	 */
	public static LivretA createLivretA(String identifiantCompte, double solde, double taux) {
		LivretA compte = new LivretA();
		compte.setNumero(identifiantCompte);
		compte.setSolde(solde);
		compte.setTaux(taux);
		return compte;
	}

	/**
	 * Retourne une instance d'Operation
	 * 
	 * @param compte
	 * @param date
	 * @param montant
	 * @param motif
	 * @return Operation
	 */
	public static Operation createOperation(Compte compte, LocalDateTime date, double montant, String motif) {
		Operation operation = new Operation();
		operation.setCompte(compte);
		operation.setDate(date);
		operation.setMontant(montant);
		operation.setMotif(motif);
		return operation;
	}

	/**
	 * Retourne une instance de Virement
	 * 
	 * @param compte
	 * @param date
	 * @param montant
	 * @param motif
	 * @param beneficiaire
	 * @return Virement
	 */
	public static Virement createVirement(Compte compte, LocalDateTime date, double montant, String motif,
			String beneficiaire) {
		Virement virement = new Virement();
		virement.setCompte(compte);
		virement.setDate(date);
		virement.setMontant(montant);
		virement.setMotif(motif);
		virement.setBeneficiaire(beneficiaire);
		return virement;
	}

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");

		// Création de banques test
		Banque banque = createBank("Ma super banque");
		Banque banque2 = createBank("Banque à Picsou");
		Banque banque3 = createBank("Banque Love Money");

		// Création de comptes test
		AssuranceVie compte = createAssuranceVie("1c", 1000.0, 10.0, LocalDate.now());
		AssuranceVie compte1 = createAssuranceVie("2c", 1000.0, 10.0, LocalDate.now());
		AssuranceVie compte2 = createAssuranceVie("3c", 1000.0, 10.0, LocalDate.now());
		LivretA compte3 = createLivretA("4c", 1000.0, 5.0);
		Compte compte4 = createCompte("5c", 500.0);

		// Création des opérations de test
		Virement op1 = createVirement(compte1, LocalDateTime.now(), 100.0, "salaire", "Bob Lennon");
		Virement op2 = createVirement(compte2, LocalDateTime.now(), 100.0, "cadeau", "Bob Lemon");
		Operation op3 = createOperation(compte, LocalDateTime.now(), 100.0, "impôts");

		// Création d'adresses de test
		Adresse adresse1 = createAdress(75000, 2, "Rue bidon", "Paris");
		Adresse adresse2 = createAdress(31000, 2, "Rue inconnue", "Toulouse");
		Adresse adresse3 = createAdress(44000, 2, "Rue connue", "Nantes");

		// Création de clients test
		Clientb client1 = createClient("Lanvin", "Gérard", LocalDate.now(), banque, adresse1);
		Clientb client2 = createClient("Bidon", "Bob", LocalDate.now(), banque2, adresse2);
		Clientb client3 = createClient("Bidon", "Martha", LocalDate.now(), banque2, adresse2);
		Clientb client4 = createClient("Kent", "Clark", LocalDate.now(), banque3, adresse3);

		// Jonction entre les comptes et leur client
		List<Compte> compteClient1 = new ArrayList<>();
		compteClient1.add(compte);
		client1.setComptes(compteClient1);

		List<Compte> compteClient2 = new ArrayList<>();
		compteClient2.add(compte1);
		client2.setComptes(compteClient2);
		client3.setComptes(compteClient2);

		List<Compte> compteClient3 = new ArrayList<>();
		compteClient3.add(compte3);
		compteClient3.add(compte4);
		client4.setComptes(compteClient3);

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
		listBanque.forEach(b -> em.persist(b));
		tx.commit();

		tx.begin();
		listCompte.forEach(co -> em.persist(co));
		tx.commit();

		tx.begin();
		listOperation.forEach(op -> em.persist(op));
		tx.commit();

		tx.begin();
		listClients.forEach(c -> em.persist(c));
		tx.commit();

		em.close();

		/*
		 * Cette partie sert à afficher quelques informations tirées de la base
		 * de données une fois qu'elle est crée
		 */

		EntityManager em2 = emf.createEntityManager();

		// Afficher les clients
		TypedQuery<Clientb> requeteClient = em2.createQuery("select c from Clientb c", Clientb.class);
		List<Clientb> clientsList = requeteClient.getResultList();

		LOGGER.info("-------------");
		LOGGER.info("Liste des clients:");
		LOGGER.info("-------------");

		clientsList.forEach(client -> {
			LOGGER.info("-------------");
			LOGGER.info(client.getNom());
			LOGGER.info(client.getPrenom());
			LOGGER.info(client.getAdresse().getVille());
			LOGGER.info("-------------");
		});
		em2.close();

		EntityManager em3 = emf.createEntityManager();

		TypedQuery<Compte> requeteCompte = em3.createQuery("select co from Compte co", Compte.class);
		List<Compte> comptesList = requeteCompte.getResultList();

		LOGGER.info("-------------");
		LOGGER.info("Liste des ccomptes:");
		LOGGER.info("-------------");

		comptesList.forEach(co -> {
			LOGGER.info("-------------");
			LOGGER.info("id: " + co.getId());
			LOGGER.info(co.getNumero());
			LOGGER.info("solde: " + co.getSolde());
			LOGGER.info("titulaires:");

			for (Clientb c : co.getClientbs()) {
				LOGGER.info(c.getNom() + "-" + c.getPrenom());
			}

			LOGGER.info("opérations:");

			for (Operation oper : co.getOperations()) {
				LOGGER.info(oper.getMotif() + "-" + oper.getMontant());
			}

			LOGGER.info("-------------");
		});
		em3.close();

		EntityManager em4 = emf.createEntityManager();

		TypedQuery<LivretA> requeteLivretA = em4.createQuery("select la from LivretA la", LivretA.class);
		List<LivretA> livretList = requeteLivretA.getResultList();

		LOGGER.info("-------------");
		LOGGER.info("Liste des livrets A:");
		LOGGER.info("-------------");

		livretList.forEach(la -> {
			LOGGER.info("-------------");
			LOGGER.info("id: " + la.getId());
			LOGGER.info(la.getNumero());
			LOGGER.info("solde: " + la.getSolde());
			LOGGER.info("taux: " + la.getTaux());
			LOGGER.info("-------------");
		});
		em4.close();

		emf.close();
	}

}
