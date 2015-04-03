/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.pages;

import com.mycompany.tapprojekt01.entities.Soba;
import java.util.ArrayList;
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
    @Inject
    private Session session;
    @Property
    private ArrayList<Soba> sobe;

    void onActivate() {
        if (sobe == null) {
            sobe = new ArrayList<Soba>();
        }
// createCriteria metoda pravi Select * upit nad prosleðenom klasom
        sobe = (ArrayList<Soba>) session.createCriteria(Soba.class).list();
    }

    @CommitAfter
    Object onSuccess() {
        // persist metoda èuva objekatu bazi podataka
        session.persist(soba);
        return this;
    }
}
