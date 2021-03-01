package com.cid.metier;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

	public void setMail(String mail) throws ParseException  {
		Pattern pat = Pattern.compile("^[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]{2,}\\.[a-zA-Z.]{2,5}$");
		Matcher test = pat.matcher(mail);
		if (test.matches()) {
			this.mail = mail;
		} else {
			throw new ParseException("Format du mail incorrect.", 0);
		}
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

	public Contact(String nom, String prenom, String mail, Date dateNaissance) throws ParseException {
		this(nom, prenom);
		this.setMail(mail);
		this.dateNaissance = dateNaissance;
	}

}
