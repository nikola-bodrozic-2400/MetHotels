/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.pages;

import com.mycompany.tapprojekt.dao.GostiDao;
import com.mycompany.tapprojekt01.entities.Gosti;
import com.mycompany.tapprojekt01.services.ProtectedPage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author student
 */
public class DodavanjeGosti {

    @Property
    @Persist
    private Gosti gost;
    @Property
    private Gosti onegost;
    @Inject
    private GostiDao gostiDao;

    @Property
    private List<Gosti> gosti;

    void onActivate() {
        if (gosti == null) {
            gosti = new ArrayList<Gosti>();
        }
        gosti = gostiDao.getListaSvihGost();
    }

    @CommitAfter
    Object onSuccess() {
        gostiDao.dodajIliUpdatujGost(gost);
        gost = new Gosti();
        return this;
    }

    @CommitAfter
    Object onActionFromEdit(Gosti gosti) {
        gost = gosti;
        return this;
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        gostiDao.obrisiGost(id);
        return this;
    }
}
