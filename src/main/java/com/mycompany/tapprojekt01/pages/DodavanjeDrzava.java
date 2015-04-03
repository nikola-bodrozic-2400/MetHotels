package com.mycompany.tapprojekt01.pages;

import com.mycompany.tapprojekt01.entities.Drzave;
import java.util.ArrayList;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author student
 */
public class DodavanjeDrzava {

    @Property
    private Drzave drzava;
    @Inject
    private Session session;
    @Property
    private ArrayList<Drzave> drzave;

    void onActivate() {
        if (drzave == null) {
            drzave = new ArrayList<Drzave>();
        }
// createCriteria metoda pravi Select * upit nad prosleðenom klasom
        drzave = (ArrayList<Drzave>) session.createCriteria(Drzave.class).list();
    }

    @CommitAfter
    Object onSuccess() {
        // persist metoda èuva objekatu bazi podataka
        session.persist(drzava);
        return this;
    }
}