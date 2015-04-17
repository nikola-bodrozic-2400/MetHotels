/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.pages;

import com.mycompany.tapprojekt.dao.SobaDao;
import com.mycompany.tapprojekt01.entities.Soba;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author student
 */
public class DodavanjeSoba {

     @Property
	private Soba soba;
	
	@Property
	private Soba onesoba;
	
	@Inject
	private SobaDao sobaDao;
	
	@Property
	private List <Soba> sobe;
	void onActivate() {
		if (sobe == null) {
			sobe = new ArrayList <Soba> ();
		}
		sobe = sobaDao.getListaSvihSoba();
	}
	
	@CommitAfter
	Object onSuccess() {
		sobaDao.dodajSoba(soba);
		return this;
	}
	
	@CommitAfter
	Object onActionFromDelete(int id) {
		sobaDao.obrisiSoba(id);
		return this;
	}
}
