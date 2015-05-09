/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt.dao;

import com.mycompany.tapprojekt01.entities.Gosti;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author hammond
 */
public class GostiDaoImpl implements GostiDao{
    @Inject
    private Session session;

    @Override
    public List<Gosti> getListaSvihGost() {
        return session.createCriteria(Gosti.class).list();
    }

    @Override
    public Gosti getGostById(Integer id) {
        return (Gosti) session.createCriteria(Gosti.class).add(Restrictions.eq("id", id)).uniqueResult();

    }

    @Override
    public void dodajGost(Gosti gost) {
        session.persist(gost);
    }

    @Override
    public void obrisiGost(Integer id) {
        Gosti gost = (Gosti) session.createCriteria(Gosti.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(gost);
    }    
}
