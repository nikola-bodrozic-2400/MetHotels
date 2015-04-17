/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.pages;

import com.mycompany.tapprojekt01.entities.Avion;
import java.util.ArrayList;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author student
 */
public class DodavanjeAviona {

    @Property
    private Avion avion;
    @Inject
    private Session session;
    @Property
    private ArrayList<Avion> avioni;

    void onActivate() {
        if (avioni == null) {
            avioni = new ArrayList<Avion>();
        }
// createCriteria metoda pravi Select * upit nad prosleðenom klasom
        avioni = (ArrayList<Avion>) session.createCriteria(Avion.class).list();
    }

    @CommitAfter
    Object onSuccess() {
        // persist metoda èuva objekatu bazi podataka
        session.persist(avion);
        return this;
    }
}
