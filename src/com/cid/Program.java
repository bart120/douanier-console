package com.cid;

import java.io.Closeable;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.cid.metier.Contact;
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
		System.out.println("Q- Quitter");

	}

}
