package com.cid;

import java.util.Scanner;

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
		

	}

	private static void afficherMenu() {
		System.out.println("-- MENU --");
		System.out.println("1- Ajouter un contact");
		System.out.println("Q- Quitter");

	}

}
