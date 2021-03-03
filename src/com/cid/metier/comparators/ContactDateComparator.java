package com.cid.metier.comparators;

import java.util.Comparator;

import com.cid.metier.Contact;

public class ContactDateComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) {
		return o1.getDateNaissance().compareTo(o2.getDateNaissance());
	}

}
