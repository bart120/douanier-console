package com.cid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.cid.metier.Contact;

public class Program {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {

			afficherMenu();
			System.out.println("Votre choix ?");
			String choix = scan.nextLine();

			switch (choix) {
			case "1":
				ajouterContact();
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

	private static void ajouterContact() {
		Contact c = new Contact();

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

	}

	private static void afficherMenu() {
		System.out.println("-- MENU --");
		System.out.println("1- Ajouter un contact");
		System.out.println("Q- Quitter");

	}

}
