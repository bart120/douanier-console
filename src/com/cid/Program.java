package com.cid;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.cid.metier.Contact;
import com.cid.metier.comparators.ContactDateComparator;
import com.cid.services.ServiceContact;

public class Program {

	private static Scanner scan = new Scanner(System.in);
	private static ServiceContact sc = new ServiceContact();

	public static void main(String[] args) {

		while (true) {

			afficherMenu();
			System.out.println("Votre choix ?");
			String choix = scan.nextLine();

			switch (choix) {
			case "1":
				ajouterContact();
				break;
			case "2":
				afficherContacts();
				break;
			case "3":
				trierContact();
				break;
			case "4":
				trierContactParDate();
				break;
			case "5":
				trierContactParMail();
				break;
			case "6":
				rechercherContactNom();
				break;
			case "q":
				scan.close();
				return;

			default:
				System.out.println("Saisie inconnue");
				break;
			}
			System.out.println("Appuyez sur Entrée pour continuer.");
			scan.nextLine();
		}

	}

	private static void rechercherContactNom() {
		Stream<Contact> liste =  sc.lister().stream();
		System.out.println("Saisir recherche ?");
		String saisie = scan.nextLine();
		
		/*Stream<Contact> resultat = liste.filter(new Predicate<Contact>() {
			@Override
			public boolean test(Contact t) {
				return t.getNom().contains(saisie);
			}
		});*/
		
		Stream<Contact> resultat2 = liste.filter(t -> t.getNom().contains(saisie));
		
		/*resultat2.forEach(new Consumer<Contact>() {
			@Override
			public void accept(Contact c) {
				System.out.println(c.toString());
			}
		});*/
		
		resultat2.forEach(c -> System.out.println(c.toString()));
		
		
		
		
		
	}

	private static void trierContactParMail() {
		ArrayList<Contact> liste =  sc.lister();
		
		//implementation sur classe anonyme
		Comparator<Contact> comp = new Comparator<Contact>() {
			@Override
			public int compare(Contact o1, Contact o2) {
				return o1.getMail().compareTo(o2.getMail());
			}
		};
		
		Collections.sort(liste, comp);
		
		for (Contact c : liste) {
			System.out.println(c.toString());
		}
	}

	private static void trierContactParDate() {
		ArrayList<Contact> liste =  sc.lister();
		Collections.sort(liste, new ContactDateComparator());
		
		for (Contact c : liste) {
			System.out.println(c.toString());
		}
	}

	private static void trierContact() {
		
		ArrayList<Contact> liste =  sc.lister();
		Collections.sort(liste);
		
		for (Contact c : liste) {
			System.out.println(c.toString());
		}
	}

	private static void afficherContacts() {
		ArrayList<Contact> liste =  sc.lister();
		for (Contact c : liste) {
			System.out.println(c.toString());
		}
		
	}

	private static void ajouterContact() {
		Contact c = new Contact();
		/*Object o = new Contact(); // OUI
		Contact o = new Object();// NON
		*/
		
		
		
		System.out.println("Nom ?");
		c.setNom(scan.nextLine());

		System.out.println("Prénom ?");
		c.setPrenom(scan.nextLine());
		
		do {
			System.out.println("Mail ?");
			try {
				c.setMail(scan.nextLine());
				break;
			} catch (ParseException e1) {
				System.out.println("Erreur de saisie");
			}
		} while (true);

		do {
			try {
				System.out.println("Date de naissance ?");
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				c.setDateNaissance(format.parse(scan.nextLine()));
				break;
			} catch (ParseException e) {
				System.out.println("Erreur de saisie");
			}
		} while (true);

		System.out.println(c.toString());
		
		try {
			sc.enregistrer(c);
			System.out.println("Contact enregistré.");
		} catch (IOException e) {
			System.out.println("Erreur lors de l'enregistrement.");
			e.printStackTrace();
		}
	}

	private static void afficherMenu() {
		System.out.println("-- MENU --");
		System.out.println("1- Ajouter un contact");
		System.out.println("2- Afficher les contacts");
		System.out.println("3- Trier les contacts");
		System.out.println("4- Trier les contacts par date");
		System.out.println("5- Trier les contacts par mail");
		System.out.println("6- Rechercher les contacts sur nom");
		System.out.println("Q- Quitter");

	}

}
