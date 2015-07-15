/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.pages;

import com.mycompany.tapprojekt.dao.GostiDao;
import com.mycompany.tapprojekt.dao.SobaDao;
import com.mycompany.tapprojekt01.entities.Soba;
import java.util.List;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

/**
 *
 * @author hammond
 */
public class PrimerOsvezavanjeZone {

    @Inject
    private SobaDao sobaDao;
    
    @Property
    @Persist
    private Soba soba;
    
    @Property
    private Soba onesoba;
      
    @Property
    private List<Soba> sobe;
    
    @InjectComponent
    private Zone zoneSoba;
    
    @InjectComponent
    private Zone formZone;
    
    @Inject
    private Request request;
    
    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    void onActivate() {
        sobe = sobaDao.getListaSvihSoba();
    }

    @CommitAfter
    Object onSuccess() {
        sobaDao.dodajSoba(soba);
        sobe = sobaDao.getListaSvihSoba();
        soba = new Soba();
        if (request.isXHR()) {
            ajaxResponseRenderer.addRender(zoneSoba).addRender(formZone);
        }
        return request.isXHR() ? zoneSoba.getBody() : null;
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        sobaDao.obrisiSoba(id);
        sobe = sobaDao.getListaSvihSoba();
        return request.isXHR() ? zoneSoba.getBody() : null;
    }

    @CommitAfter
    Object onActionFromEdit(Soba drzave) {
        soba = drzave;
        return request.isXHR() ? formZone.getBody() : null;
    }
}
