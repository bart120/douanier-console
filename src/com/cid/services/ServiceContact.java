package com.cid.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cid.metier.Contact;

public class ServiceContact {

	private static final String FICHIER = "C:\\Users\\vlecl\\Documents\\contact.csv";

	public void enregistrer(Contact c) throws IOException {		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(FICHIER, true)));
		try {
			
			pw.println(c.toString());
			
		} finally {
			pw.close();
		}
	}
	
	public ArrayList<Contact> lister(){
		ArrayList<Contact> liste = new ArrayList<>();
		
		try(BufferedReader buf = new BufferedReader(new FileReader(FICHIER))){
			String ligne =  buf.readLine();
			while(ligne != null) {
				Contact c = new Contact();
				String[] tab = ligne.split(Contact.SEPARATEUR);
				c.setNom(tab[0]);	
				c.setPrenom(tab[1]);
				try {
					c.setMail(tab[2]);
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					c.setDateNaissance(format.parse(tab[3]));
				} catch (ParseException e) {}
				
				liste.add(c);
				
				ligne = buf.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Le " + FICHIER + " n'existe pas.");
		} catch (IOException e) {
			System.out.println("Le " + FICHIER + " n'est pas accessible.");
		}
		
		return liste;
	}

}
