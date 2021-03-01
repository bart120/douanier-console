package com.cid.metier;

import java.util.Date;

public class Contact {

	private String nom;
	private String prenom;
	private String mail;
	private Date dateNaissance;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public Contact() {
		this.dateNaissance = new Date();
		
	}

	public Contact(String nom) {
		this();
		this.nom = nom.toUpperCase();
	}
	
	public Contact(String nom, String prenom) {
		this(nom);
		this.prenom = prenom;
	}

	public Contact(String nom, String prenom, String mail, Date dateNaissance) {
		this(nom, prenom);
		this.mail = mail;
		this.dateNaissance = dateNaissance;
	}
	
	
	
	
	
}
