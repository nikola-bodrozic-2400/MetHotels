/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.pages;

import com.mycompany.tapprojekt.dao.SobaDao;
import com.mycompany.tapprojekt01.entities.Soba;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.PageLoaded;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.got5.tapestry5.jquery.components.InPlaceEditor;
import org.hibernate.Session;

public class DodavanjeSobaInPlace {

    @Property
    private Soba soba;
    @Property
    private List<Soba> sobe;
    @Property
    private Soba onesoba;
    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;
    @Inject
    private SobaDao sobaDao;
    @Inject
    private ComponentResources _componentResources;

    void onActivate() {
        sobe = sobaDao.getListaSvihSoba();
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        sobaDao.obrisiSoba(id);
        return this;
    }

    @CommitAfter
    @OnEvent(component = "imeSobe", value = InPlaceEditor.SAVE_EVENT)
    void setImeSobe(Long id, String value) {
        Soba soba = (Soba) sobaDao.getSobaById(id.intValue());
        soba.setImeSobe(value);
        System.out.println("cuvam sobu");
        sobaDao.dodajIliUpdatujSoba(soba);
    }

    @CommitAfter
    @OnEvent(component = "sprat", value = InPlaceEditor.SAVE_EVENT)
    void setSprat(Long id, int value) {
        Soba soba = (Soba) sobaDao.getSobaById(id.intValue());
        soba.setSprat(value);
        System.out.println("cuvam sprat");
        sobaDao.dodajIliUpdatujSoba(soba);
    }
}
